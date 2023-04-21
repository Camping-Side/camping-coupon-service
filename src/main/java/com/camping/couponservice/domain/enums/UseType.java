package com.camping.couponservice.domain.enums;

import lombok.Getter;

@Getter
public enum UseType {
    Y("YES"),
    N("NO")
    ;

    private String name;

    UseType(String name) {
        this.name = name;
    }
}
