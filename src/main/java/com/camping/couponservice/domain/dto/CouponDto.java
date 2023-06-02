package com.camping.couponservice.domain.dto;

import com.camping.common.domain.dto.PageDto;
import com.camping.couponservice.domain.enums.UseType;
import com.camping.couponservice.domain.enums.coupon.CouponStatus;
import com.camping.couponservice.domain.enums.coupon.CouponType;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.time.LocalDateTime;

public class CouponDto extends PageDto {
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ResAdminList {
        @ApiModelProperty(value = "쿠폰 id")
        private Long cpnId;
        @ApiModelProperty(value = "쿠폰 상태값(STOP: 정지, ISSUE : 발급)")
        private CouponStatus cpnSts ;
        @ApiModelProperty(value = "쿠폰 타입(NORMAL: 일반)")
        private CouponType cpnTp;
        @ApiModelProperty(value = "재발급여부 Y/N")
        private UseType reissueYn;
        @ApiModelProperty(value = "사용기한")
        private Integer usePeriod;
        @ApiModelProperty(value = "발급가능 시작일 8자리 YYYY-MM-DD")
        private LocalDateTime startDate;
        @ApiModelProperty(value = "발급가능 종료일 8자리 YYYY-MM-DD")
        private LocalDateTime endDate;
        @ApiModelProperty(value = "발급개수")
        private Integer issueCnt;
        @ApiModelProperty(value = "발급제한개수")
        private Integer limitIssueCnt;
        @ApiModelProperty(value = "생성일 YYYY-MM-DD")
        private String createdDate;
        @ApiModelProperty(value = "생성 id")
        private Long createdBy;
        @ApiModelProperty(value = "수정일 YYYY-MM-DD")
        private String lastModifiedDate;
        @ApiModelProperty(value = "수정 id")
        private Long lastModifiedBy;
    }

    @Data
    public static class ReqAdminList extends PageDto {
        @ApiModelProperty(value = "쿠폰 id")
        private Long cpnId;
        @ApiModelProperty(value = "쿠폰 상태값(STOP: 정지, ISSUE : 발급)")
        private CouponStatus cpnSts ;
        @ApiModelProperty(value = "쿠폰 타입(NORMAL: 일반)")
        private CouponType cpnTp;
        @ApiModelProperty(value = "재발급여부 Y/N")
        private UseType reissueYn;
        @ApiModelProperty(value = "발급가능 시작일 8자리 YYYYMMDD")
        private String startDate;
        @ApiModelProperty(value = "발급가능 종료일 8자리 YYYYMMDD")
        private String endDate;
    }
}
