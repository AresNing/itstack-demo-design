package com.aresning.channel;

import com.aresning.mode.PayMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created with Intellij IDEA
 * <h3>itstack-demo-design<h3>
 *
 * @author : AresNing
 * @date : 2023-10-29 15:25
 * @description :
 */
public abstract class PayChannel implements Payable {
    protected Logger logger = LoggerFactory.getLogger(PayChannel.class);
    protected PayMode payMode;

    public PayChannel(PayMode payMode) {
        this.payMode = payMode;
    }
}
