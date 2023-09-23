package com.aresning;

import org.itstack.demo.design.AwardReq;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with Intellij IDEA
 * <h3>itstack-demo-design<h3>
 *
 * @author : AresNing
 * @date : 2023-09-23 16:22
 * @description :
 */
public class ApiTest {
    @Test
    public void test_commodity() throws Exception {
        StoreFactory storeFactory = new StoreFactory();
        // 优惠券
        ICommodity commodityService1 = storeFactory.getCommodityService(CommodityType.COUPON);
        AwardReq awardReq1 = new AwardReq();
        awardReq1.setuId("10001");
        awardReq1.setAwardNumber("EGM1023938910232121323432");
        awardReq1.setBizId("791098764902132");
        awardReq1.setAwardType(CommodityType.COUPON.getCode());
        commodityService1.sendCommodity(awardReq1);

        // 实物商品
        ICommodity commodityService2 = storeFactory.getCommodityService(CommodityType.GOODS);
        AwardReq awardReq2 = new AwardReq();
        awardReq2.setuId("10001");
        awardReq2.setAwardType(CommodityType.GOODS.getCode());
        awardReq2.setAwardNumber("9820198721311");
        awardReq2.setBizId("1023000020112221113");
        Map<String,String> extMap = new HashMap<>();
        extMap.put("consigneeUserName", "谢飞机");
        extMap.put("consigneeUserPhone", "15200292123");
        extMap.put("consigneeUserAddress", "吉林省.长春市.双阳区.XX街道.檀溪苑小区.#18-2109");
        awardReq2.setExtMap(extMap);
        commodityService2.sendCommodity(awardReq2);

        // 第三方兑换卡(爱奇艺)
        ICommodity commodityService3 = storeFactory.getCommodityService(CommodityType.CARD);
        AwardReq awardReq3 = new AwardReq();
        awardReq3.setuId("10001");
        awardReq3.setAwardType(CommodityType.CARD.getCode());
        awardReq3.setAwardNumber("AQY1xjkUodl8LO975GdfrYUio");
        commodityService3.sendCommodity(awardReq3);
    }
}
