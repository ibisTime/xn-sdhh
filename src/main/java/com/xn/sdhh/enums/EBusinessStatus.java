package com.xn.sdhh.enums;

public enum EBusinessStatus {

    ARCHIVE_NO("0", "未归档"), ARCHIVE_YES("1", "已归档");

    EBusinessStatus(String code, String value) {
        this.code = code;
        this.value = value;
    }

    private String code;

    private String value;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
