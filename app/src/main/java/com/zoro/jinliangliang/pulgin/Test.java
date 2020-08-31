package com.zoro.jinliangliang.pulgin;

/**
 * Created by Zoro
 * Created on 2020/8/31
 * description:
 */
public class Test {
    private String name = "";
    private int age = 10;

    public Test() {
    }

    private Test(String name) {
        this.name = name;
    }

    private Test(int age) {
        this.age = age;
    }

    public Test(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name == null ? "" : name;
    }

//    public void setName(String name) {
//        this.name = name;
//    }

    private void doSomething(String s){
        System.out.println("是的发送到发     "+s);
    }

    private static void work(String  name){
        System.out.println("ddb==="+name);
    }
}
