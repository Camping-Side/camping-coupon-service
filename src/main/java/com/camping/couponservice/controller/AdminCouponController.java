package com.camping.couponservice.controller;

import com.camping.common.domain.dto.ResultDto;
import com.camping.couponservice.domain.dto.CouponDto;
import com.camping.couponservice.service.CouponService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/admin/coupons")
public class AdminCouponController {
    private final CouponService couponService;

    @ApiOperation(value="쿠폰 리스트 조회", notes = "쿠폰 리스트 조회")
    @GetMapping
    public ResultDto<Page<CouponDto.ResAdminList>> getCoupons(@RequestBody @Validated CouponDto.ReqAdminList req) {
        return ResultDto.res(couponService.getAdminCoupons(req));
    }
}
