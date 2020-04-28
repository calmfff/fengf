package com.feng.design.Enum;

import java.util.HashMap;
import java.util.Map;

public enum IsDeleteEnum {
    ISDELETE(false, "未启用"),
    NOT_DELETE(true, "启用");
    private Boolean code;

    private String msg;

    IsDeleteEnum(Boolean code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private static Map<Boolean, IsDeleteEnum> isDeleteMap;

    static {
        isDeleteMap = new HashMap<>();
        IsDeleteEnum[] values = IsDeleteEnum.values();
        for (IsDeleteEnum value : values) {
            isDeleteMap.put(value.code, value);
        }
    }


    public static IsDeleteEnum valueOf(Boolean code) {
        return isDeleteMap.get(code);
    }

    public Boolean getCode() {
        return code;
    }

    public IsDeleteEnum setCode(Boolean code) {
        this.code = code;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public IsDeleteEnum setMsg(String msg) {
        this.msg = msg;
        return this;
    }

}
