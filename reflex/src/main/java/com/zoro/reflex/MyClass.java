package com.zoro.reflex;

public class MyClass {
    public static void main(String[] args) {
        String str = "adc";
        Class c1 = str.getClass();
        System.out.println(c1);
        try {
            Class c2 = Class.forName("java.lang.String");
//            Class c3 = Class.forName("android.widget.Button");
//            Class c4 = c3.getSuperclass();
            System.out.println(c2);
//            System.out.println(c3);
//            System.out.println(c4);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
