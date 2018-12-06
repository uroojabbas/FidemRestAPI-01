package com.vroom.dataservice.common;

public enum Region {

    Head_Office,
    North,
    South,
    Central;

    public int getValue() {
        return ordinal() + 1;
    }
}
