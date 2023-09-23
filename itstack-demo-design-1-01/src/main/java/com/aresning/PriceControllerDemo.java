package com.aresning;

import com.alibaba.fastjson.JSON;
import org.itstack.demo.design.AwardReq;
import org.itstack.demo.design.AwardRes;
import org.itstack.demo.design.card.IQiYiCardService;
import org.itstack.demo.design.coupon.CouponResult;
import org.itstack.demo.design.coupon.CouponService;
import org.itstack.demo.design.goods.DeliverReq;
import org.itstack.demo.design.goods.GoodsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created with Intellij IDEA
 * <h3>itstack-demo-design<h3>
 *
 * @author : AresNing
 * @date : 2023-09-23 14:33
 * @description :
 */
public class PriceControllerDemo {

    private static final Logger logger = LoggerFactory.getLogger(PriceControllerDemo.class);

    public AwardRes awardToUser(AwardReq req) {
        AwardRes awardRes = null;
        try {
            logger.info("奖品发放开始, reqUid:{}, req:{}", req.getuId(), JSON.toJSONString(req));
            // 按照不同类型方法商品[1优惠券、2实物商品、3第三方兑换卡(爱奇艺)]
            switch(req.getAwardType()) {
                case 1:
                    CouponService couponService = new CouponService();
                    CouponResult couponResult = couponService.sendCoupon(req.getuId(), req.getAwardNumber(), req.getBizId());
                    awardRes = "0000".equals(couponResult.getCode()) ?
                            new AwardRes("0000", "发放成功") : new AwardRes("0001", couponResult.getInfo());
                    break;
                case 2:
                    GoodsService goodsService = new GoodsService();
                    DeliverReq deliverReq = new DeliverReq();
                    deliverReq.setUserName(queryUserNameByuId(req.getuId()));
                    deliverReq.setUserPhone(queryUserPhoneNumber(req.getuId()));
                    deliverReq.setSku(req.getAwardNumber());
                    deliverReq.setOrderId(req.getBizId());
                    deliverReq.setConsigneeUserName(req.getExtMap().get("consigneeUserName"));
                    deliverReq.setConsigneeUserPhone(req.getExtMap().get("consigneeUserPhone"));
                    deliverReq.setConsigneeUserAddress(req.getExtMap().get("consigneeUserAddress"));
                    Boolean isSuccess = goodsService.deliverGoods(deliverReq);
                    awardRes = isSuccess ?
                            new AwardRes("0000", "发放成功") : new AwardRes("0001", "发放失败");
                case 3:
                    IQiYiCardService iQiYiCardService = new IQiYiCardService();
                    iQiYiCardService.grantToken(queryUserPhoneNumber(req.getuId()), req.getAwardNumber());
                    awardRes = new AwardRes("0000", "发放成功");
            }
            logger.info("奖品发放完成, reqUid:{}", req.getuId());
        } catch (Exception e) {
            logger.error("奖品发放失败, reqUid:{}, req:{}", req.getuId(), JSON.toJSONString(req), e);
            awardRes = new AwardRes("0001", e.getMessage());
        }
        return awardRes;
    }

    private String queryUserNameByuId(String uId) {
        return "花花";
    }

    private String queryUserPhoneNumber(String uId) {
        return "15200101232";
    }

}
