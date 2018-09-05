package com.newlandframework.rpc.spring.annotation;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * Title:NettyRPC
 * description: NettyRPCReferer annotation
 *
 * @author: Lijiaqi
 * @version: 1.0
 * @create: 2018-09-05 14:48
 **/

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@Component
public @interface NettyRPCService {

    String interfaceName() default "";

    String ref() default "";

    String filter() default "";



}
