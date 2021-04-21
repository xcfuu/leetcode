package com.oomthread.lockoom.bean;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.LinkedList;

public class ClassLoaderMain {
    public static LinkedList<Object> classList =new LinkedList<>();
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        while(true){
            //这个类class的路径
            String classPath = "D:/project/lockoom/src/main/java/com/oomthread/lockoom/bean/Log.class";

            MyClassLoader myClassLoader = new MyClassLoader(classPath);

            MyClassLoader myClassLoader2 = new MyClassLoader(classPath);

            //类的全称
            String packageNamePath = "com.oomthread.lockoom.bean.Log";

            //加载Log这个class文件
            Class<?> Log = myClassLoader.loadClass(packageNamePath);

            Class<?> Log2 = myClassLoader2.loadClass(packageNamePath);
            //classList.add(Log);
            //classList.add(Log2);


            System.out.println("Log类加载器是:" + Log.getClassLoader());


            System.out.println("Log2类加载器是:" + Log2.getClassLoader());


            //利用反射获取main方法
            Method method = Log.getDeclaredMethod("main", String[].class);
            Object object = Log.newInstance();
            String[] arg = {"ad"};
            method.invoke(object, (Object) arg);
        }

    }
}
