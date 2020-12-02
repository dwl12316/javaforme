package com.neusoft.sellspringboot.enums;

import lombok.Getter;

@Getter
public enum PayStatus implements CodeEnum{
    WAIT(0,"等待支付"),SUCCESS(1,"已支付")
    ;

    PayStatus(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    private Integer code;
    private String message;
}
