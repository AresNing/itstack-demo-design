package com.aresning.channel;

import java.math.BigDecimal;

/**
 * Created with Intellij IDEA
 * <h3>itstack-demo-design<h3>
 *
 * @author : AresNing
 * @date : 2023-10-29 15:22
 * @description :
 */
public interface Payable {
    String transfer(String uid, String tradeId, BigDecimal amount);
}
