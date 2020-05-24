package com.anbangke.userserver.anno;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author wangerxiao
 * @date 2020/5/24 22:19
 * @email 784665813@qq.com
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Import(AuthRegistrar.class)
public @interface EnableAuth {

    String[] value() default {};

    String[] basePackages() default {};

    Class<? extends Annotation> annotationClass() default Annotation.class;

}
