package com.newlandframework.rpc.demo.server;

import com.newlandframework.rpc.demo.model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Title:NettyRPC
 * description:
 * Company: 北京华宇元典信息服务有限公司
 *
 * @author: Lijiaqi
 * @version: 1.0
 * @create: 2018-09-04 15:02
 **/

public class PersonManageImpl implements PersonManage {
//    private static final Logger logger = LoggerFactory.getLogger(PersonManageImpl.class);
    @Override
    public int savePerson(Person person) {
        System.out.println("----------save "+person.toString()+"success");
        return 0;
    }

    @Override
    public void queryPerson(Person person) {
        System.out.println("----------query "+person.toString()+" success");
    }

    @Override
    public void check() {
        throw new RuntimeException("---------you exec check");
    }

    @Override
    public boolean checkAge(Person person) {
        if (person.getAge()<18){
            throw new RuntimeException("-----------you age is not allow");
        }else {
            return true;
        }
    }
}
