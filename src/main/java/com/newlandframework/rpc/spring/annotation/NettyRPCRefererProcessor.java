package com.newlandframework.rpc.spring.annotation;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Title:NettyRPC
 * description:
 * Company: 北京华宇元典信息服务有限公司
 *
 * @author: Lijiaqi
 * @version: 1.0
 * @create: 2018-09-07 10:08
 **/
@Component
public class NettyRPCRefererProcessor implements BeanPostProcessor {

    public static Map<String, Object> map = new ConcurrentHashMap<String, Object>();

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

        Method[] methods = ReflectionUtils.getAllDeclaredMethods(bean.getClass());
        if (methods != null){
            for (Method method : methods){
                NettyRPCReferer referer = AnnotationUtils.findAnnotation(method, NettyRPCReferer.class);
                map.put(referer.id(), referer.interfaceName());
                System.out.println(referer.interfaceName());
            }
        }
        return bean;
    }
}
