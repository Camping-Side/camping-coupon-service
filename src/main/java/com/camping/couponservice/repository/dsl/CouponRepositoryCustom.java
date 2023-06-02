package com.camping.couponservice.repository.dsl;

import com.camping.couponservice.domain.dto.CouponDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CouponRepositoryCustom {
    Page<CouponDto.ResAdminList> findAllAdminCoupon(Pageable pageable, CouponDto.ReqAdminList reqDto);
}
