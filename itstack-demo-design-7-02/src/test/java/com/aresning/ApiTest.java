package com.aresning;

import com.aresning.channel.PayChannel;
import com.aresning.channel.WXPayChannel;
import com.aresning.channel.ZFBPayChannel;
import com.aresning.mode.FacePayMode;
import com.aresning.mode.FingerprintPayMode;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * Created with Intellij IDEA
 * <h3>itstack-demo-design<h3>
 *
 * @author : AresNing
 * @date : 2023-10-29 15:35
 * @description :
 */
public class ApiTest {

    @Test
    public void test_pay() {

        System.out.println("\r\n模拟测试场景；微信支付、人脸方式。");
        PayChannel wxPay = new WXPayChannel(new FacePayMode());
        wxPay.transfer("weixin_1092033111", "100000109893", new BigDecimal(100));

        System.out.println("\r\n模拟测试场景；支付宝支付、指纹方式。");
        PayChannel zfbPay = new ZFBPayChannel(new FingerprintPayMode());
        zfbPay.transfer("jlu19dlxo111","100000109894",new BigDecimal(100));

    }

}
