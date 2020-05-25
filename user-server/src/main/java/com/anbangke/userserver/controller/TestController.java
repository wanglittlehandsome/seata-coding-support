package com.anbangke.userserver.controller;

import com.anbangke.userserver.anno.Auth;
import com.anbangke.userserver.anno.AuthHandle;
import com.anbangke.wy.response.baseReponse.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/test")
public class TestController {

    @Autowired
    AuthHandle authHandle;


    @Auth(mapping = "/hello")
    @GetMapping(value = "/hello")
    public Response test() {
        return Response.fail("hello");
    }

    @GetMapping(value = "/showAuths")
    public Response showAuths() {
        return Response.success(authHandle.getAllAuth());
    }
}
