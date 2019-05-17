package com.vroom.dataservice.GoodsReceivedNote;

import com.vroom.dbmodel.orm.Grnmaster;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;

public interface GoodsReceivedNoteRepository extends CrudRepository<Grnmaster,Long> {

    @Query("SELECT grn FROM Grnmaster grn WHERE (grn.isdeleted = false) ")
    List<Grnmaster> findAll();

    @Query("SELECT grn FROM Grnmaster grn WHERE grn.id = :id AND (grn.isdeleted = false)")
    Grnmaster findById(@Param("id") int  id);

    @Query(value = "Select grn.id, grn.poid as poId, po.insertedtime as poCreationDate,v.name as vendorName, " +
                    "grn.insertedtime as receivedDate,user.name as userName, sum(grnd.amount) as amount " +
                    "From grnmaster grn " +
                    "INNER JOIN pomaster po ON (po.id = grn.poid and grn.isdeleted = false) " +
                    "INNER JOIN vendor v ON (v.id = po.vendorid) " +
                    "INNER JOIN grndetail grnd ON (grnd.grnid = grn.id) " +
                    "INNER JOIN users user ON (user.id = grn.userid) " +
                    "WHERE  v.id = :vendorId AND (grn.isdeleted = false) " +
                    "GROUP BY grn.id, grn.poid,v.name, grn.insertedtime,user.name " +
                    "ORDER BY grn.insertedtime desc", nativeQuery = true)
    Collection<GoodsReceivedNoteList> findByVendorId(@Param("vendorId") int  vendorId);

    @Query(value = "Select grn.id, grn.poid as poId, po.insertedtime as poCreationDate,v.name as vendorName, " +
                    "grn.insertedtime as receivedDate,user.name as userName, sum(grnd.amount) as amount " +
                    "From grnmaster grn " +
                    "INNER JOIN pomaster po ON (po.id = grn.poid and grn.isdeleted = false) " +
                    "INNER JOIN vendor v ON (v.id = po.vendorid) " +
                    "INNER JOIN grndetail grnd ON (grnd.grnid = grn.id) " +
                    "INNER JOIN users user ON (user.id = grn.userid) " +
                    "WHERE (grn.isdeleted = false) " +
                    "GROUP BY grn.id, grn.poid,v.name, grn.insertedtime,user.name " +
                    "ORDER BY grn.insertedtime desc", nativeQuery = true)
    Collection<GoodsReceivedNoteList> findAllGRNs();

    @Query(value = "Select grn.id, grn.poid as poId, po.insertedtime as poCreationDate,v.name as vendorName, " +
                    " grn.insertedtime as receivedDate,user.name as userName, grnd.quantity as productQuantity, " +
                    " p.productcost as productCost,   0 as amount, p.name as productName" +
                    " From grnmaster grn " +
                    " INNER JOIN pomaster po ON (po.id = grn.poid and grn.isdeleted = false) " +
                    " INNER JOIN vendor v ON (v.id = po.vendorid) " +
                    " INNER JOIN grndetail grnd ON (grnd.grnid = grn.id) " +
                    " INNER JOIN users user ON (user.id = grn.userid) " +
                    " INNER JOIN product p ON (grnd.productid = p.id) " +
                    " WHERE grn.id in :grnList and (grn.isdeleted = false) " +
                    " GROUP BY grn.id, grn.poid,v.name, grn.insertedtime,user.name " +
                    " ORDER BY grn.insertedtime desc", nativeQuery = true)
    Collection<GoodReceivedNoteProductList> findGRNById(@Param("grnList") Number ... grnList);
}
