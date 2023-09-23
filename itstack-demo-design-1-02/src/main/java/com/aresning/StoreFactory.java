package com.aresning;

import com.aresning.impl.CardCommodityService;
import com.aresning.impl.CouponCommodityService;
import com.aresning.impl.GoodsCommodityService;

/**
 * Created with Intellij IDEA
 * <h3>itstack-demo-design<h3>
 *
 * @author : AresNing
 * @date : 2023-09-23 15:58
 * @description :
 */
public class StoreFactory {

    public ICommodity getCommodityService(CommodityType commodityType) {
        if (commodityType == null) return null;
        switch (commodityType) {
            case COUPON:
                return new CouponCommodityService();
            case GOODS:
                return new GoodsCommodityService();
            case CARD:
                return new CardCommodityService();
            default:
                throw new RuntimeException("不存在的商品服务类型");
        }
    }

}
