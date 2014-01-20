package cn.oyjg.base.exception;

import javax.naming.AuthenticationException;

public class IncorrectCaptchaException extends AuthenticationException{

    private static final long serialVersionUID = 1L;

    public IncorrectCaptchaException() {
         super();
    }

    public IncorrectCaptchaException(String message) {
         super(message);
    }
}