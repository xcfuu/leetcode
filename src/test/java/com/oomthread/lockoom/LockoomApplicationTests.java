package com.oomthread.lockoom;

import com.oomthread.lockoom.controller.JavaOomController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LockoomApplicationTests {
    @Autowired
    private JavaOomController javaOomController;
    @Test
    void contextLoads() {
    }
    @Test
    public void test(){
        javaOomController.heapOOM();
    }

}
