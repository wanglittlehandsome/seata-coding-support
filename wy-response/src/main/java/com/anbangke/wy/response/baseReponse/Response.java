package com.anbangke.wy.response.baseReponse;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author wangerxiao
 * @date  2020/5/23 16:59
 * @email 784665813@qq.com
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Response<T> {

    private String message;

    private String code;

    private T context;

    public static Response success() {
        return Response.builder().code("0").build();
    }

    public static <T> Response<T> success(T context) {
        return (Response<T>) Response.builder().code("0").context(context).build();
    }

    public static Response fail(String message) {
        return Response.builder().code("-1").message(message).build();
    }

    public static Response fail(String code, String message) {
        return Response.builder().code(code).message(message).build();
    }


    public boolean isSuccess() {
        return this.code.equals("0");
    }


}
