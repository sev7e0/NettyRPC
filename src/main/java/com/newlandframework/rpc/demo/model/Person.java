package com.newlandframework.rpc.demo.model;

/**
 * Title:NettyRPC
 * description:
 *
 * @author: Lijiaqi
 * @version: 1.0
 * @create: 2018-09-04 14:58
 **/

public class Person {

    private String p_id;
    private String name;
    private int age;
    private String info;

    public String getP_id() {
        return p_id;
    }

    public void setP_id(String p_id) {
        this.p_id = p_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "当前对象内容为:Person{" +
                "p_id='" + p_id + '\'' +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", info='" + info + '\'' +
                '}';
    }

}
