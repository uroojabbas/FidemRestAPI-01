package com.vroom.dataservice.po;

public enum  POStatusType {
    PO_PENDING_APPROVAL,
    PO_APPROVED,
    PARTIAL_INVENTORY_RECEIVED,
    COMPLETE_INVENTORY_RECEIVED,
    INVOICE_RECEIVED,
    PARTIAL_PAYMENT_DISPATCHED,
    COMPLETE_PAYMENT_DISPATCHED,
    REJECTED,
    CANCELLED,
    TO_INVENTORY_RECEIVED,
    TO_INVENTORY_DISPATCHED;

    public int getValue() {
        return ordinal() + 1;
    }
}
