package com.aresning.mode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created with Intellij IDEA
 * <h3>itstack-demo-design<h3>
 *
 * @author : AresNing
 * @date : 2023-10-29 15:30
 * @description :
 */
public class PasswordPayMode implements PayMode {
    private Logger logger = LoggerFactory.getLogger(PasswordPayMode.class);

    @Override
    public boolean isSecurity(String uid) {
        logger.info("密码支付，风控校验环境安全");
        return true;
    }
}
