package com.aresning.impl;

import com.aresning.ICommodity;
import org.itstack.demo.design.AwardReq;
import org.itstack.demo.design.AwardRes;
import org.itstack.demo.design.card.IQiYiCardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created with Intellij IDEA
 * <h3>itstack-demo-design<h3>
 *
 * @author : AresNing
 * @date : 2023-09-23 15:56
 * @description :
 */
public class CardCommodityService implements ICommodity {

    private static final Logger logger = LoggerFactory.getLogger(GoodsCommodityService.class);

    private IQiYiCardService iQiYiCardService = new IQiYiCardService();

    @Override
    public void sendCommodity(AwardReq req) throws Exception {

        iQiYiCardService.grantToken(queryUserPhoneNumber(req.getuId()), req.getAwardNumber());
        logger.info("请求参数[爱奇艺兑换卡] => uId：{} commodityId：{} bizId：{} extMap：{}", req.getuId(), req.getAwardNumber(), req.getBizId(), req.getExtMap());
        logger.info("测试结果[爱奇艺兑换卡]：success");

    }

    private String queryUserPhoneNumber(String uId) {
        return "15200101232";
    }

}
