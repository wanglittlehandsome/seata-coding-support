package com.anbangke.userserver.controller;


import com.anbangke.userserver.anno.Auth;
import com.anbangke.wy.response.baseException.BusinessException;
import com.anbangke.wy.response.baseReponse.Response;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/user/server")
public class UserServerController {

    @Auth(mapping = "/getUser")
    @GetMapping("/getUser")
    public Response getUser(Long id) {
        if (StringUtils.isEmpty(id)) {
            throw new BusinessException("-1", "自定义异常");
        }
        return Response.success();
    }

    @GetMapping("/test1")
    public Response test1(Long id) {
        if (StringUtils.isEmpty(id)) {
            throw new BusinessException("-1", "自定义异常");
        }
        return Response.success();
    }

    @GetMapping("/test2")
    public Response test2(Long id) {
        if (StringUtils.isEmpty(id)) {
            throw new BusinessException("-1", "自定义异常");
        }
        return Response.success();
    }

}
