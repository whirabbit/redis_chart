package com.fehead.chart;

import com.fehead.chart.demos.pojo.FormMessage;
import com.fehead.chart.demos.service.AllService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.util.List;

@SpringBootTest
class RedisChartApplicationTests {
    @Autowired
 StringRedisTemplate StringRedisTemplate;
    @Autowired
    AllService allService;
    @Test
    void contextLoads() {
    }
@Test
    void test1(){
    ValueOperations<String, String> stringStringValueOperations = StringRedisTemplate.opsForValue();
    String s = stringStringValueOperations.get("navigate-sust:*");
    System.out.println(s);

}
    @Test
    void test2(){

        List<FormMessage> formMessage = allService.getFormMessage("navigate-sust");
        System.out.println(formMessage==null);
        for (FormMessage fm:formMessage){
            System.out.println(fm);
        }

    }
    @Test
    void test3(){
        System.out.println(allService.getList());

    }
}
