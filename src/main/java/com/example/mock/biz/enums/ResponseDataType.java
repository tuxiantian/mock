package com.example.mock.biz.enums;

public enum ResponseDataType {
    JSON(1),XML(2);
    private int val;

    ResponseDataType(int val) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }
}
