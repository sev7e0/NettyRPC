package com.newlandframework.rpc.spring.annotation;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
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
public class NettyRPCRefererProcessor implements ApplicationContextAware {

    public static Map<String, Object> map = new ConcurrentHashMap<String, Object>();

//    @Override
//    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
//        System.out.println("----------postProcessBeforeInitialization");
//        return bean;
//    }
//
//    @Override
//    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
//        System.out.println("----------postProcessAfterInitialization");
////        Method[] methods = ReflectionUtils.getAllDeclaredMethods(bean.getClass());
////        if (methods != null){
////            for (Method method : methods){
////                NettyRPCReferer referer = AnnotationUtils.findAnnotation(method, NettyRPCReferer.class);
////                map.put(referer.id(), referer.interfaceName());
////                System.out.println(referer.interfaceName());
////            }
////        }
//        return bean;
//    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        Map<String, Object> objectMap = applicationContext.getBeansWithAnnotation(NettyRPCReferer.class);
        System.out.println("----------");
        for (Object bean :
                objectMap.values()) {
            try {
                NettyRPCReferer annotation = bean.getClass().getAnnotation(NettyRPCReferer.class);
                System.out.println("----------"+annotation.interfaceName());
                System.out.println("----------"+annotation.annotationType());

            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
