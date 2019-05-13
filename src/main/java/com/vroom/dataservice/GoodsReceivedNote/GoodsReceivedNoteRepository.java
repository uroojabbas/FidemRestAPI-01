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

    @Query("SELECT grn FROM Grnmaster grn WHERE grn.pomaster.vendor.id = :vendorId AND (grn.isdeleted = false)")
    Collection<Grnmaster> findByVendorId(@Param("vendorId") int  vendorId);

    @Query(value = "Select grn.id, grn.poid as poId, po.insertedtime as poCreationDate,v.name as vendorName, " +
            "grn.insertedtime as receivedDate,user.name as userName, sum(grnd.amount) as amount " +
            "From grnmaster grn " +
            "INNER JOIN pomaster po ON (po.id = grn.poid and grn.isdeleted = false) " +
            "INNER JOIN vendor v ON (v.id = po.vendorid) " +
            "INNER JOIN grndetail grnd ON (grnd.grnid = grn.id) " +
            "INNER JOIN users user ON (user.id = grn.userid) " +
            "GROUP BY grn.id, grn.poid,v.name, grn.insertedtime,user.name " +
            "ORDER BY grn.insertedtime desc;", nativeQuery = true)
    Collection<GoodsReceivedNoteList> findAllGRNs();
}
