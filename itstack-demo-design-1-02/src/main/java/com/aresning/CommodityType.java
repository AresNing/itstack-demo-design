package com.aresning;

/**
 * Created with Intellij IDEA
 * <h3>itstack-demo-design<h3>
 *
 * @author : AresNing
 * @date : 2023-09-23 15:59
 * @description :
 */
public enum CommodityType {
    COUPON(1, "优惠券"),

    GOODS(2, "实物商品"),

    CARD(3, "爱奇艺兑换卡"),
    ;

    private Integer code;

    private String desc;

    CommodityType(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public CommodityType of(Integer code) {
        for (CommodityType commodity : CommodityType.values()) {
            if (commodity.getCode() == code) {
                return commodity;
            }
        }
        return null;
    }

}
