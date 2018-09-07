package com.newlandframework.rpc.demo.server;


import com.newlandframework.rpc.demo.model.Person;
import com.newlandframework.rpc.spring.annotation.NettyRPCReferer;
import org.springframework.stereotype.Service;

@Service
@NettyRPCReferer(interfaceName = "PersonManage")
public interface PersonManage {
    int savePerson(Person person);

    void queryPerson(Person person);

    void check();

    boolean checkAge(Person person);

}
