package com.newlandframework.rpc.demo.server;

import com.newlandframework.rpc.spring.annotation.NettyRPCReferer;
import com.newlandframework.rpc.spring.annotation.NettyRPCService;
import com.newlandframework.rpc.demo.model.Person;

/**
 * Title:NettyRPC
 * description:
 *
 * @author: Lijiaqi
 * @version: 1.0
 * @create: 2018-09-04 15:02
 **/

@NettyRPCService(interfaceName = "com.newlandframework.rpc.demo.server.PersonManage", ref = "myManageService")
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
