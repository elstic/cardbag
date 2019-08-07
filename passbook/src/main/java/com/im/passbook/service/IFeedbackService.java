package com.im.passbook.service;

import com.im.passbook.vo.Feedback;
import com.im.passbook.vo.Response;

/**
 * <h1>评论功能: 即用户评论相关功能实现</h1>

 */
public interface IFeedbackService {

    /**
     * <h2>创建评论</h2>
     * @param feedback {@link Feedback}
     * @return {@link Response}
     * */
    Response createFeedback(Feedback feedback);

    /**
     * <h2>获取用户评论</h2>
     * @param userId 用户 id
     * @return {@link Response}
     * */
    Response getFeedback(Long userId);
}
