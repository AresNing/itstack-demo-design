package com.aresning;

import com.alibaba.fastjson.JSON;
import org.itstack.demo.design.AwardReq;
import org.itstack.demo.design.AwardRes;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with Intellij IDEA
 * <h3>itstack-demo-design<h3>
 *
 * @author : AresNing
 * @date : 2023-09-23 15:01
 * @description :
 */
public class ApiTest {

    private static final Logger logger = LoggerFactory.getLogger(ApiTest.class);

    @Test
    public void test_awardToUser() {
        PriceControllerDemo priceControllerDemo = new PriceControllerDemo();

        System.out.println("\r\n模拟发放优惠券测试\r\n");
        // 模拟发放优惠券测试
        AwardReq req01 = new AwardReq();
        req01.setuId("10001");
        req01.setAwardType(1);
        req01.setAwardNumber("EGM1023938910232121323432");
        req01.setBizId("791098764902132");
        AwardRes awardRes01 = priceControllerDemo.awardToUser(req01);
        logger.info("请求参数：{}", JSON.toJSON(req01));
        logger.info("测试结果：{}", JSON.toJSON(awardRes01));

        System.out.println("\r\n模拟方法实物商品\r\n");
        // 模拟发放实物商品
        AwardReq req02 = new AwardReq();
        req02.setuId("10001");
        req02.setAwardType(2);
        req02.setAwardNumber("9820198721311");
        req02.setBizId("1023000020112221113");
        Map<String,String> extMap = new HashMap<String,String>();
        extMap.put("consigneeUserName", "谢飞机");
        extMap.put("consigneeUserPhone", "15200292123");
        extMap.put("consigneeUserAddress", "吉林省.长春市.双阳区.XX街道.檀溪苑小区.#18-2109");
        req02.setExtMap(extMap);
        AwardRes awardRes02 = priceControllerDemo.awardToUser(req02);
        logger.info("请求参数：{}", JSON.toJSON(req02));
        logger.info("测试结果：{}", JSON.toJSON(awardRes02));

        System.out.println("\r\n第三方兑换卡(爱奇艺)\r\n");
        // 模拟发放兑换卡
        AwardReq req03 = new AwardReq();
        req03.setuId("10001");
        req03.setAwardType(3);
        req03.setAwardNumber("AQY1xjkUodl8LO975GdfrYUio");
        AwardRes awardRes03 = priceControllerDemo.awardToUser(req03);
        logger.info("请求参数：{}", JSON.toJSON(req03));
        logger.info("测试结果：{}", JSON.toJSON(awardRes03));
    }
}
