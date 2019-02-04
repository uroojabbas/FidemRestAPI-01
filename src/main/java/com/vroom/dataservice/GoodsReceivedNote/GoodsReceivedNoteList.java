package com.vroom.dataservice.GoodsReceivedNote;

import org.apache.commons.lang3.time.DateFormatUtils;

import java.util.Date;

public interface GoodsReceivedNoteList {

    public int getId();
    public int getPoId();
    public String getVendorName();
    public Date getReceivedDate();
    public String getUserName();
    public double getAmount();
    public Date getPoCreationDate();

    default String getPurchaseOrderId(){
        return "PO-" + this.getPoId() + "-" + DateFormatUtils.format(this.getPoCreationDate(), "yyyy");
    }

    default String getGrnId(){
        return "GRN-" + this.getId() + "-" + DateFormatUtils.format(this.getReceivedDate(), "yyyy");
    }


}
