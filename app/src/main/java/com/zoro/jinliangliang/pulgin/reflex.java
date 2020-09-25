package com.zoro.jinliangliang.pulgin;

import com.zoro.jinliangliang.MainActivity;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

/**
 * Created by Zoro
 * Created on 2020/8/31
 * description:
 */
public class reflex {
    public static void main(String[] args) {
        String str = "adc";
        Class c1 = str.getClass();
        System.out.println(c1);
//
//        try {
//            Class c2 = Class.forName("java.lang.String");
//            Class c3 = Class.forName("android.widget.Button");
//            Class c4 = c3.getSuperclass();
//            System.out.println(c2);
//            System.out.println(c3);
//            System.out.println(c4);
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//
//        Class c5 = String.class;
//        Class c6 = java.lang.String.class;
//        Class c7 = MainActivity.hhhhh.class;
//        Class c8 = int.class;
//        Class c9 = int[].class;
//        System.out.println(c5);
//        System.out.println(c6);
//        System.out.println(c7);
//        System.out.println(c8);
//        System.out.println(c9);
//
//        Class c10 = Boolean.TYPE;
//        Class c11 = Byte.TYPE;
//        Class c12 = Character.TYPE;
//        Class c13 = Short.TYPE;
//        Class c14 = Integer.TYPE;
//        Class c15 = Long.TYPE;
//        Class c16 = Float.TYPE;
//        Class c17 = Double.TYPE;
//        Class c18 = Void.TYPE;
//        System.out.println(c10);
//        System.out.println(c11);
//        System.out.println(c12);
//        System.out.println(c13);
//        System.out.println(c14);
//        System.out.println(c15);
//        System.out.println(c16);
//        System.out.println(c17);
//        System.out.println(c18);

//        Test test = new Test();
//        Class temp = test.getClass();
//        String className = temp.getName();
//        Constructor[] constructors = temp.getDeclaredConstructors();
//        for (int i=0;i<constructors.length;i++){
//            int mod = constructors[i].getModifiers();
//            System.out.println(Modifier.toString(mod)+"   "+className+"  (");
//            Class[] parameterTypes = constructors[i].getParameterTypes();
//            for (int j=0;j<parameterTypes.length;j++){
//                System.out.println(parameterTypes[j].getName());
//            }
//            System.out.println("  )");
//        }
//        try {
//            Class[] c2 = {int.class};
//            Constructor c1 = temp.getDeclaredConstructor(c2);
//            System.out.println(c1);
//        } catch (NoSuchMethodException e) {
//            e.printStackTrace();
//        }

//        try {
//            Class r = Class.forName("com.zoro.jinliangliang.pulgin.Test");
//            Class[] p = {int.class,String.class};
//            Constructor declaredConstructor = r.getDeclaredConstructor(p);
//            Object obj = declaredConstructor.newInstance("hhhhh", 12);
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (InstantiationException e) {
//            e.printStackTrace();
//        } catch (InvocationTargetException e) {
//            e.printStackTrace();
//        } catch (NoSuchMethodException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        }

//        try {
//            Class r = Class.forName("com.zoro.jinliangliang.pulgin.Test");
//            Class[] p = {String.class};
//            //获取对象
//            Constructor declaredConstructor = r.getDeclaredConstructor(p);
//            declaredConstructor.setAccessible(true);
//            Object dididi = declaredConstructor.newInstance("13");
//            //获取doSomething方法
//            Method doSomething = r.getDeclaredMethod("doSomething", p);
//            doSomething.setAccessible(true);
//            Object argList[] = {"fdsfdfsd"};
//            doSomething.invoke(dididi, argList);
//
//            //获取work方法
//            Method work = r.getDeclaredMethod("work",p);
//            work.setAccessible(true);
//            work.invoke(null,"sfdfsd");
//
//            //获取name属性
//            Field field = r.getDeclaredField("name");
//            field.setAccessible(true);
//            field.get(dididi);
//            field.set(dididi,"sfdfasdfasd");
//            Method getName = r.getDeclaredMethod("getName");
//            getName.setAccessible(true);
//            System.out.println(getName.invoke(dididi));
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (NoSuchMethodException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (InstantiationException e) {
//            e.printStackTrace();
//        } catch (InvocationTargetException e) {
//            e.printStackTrace();
//        } catch (NoSuchFieldException e) {
//            e.printStackTrace();
//        }

    }
}
