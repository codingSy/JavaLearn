package com.codingsy.javalearn;

import com.alibaba.fastjson.JSONObject;
import com.missfresh.domain.Result;
import com.mryx.pay.domain.bean.EPayType;
import com.mryx.pay.domain.enums.PayChannelEnum;
import com.mryx.pay.third.gateway.api.facade.IThirdPayFacade;
import com.mryx.pay.third.gateway.api.param.req.ProfitSharingQueryReq;
import com.mryx.pay.third.gateway.api.param.resp.ProfitSharingQueryResp;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
public class DubboTest extends BaseTest {

    @Autowired
    private IThirdPayFacade thirdPayFacade;

    private String appid = "ark_10";
    private String payType = EPayType.ALIPAY;
    private String payChannel = PayChannelEnum.ALIPAY.getPayChannel();

    /**
     * 分账查询
     */
    @Test
    public void profitSharingQuery() {
        ProfitSharingQueryReq reqDto = new ProfitSharingQueryReq();
        reqDto.setAppid(appid);
        reqDto.setPayType(payType);
        reqDto.setPayChannel(payChannel);
        reqDto.setTransactionId("2020041622001483741444455128");
        reqDto.setOutOrderNo("2004161733089823169");
        Result<ProfitSharingQueryResp> result = thirdPayFacade.profitSharingQuery(reqDto);
        System.out.println("====================》" + JSONObject.toJSONString(result));
    }

}
