package com.newlandframework.rpc.spring.annotation;

import com.newlandframework.rpc.core.RpcSystemConfig;
import com.newlandframework.rpc.demo.model.Person;
import com.newlandframework.rpc.event.ServerStartEvent;
import com.newlandframework.rpc.filter.Filter;
import com.newlandframework.rpc.filter.ServiceFilterBinder;
import com.newlandframework.rpc.jmx.HashModuleMetricsVisitor;
import com.newlandframework.rpc.jmx.ModuleMetricsHandler;
import com.newlandframework.rpc.netty.MessageRecvExecutor;
import com.newlandframework.rpc.spring.NettyRpcService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

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
@Configuration
public class NettyRPCServiceProcessor implements BeanDefinitionRegistryPostProcessor {

    private BeanDefinitionRegistry registry;

    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        this.registry = registry;
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        Map<String, Object> objectMap = beanFactory.getBeansWithAnnotation(NettyRPCService.class);
        for (Object bean :
                objectMap.values()) {
            try {
                NettyRPCService annotation = bean.getClass().getAnnotation(NettyRPCService.class);
                RootBeanDefinition beanDefinition = new RootBeanDefinition();
                beanDefinition.setBeanClass(NettyRpcService.class);
                beanDefinition.setLazyInit(false);
                beanDefinition.getPropertyValues().addPropertyValue("interfaceName", annotation.interfaceName());
                beanDefinition.getPropertyValues().addPropertyValue("ref", annotation.ref());
                beanDefinition.getPropertyValues().addPropertyValue("filter", annotation.filter());

                registry.registerBeanDefinition(annotation.interfaceName(), beanDefinition);
//                System.out.println("----------" + annotation.interfaceName());
//                System.out.println("----------" + annotation.annotationType().getName());
//                System.out.println("----------" + annotation.annotationType().getCanonicalName());
//                System.out.println("----------" + annotation.annotationType().getTypeName());
//                System.out.println("----------" + annotation.annotationType().getSimpleName());
//                System.out.println("----------" + annotation.annotationType().getClassLoader());
//                System.out.println("----------" + annotation.getClass().getName());
//                Person person = new Person();
//                person.setName("jack ma");
//                person.setInfo("ma baba");
//                Method savePerson = bean.getClass().getMethod("savePerson", Person.class);
//
//                System.out.println("----------" + savePerson.invoke(bean, person));
//                System.out.println("postProcessBeanFactory");
                //控制HashModuleMetricsVisitor数量的
//                if (RpcSystemConfig.SYSTEM_PROPERTY_JMX_METRICS_SUPPORT) {
//                    HashModuleMetricsVisitor visitor = HashModuleMetricsVisitor.getInstance();
//                    visitor.signal();
//                    ModuleMetricsHandler handler = ModuleMetricsHandler.getInstance();
//                    handler.start();
//                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
