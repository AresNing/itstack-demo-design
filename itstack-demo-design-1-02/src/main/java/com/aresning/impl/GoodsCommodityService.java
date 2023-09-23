package com.aresning.impl;

import com.alibaba.fastjson.JSON;
import com.aresning.ICommodity;
import org.itstack.demo.design.AwardReq;
import org.itstack.demo.design.AwardRes;
import org.itstack.demo.design.goods.DeliverReq;
import org.itstack.demo.design.goods.GoodsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created with Intellij IDEA
 * <h3>itstack-demo-design<h3>
 *
 * @author : AresNing
 * @date : 2023-09-23 15:53
 * @description :
 */
public class GoodsCommodityService implements ICommodity {

    private static final Logger logger = LoggerFactory.getLogger(GoodsCommodityService.class);

    private GoodsService goodsService = new GoodsService();

    @Override
    public void sendCommodity(AwardReq req) throws Exception {
        DeliverReq deliverReq = new DeliverReq();
        deliverReq.setUserName(queryUserNameByuId(req.getuId()));
        deliverReq.setUserPhone(queryUserPhoneNumber(req.getuId()));
        deliverReq.setSku(req.getAwardNumber());
        deliverReq.setOrderId(req.getBizId());
        deliverReq.setConsigneeUserName(req.getExtMap().get("consigneeUserName"));
        deliverReq.setConsigneeUserPhone(req.getExtMap().get("consigneeUserPhone"));
        deliverReq.setConsigneeUserAddress(req.getExtMap().get("consigneeUserAddress"));
        Boolean isSuccess = goodsService.deliverGoods(deliverReq);

        logger.info("请求参数[实物商品] => uId：{} commodityId：{} bizId：{} extMap：{}", req.getuId(), req.getAwardNumber(), req.getBizId(), req.getExtMap());
        logger.info("测试结果[实物商品]：{}", isSuccess);

        if (!isSuccess) {
            throw new RuntimeException("实物商品发放失败");
        }
    }

    private String queryUserNameByuId(String uId) {
        return "花花";
    }

    private String queryUserPhoneNumber(String uId) {
        return "15200101232";
    }
}
