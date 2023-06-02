package com.camping.couponservice.repository.dsl.impl;

import com.camping.common.util.dsl.DslDateUtil;
import com.camping.common.util.dsl.DslUtil;
import com.camping.couponservice.domain.dto.CouponDto;
import com.camping.couponservice.repository.dsl.CouponRepositoryCustom;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

import static com.camping.couponservice.domain.entity.QCoupon.coupon;

@RequiredArgsConstructor
public class CouponRepositoryImpl implements CouponRepositoryCustom {
    private final JPAQueryFactory query;

    @Override
    public Page<CouponDto.ResAdminList> findAllAdminCoupon(Pageable pageable, CouponDto.ReqAdminList reqDto) {
        List<CouponDto.ResAdminList> result = query
                .select(
                        Projections.constructor(CouponDto.ResAdminList.class,
                                coupon.cpnId
                                , coupon.cpnSts
                                , coupon.cpnTp
                                , coupon.reissueYn
                                , coupon.usePeriod
                                , DslDateUtil.getYMDFormat(coupon.startDate, DslDateUtil.READ_DATE_FORMAT)
                                , DslDateUtil.getYMDFormat(coupon.endDate, DslDateUtil.READ_DATE_FORMAT)
                                , coupon.issueCnt
                                , coupon.limitIssueCnt
                                , DslDateUtil.getYMDFormat(coupon.createdDate, DslDateUtil.READ_DATE_FORMAT)
                                , coupon.createdBy
                                , DslDateUtil.getYMDFormat(coupon.lastModifiedDate, DslDateUtil.READ_DATE_FORMAT)
                                , coupon.lastModifiedBy
                        )
                )
                .from(coupon)
                .where(
                        DslUtil.cprEq(coupon.cpnId, reqDto.getCpnId())
                        , DslUtil.cprEq(coupon.cpnTp, reqDto.getCpnTp())
                        , DslUtil.cprEq(coupon.cpnSts, reqDto.getCpnSts())
                        , DslUtil.cprEq(coupon.reissueYn, reqDto.getReissueYn())
                        , DslDateUtil.cprStartDate(coupon.startDate, reqDto.getStartDate())
                        , DslDateUtil.cprEndDate(coupon.endDate, reqDto.getEndDate())
                )
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        long total = result.size();

        return new PageImpl<>(result, pageable, total);
    }
}
