package com.aresning.impl;

import com.alibaba.fastjson.JSON;
import com.aresning.ICommodity;
import org.itstack.demo.design.AwardReq;
import org.itstack.demo.design.AwardRes;
import org.itstack.demo.design.coupon.CouponResult;
import org.itstack.demo.design.coupon.CouponService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created with Intellij IDEA
 * <h3>itstack-demo-design<h3>
 *
 * @author : AresNing
 * @date : 2023-09-23 15:40
 * @description :
 */
public class CouponCommodityService implements ICommodity {

    private static final Logger logger = LoggerFactory.getLogger(CouponCommodityService.class);

    private CouponService couponService = new CouponService();

    @Override
    public void sendCommodity(AwardReq req) throws Exception {
        CouponResult couponResult = couponService.sendCoupon(req.getuId(), req.getAwardNumber(), req.getBizId());
        logger.info("请求参数[优惠券] => uId：{} commodityId：{} bizId：{} extMap：{}", req.getuId(), req.getAwardNumber(), req.getBizId(), req.getExtMap());
        logger.info("测试结果[优惠券]：{}", JSON.toJSON(couponResult));
        if (!"0000".equals(couponResult.getCode())) {
            throw new RuntimeException(couponResult.getInfo());
        }
    }
}
