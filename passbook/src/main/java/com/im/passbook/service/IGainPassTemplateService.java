package com.im.passbook.service;

import com.im.passbook.vo.GainPassTemplateRequest;
import com.im.passbook.vo.Response;

/**
 * <h1>用户领取优惠券功能实现
 */
public interface IGainPassTemplateService {

    /**
     * <h2>用户领取优惠券</h2>
     * @param request {@link GainPassTemplateRequest}
     * @return {@link Response}
     * */
    Response gainPassTemplate(GainPassTemplateRequest request) throws Exception;
}
