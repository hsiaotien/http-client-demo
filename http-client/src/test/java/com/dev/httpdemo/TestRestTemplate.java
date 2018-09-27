package com.dev.httpdemo;

import com.dev.httpdemo.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

//Spring提供的模板类
@SpringBootTest(classes = HttpClientApplication.class)
@RunWith(SpringRunner.class)
public class TestRestTemplate {

    @Autowired
    private RestTemplate restTemplate;
    //注意,RestTemplate需要交给Spring管理(默认并没有被Spring管理!!)

    /**
     * spring-boot-guide05案例提供访问路径
     */
    @Test
    public void testHttpGet() {
        User user = this.restTemplate.getForObject("http://localhost/user/1", User.class);
        System.out.println("user.name = " + user.getUserName());
    }
}
