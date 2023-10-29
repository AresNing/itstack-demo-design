package com.aresning.mode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created with Intellij IDEA
 * <h3>itstack-demo-design<h3>
 *
 * @author : AresNing
 * @date : 2023-10-29 15:28
 * @description :
 */
public class FacePayMode implements PayMode {
    private Logger logger = LoggerFactory.getLogger(FacePayMode.class);

    @Override
    public boolean isSecurity(String uid) {
        logger.info("人脸支付，风控校验脸部识别");
        return true;
    }
}
