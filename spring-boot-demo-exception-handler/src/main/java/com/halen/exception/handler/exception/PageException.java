package com.halen.exception.handler.exception;

import com.halen.exception.handler.constant.Status;
import lombok.Getter;

@Getter
public class PageException extends BaseException{
    public PageException(Status status) {
        super(status);
    }

    public PageException(Integer code, String message) {
        super(code, message);
    }
}
