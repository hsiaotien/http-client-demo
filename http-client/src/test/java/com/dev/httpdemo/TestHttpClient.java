package com.dev.httpdemo;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class TestHttpClient {

    public CloseableHttpClient httpClient;

    @Before
    public void init(){
        httpClient = HttpClients.createDefault();
    }

    @Test
    public void testGet() throws IOException {
        HttpGet request = new HttpGet("http://www.baidu.com");
        String response = this.httpClient.execute(request, new BasicResponseHandler());
        System.out.println("response = " + response);
    }

    @Test
    public void testPost() throws IOException {
        HttpGet request = new HttpGet("http://www.oschina.net/");
        request.setHeader("User-Agent","Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36");
        String response = this.httpClient.execute(request, new BasicResponseHandler());
        System.out.println("response = " + response);
    }

    //远程调用spring-boot-demo的案例
    @Test
    public void testDemo() throws IOException {
        HttpGet request = new HttpGet("http://localhost:8080/hello");
        String response = this.httpClient.execute(request, new BasicResponseHandler());
        System.out.println("response = " + response);
    }
}
