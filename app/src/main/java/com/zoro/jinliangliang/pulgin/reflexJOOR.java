package com.zoro.jinliangliang.pulgin;

import org.w3c.dom.Text;

/**
 * Created by Zoro
 * Created on 2020/8/31
 * description:
 */
public class reflexJOOR {
    public static void main(String[] args) {
//        String str = "adc";
//        Class c1 = str.getClass();
//        System.out.println(c1);
//        Reflect r1 = Reflect.on(Object.class);
//        Reflect r2 = Reflect.on("java.lang.Object");
//        Reflect r3 = Reflect.on("java.lang.Object",ClassLoader.getSystemClassLoader());
//
//        Object o1 = Reflect.on(Object.class).<Object>get();
//        Object o2 = Reflect.on("java.lang.Object").get();
//
//        String j2 = Reflect.on("abc").get();
//        int j3 = Reflect.on(1).get();
//
//        Class j4 = Reflect.on("android.widget.Button").type();

        Testaaaaa test = new Testaaaaa();
        Class temp = test.getClass();
        String className = temp.getName();
        System.out.println(className);

//        Object o1 = Reflect.on(temp).create().get();
//        Object o2 = Reflect.on(temp).create("abc",1).get();
//
//        Testaaaaa test1 = Reflect.on(Testaaaaa.class).create("asdfsdf",10).get();
//        String  a = test1.getName();
//        System.out.println(a);

    }
}
