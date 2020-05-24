package com.anbangke.userserver.anno;

import java.lang.annotation.*;

/**
 * @author wangerxiao
 * @date 2020/5/24 22:22
 * @email 784665813@qq.com
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD,ElementType.TYPE})
@Documented
public @interface Auth {

    String mapping() default "";

    boolean sign() default true;

    boolean needLogin() default true;

    boolean open() default false;
}
