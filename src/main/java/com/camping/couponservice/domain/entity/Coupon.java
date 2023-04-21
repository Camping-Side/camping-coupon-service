package com.camping.couponservice.domain.entity;

import com.camping.couponservice.domain.enums.UseType;
import com.camping.couponservice.domain.enums.coupon.CouponStatus;
import com.camping.couponservice.domain.enums.coupon.CouponType;
import com.camping.common.domain.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "coupon")
public class Coupon extends BaseEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cpn_id")
    private Long cpnId;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "cpn_sts")
    private CouponStatus cpnSts = CouponStatus.STOP;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "cpn_tp")
    private CouponType cpnTp = CouponType.NORMAL;

    @Enumerated(EnumType.STRING)
    @Column(name = "reissue_yn")
    private UseType reissueYn = UseType.N;

    @Column(name = "use_period")
    private Integer usePeriod;

    @Column(name = "start_date")
    private LocalDateTime startDate;

    @Column(name = "end_date")
    private LocalDateTime endDate;

    @Column(name = "issue_cnt")
    private Integer issueCnt;

    @Column(name = "limit_issue_cnt")
    private Integer limitIssueCnt;


}
