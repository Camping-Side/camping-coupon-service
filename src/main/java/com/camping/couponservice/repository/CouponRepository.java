package com.camping.couponservice.repository;

import com.camping.couponservice.domain.entity.Coupon;
import com.camping.couponservice.repository.dsl.CouponRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CouponRepository extends JpaRepository<Coupon, Long>, CouponRepositoryCustom {

}
