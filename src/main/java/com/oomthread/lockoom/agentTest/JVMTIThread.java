//package com.oomthread.lockoom.agentTest;
//
//import com.sun.tools.attach.AgentInitializationException;
//import com.sun.tools.attach.AgentLoadException;
//import com.sun.tools.attach.AttachNotSupportedException;
//import com.sun.tools.attach.VirtualMachine;
//
//import java.io.IOException;
//
//public class JVMTIThread {
//    public static void main(String[] args) throws Exception{
//
//        String path = "D:/Main.class";
//        String pid = "11816";
//        JVMTIThread.attach(path,pid);
//    }
//
//    public static void attach(String classPath, String pid)
//            throws IOException, AttachNotSupportedException, AgentLoadException, AgentInitializationException {
//        VirtualMachine virtualMachine = VirtualMachine.attach(pid);
//        virtualMachine.loadAgent("D:\\project\\agent-demo\\out\\artifacts\\agent_demo_jar\\agent-demo.jar", classPath);
//        virtualMachine.detach();
//    }
//}
