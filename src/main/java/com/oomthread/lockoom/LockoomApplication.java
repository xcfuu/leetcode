package com.oomthread.lockoom;

import org.csource.common.MyException;
import org.csource.fastdfs.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import java.io.IOException;
import java.util.Properties;

@SpringBootApplication(scanBasePackages = "com.oomthread.lockoom")
public class LockoomApplication {

    public static void main(String[] args) {
        SpringApplication.run(LockoomApplication.class, args);
        //LockoomApplication.test();
    }

    public static void test() {
        Properties properties = new Properties();
        properties.put("fastdfs.connect_timeout", 2);
        properties.put("fastdfs.network_timeout", 30);
        properties.put("fastdfs.http.tracker_http_port", 80);

        properties.put("fastdfs.charset", "UTF-8");

        properties.put("fastdfs.http.anti_steal_token", "no");

        //properties.put("fastdfs.http.secret_key", "FastDFS1234567890");

        properties.put("fastdfs.tracker_servers", "192.168.100.142:22122");
        try {
            ClientGlobal.initByProperties(properties);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (MyException e) {
            e.printStackTrace();
        }

        TrackerClient trackerClient = new TrackerClient();
        TrackerServer trackerServer = null;
        try {
            trackerServer = trackerClient.getConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }
        StorageServer storageServer = null;
        StorageClient1 client = new StorageClient1(trackerServer, storageServer);
        String filekey = null;

        try {
            filekey = client.upload_file1("D:\\客户\\海通\\HTTP请求.jmx","aaxml",null);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (MyException e) {
            e.printStackTrace();
        }

        System.out.println(filekey);
    }

}
