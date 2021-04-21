package com.oomthread.lockoom.controller;


import com.oomthread.lockoom.bean.CglibProxy;
import com.oomthread.lockoom.bean.JavaVMStackOOM;
import com.oomthread.lockoom.bean.JavaVMStackSOF;
import com.oomthread.lockoom.bean.SayHello;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/oom")
public class JavaOomController {

    @Autowired
    private JavaVMStackSOF javaVMStackSOF;

    @Autowired
    private JavaVMStackOOM javaVMStackOOM;
    List<OOMObject> list = new ArrayList<OOMObject>();

    /**
     * Java堆溢出
     * -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
     * @return
     */
    @GetMapping("/heapOOM")
    public void heapOOM(){
        while (true) {
            list.add(new OOMObject());
        }
        //return "success";
    }

    @GetMapping("/heapOOMOne")
    public void heapOOMOne(){
        List<OOMObject> list1 = new ArrayList<OOMObject>();

        while (true) {
            list1.add(new OOMObject());
        }
        //return "success";
    }

   static class OOMObject {
    }

    /**
     * 虚拟机栈和本地方法栈溢出
     * 如果线程请求的栈深度大于虚拟机所允许的最大深度，将抛出StackOverflowError异常；
     * 如果虚拟机在扩展栈时无法申请到足够的内存空间，则抛出OutOfMemoryError异常。
     */

    /**
     * 功能描述： 模拟StackOverflowError
     * -Xss128k
     * @return
     */
    @GetMapping("/stackOOM")
    public String stackOOM(){
        javaVMStackSOF.run();
        return "success";
    }


    /**
     * 功能描述： 栈OutOfMemoryError
     * -Xss2M 调大单线程可使用栈空间大小
     * 需要注意，为每个线程的栈分配的内存越大，反而越容易产生栈内存溢出异常。
     * 这个不难理解，每个线程分配到栈容量越大，可以建立的线程数量自然就越少，建立线程时就越容易把剩下的内存耗尽。
     * 因此，可以通过“减少内存”的手段来解决栈内存溢出问题。
     * @return
     */
    @GetMapping("/stackOME")
    public String stackOME(){
        javaVMStackOOM.run();
        return "success";
    }


    /**
     * 方法区和运行时常量池溢出
     */

    /**
     * 功能描述： 运行时常量池内存溢出
     * VM Args: -XX:PermSize=10M -XX:MaxPermSize=10M
     * JDK 1.7开始逐步“去永久代化”。在JDK 1.6及之前的版本，由于常量池分配在永久代，
     * 可以通过-XX:PermSize和-XX:MaxPermSize限制方法区大小，从而间接限制常量池容量。
     */
    @GetMapping("/RuntimeConstantPoolOOM")
    public void RuntimeConstantPoolOOM() {

    // 使用List保持常量池引用，避免Full GC回收常量池行为
    List<String> list = new ArrayList<String>();
    // 10MB的PermSize在integer范围内足够产生OOM
    int i =0;
    while(true) {
        list.add(String.valueOf(i++).intern());
        }

    }


    /**
     * 方法区用于存放Class的相关信息，如类名、访问修饰符、常量池、字段描述、方法描述等。
     * 对于这些区域的测试，基本的思想是运行时产生大量的类去填满方法去，直到溢出。
     * 功能描述： 方法区内存溢出
     * VM Args: -XX:PermSize=10M -XX:MaxPermSize=10M
     */
    @GetMapping("/JavaMethodAreaOOM")
    public void JavaMethodAreaOOM(){
        while (true) {
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(OOMObject.class);
            enhancer.setUseCache(false);
            enhancer.setCallback(new MethodInterceptor() {
                @Override
                public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy)
                        throws Throwable {
                    // TODO Auto-generated method stub
                    return proxy.invokeSuper(obj, args);
                }
            });
            enhancer.create();
        }

    }


    private static final int _1MB = 1024 * 1024;
    /**
     * DirectMemory容量可通过-XX:MaxDirectMemorySize指定，
     * 如果不指定，则默认与Java堆最大值（-Xmx指定）一样。
     *  功能描述： 本机直接内存溢出
     *  VM Args: -Xmx20M -XX:MaxDirectMemorySize=10M
     */
    @GetMapping("/DirectMemoryOOM")
    public void DirectMemoryOOM()throws IllegalArgumentException, IllegalAccessException{
        Field unsafeField = Unsafe.class.getDeclaredFields()[0];
        unsafeField.setAccessible(true);
        Unsafe unsafe = (Unsafe) unsafeField.get(null);
        while(true) {
            unsafe.allocateMemory(_1MB);
        }
    }

/**
 * OOM包括
 * 1.Java堆溢出
 * 2.虚拟机栈和本地方法栈溢出
 * 3.方法区和运行时常量池溢出
 * 4.本机直接内存溢出
 */


    /**
     * 创建类
     */
    @GetMapping(value = "/getProxy")
    @ResponseBody
    public void getProxy() {
            CglibProxy proxy = new CglibProxy();
            for (int i = 0; i < 10000; i++) {
                    //通过生成子类的方式创建代理类
                   SayHello proxyTmp = (SayHello) proxy.getProxy(SayHello.class);
                   proxyTmp.say();
                }
    }



    /**
     * 创建类
     */
    @GetMapping(value = "/newtest")
    @ResponseBody
    public void newtest() {
        for (int i = 0; i <1000000 ; i++) {

            Map hashMap =new HashMap<String,Object>();
            hashMap.put("qq",new Object());
        }

    }
}
