package com.camping.couponservice.service;

import com.camping.common.util.CustomUtil;
import com.camping.couponservice.domain.dto.CouponDto;
import com.camping.couponservice.repository.CouponRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CouponService {
    private final CouponRepository couponRepository;

    public Page<CouponDto.ResAdminList> getAdminCoupons(CouponDto.ReqAdminList req) {
        return couponRepository.findAllAdminCoupon(CustomUtil.convertPageVo(req), req);
    }
}
