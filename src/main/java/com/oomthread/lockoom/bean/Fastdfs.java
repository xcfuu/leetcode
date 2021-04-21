package com.oomthread.lockoom.bean;

import org.csource.common.MyException;
import org.csource.fastdfs.*;

import java.io.IOException;
import java.util.Properties;

public class Fastdfs {

    public void test() {
        Properties properties = new Properties();
        properties.put("fastdfs.connect_timeout", 2);
        properties.put("fastdfs.network_timeout", 30);
        properties.put("fastdfs.http.tracker_http_port", 80);

        properties.put("fastdfs.charset", "UTF-8");

        properties.put("fastdfs.http.anti_steal_token", "no");

        properties.put("fastdfs.http.secret_key", "FastDFS1234567890");

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
            filekey = client.upload_file1("/Users/chaofu.xue/Downloads/apache-maven-3.6.3/conf/settings.xml","xml",null);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (MyException e) {
            e.printStackTrace();
        }

        System.out.println(filekey);
    }


}
