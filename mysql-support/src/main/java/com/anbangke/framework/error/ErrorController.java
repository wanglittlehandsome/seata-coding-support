package com.anbangke.framework.error;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ErrorController {


    @ExceptionHandler(value = Exception.class)
    public ErrorResponse exceptionHandler(Exception e) {
        System.out.println("未知异常！原因是:" + e);
        return new ErrorResponse("-1", "未知异常！原因是:" + e);
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public class ErrorResponse {

        private String code;

        private String message;

    }
}
