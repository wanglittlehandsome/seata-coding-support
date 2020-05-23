package com.anbangke.wy.response.baseException;

import lombok.Data;

/**
 * @author wangerxiao
 * @date 2020/5/23 16:43
 * @email 784665813@qq.com
 */
@Data
public class BusinessException extends RuntimeException {

    private static final long serialVersionUID = -1L;

    private String code;

    public BusinessException() {
        super();
    }

    public BusinessException(String message) {
        super(message);
    }


    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }


    public BusinessException(Throwable cause) {
        super(cause);
    }


    public BusinessException(Error error) {
        super(error.getMessage());
    }


    public BusinessException(String code, String message) {
        super(message);
        this.code = code;
    }

}
