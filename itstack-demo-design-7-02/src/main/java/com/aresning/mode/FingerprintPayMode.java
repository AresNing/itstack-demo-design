package com.aresning.mode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created with Intellij IDEA
 * <h3>itstack-demo-design<h3>
 *
 * @author : AresNing
 * @date : 2023-10-29 15:29
 * @description :
 */
public class FingerprintPayMode implements PayMode {
    private Logger logger = LoggerFactory.getLogger(FingerprintPayMode.class);

    @Override
    public boolean isSecurity(String uid) {
        logger.info("指纹支付，风控校验指纹信息");
        return true;
    }
}
