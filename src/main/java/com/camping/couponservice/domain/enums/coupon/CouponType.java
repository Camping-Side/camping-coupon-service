package com.camping.couponservice.domain.enums.coupon;

import lombok.Getter;

@Getter
public enum CouponType {
    NORMAL("일반");

    private String name;

    CouponType(String name) {
        this.name = name;
    }
}
