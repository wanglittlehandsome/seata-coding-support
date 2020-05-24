package com.anbangke.wy.response.advice;


import com.anbangke.wy.response.baseException.BusinessException;
import com.anbangke.wy.response.baseReponse.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@Slf4j
@RestControllerAdvice
public class ErrorController {


    @ExceptionHandler(value = BusinessException.class)
    public Response businessExceptionHandler(Exception e) {
        System.out.println("BusinessException异常！原因是:" + e);
        return Response.fail(((BusinessException) e).getCode(), e.getMessage());
    }

    @ExceptionHandler(value = Exception.class)
    public Response exceptionHandler(Exception e) {
        System.out.println("未知异常！原因是:" + e);
        return Response.fail(((BusinessException) e).getCode(), e.getMessage());
    }

}
