package com.anbangke.wy.response.advice;

import com.anbangke.wy.response.baseReponse.Response;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author wangerxiao
 * @date 2020/5/24 21:55
 * @email 784665813@qq.com
 */
@RestController
public class MainsiteErrorController implements ErrorController {


    @RequestMapping("/error")
    public Response handleError(HttpServletRequest request){
        //获取statusCode:401,404,500
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        if(statusCode == 401){
            return Response.fail("401");
        }else if(statusCode == 404){
            return Response.fail("404");
        }else if(statusCode == 403){
            return Response.fail("403");
        }else{
            return Response.fail("500");
        }

    }


    @Override
    public String getErrorPath() {
        return "/error";
    }
}
