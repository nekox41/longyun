package com.github.nekox41.common.exception.user;

/**
 * 验证码失效异常类
 * 
 * @author longyun
 */
public class CaptchaExpireException extends UserException
{
    private static final long serialVersionUID = 1L;

    public CaptchaExpireException()
    {
        super("user.jcaptcha.expire", null);
    }
}
