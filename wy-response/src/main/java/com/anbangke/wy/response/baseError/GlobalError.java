package com.anbangke.wy.response.baseError;

/**
 * @author wangerxiao
 * @date  2020/5/23 17:01
 * @email 784665813@qq.com
 */
public class GlobalError extends Error {

    public GlobalError(String code, String message) {
        super.code = code;
        super.message = message;
    }

    public static final Error REQUEST_BROKEN_DOWN = new GlobalError("-1", "请求崩溃了！");


}
