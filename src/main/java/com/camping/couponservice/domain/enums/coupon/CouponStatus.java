package com.camping.couponservice.domain.enums.coupon;

import lombok.Getter;

@Getter
public enum CouponStatus {
    STOP("중지"),
    ISSUE("발급"),
    ;

    private String name;

    CouponStatus(String name) {
        this.name = name;
    }
}
