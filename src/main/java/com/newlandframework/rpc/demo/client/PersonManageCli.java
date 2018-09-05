package com.newlandframework.rpc.demo.client;

import com.newlandframework.rpc.demo.model.Person;
import com.newlandframework.rpc.demo.server.PersonManage;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * Title:NettyRPC
 * description:
 *
 * @author: Lijiaqi
 * @version: 1.0
 * @create: 2018-09-04 15:13
 **/

public class PersonManageCli {
//    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(PersonManageImpl.class);
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:rpc-invoke-config-client.xml");
        PersonManage personManage = (PersonManage)context.getBean("myPersonManage");

        Person person = new Person();
        person.setName("sev7e0");
        person.setAge(20);
        person.setInfo("PHP is best language in the world");
        person.setP_id("1");
        personManage.savePerson(person);

        personManage.queryPerson(person);

        personManage.checkAge(person);

//        personManage.check();
        System.out.println("RPC call is over");
//        logger.info("RPC call is over");

        context.destroy();
    }
}
