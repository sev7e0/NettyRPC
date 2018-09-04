package com.newlandframework.rpc.demo.server;


import com.newlandframework.rpc.demo.model.Person;

public interface PersonManage {
    int savePerson(Person person);

    void queryPerson(Person person);

    void check();

    boolean checkAge(Person person);

}
