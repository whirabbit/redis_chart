package com.fehead.chart.demos.service;


import com.fehead.chart.demos.pojo.FormMessage;
import com.fehead.chart.demos.pojo.ListMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Service
public class AllService {
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    public AllService(StringRedisTemplate stringRedisTemplate) {
        this.stringRedisTemplate = stringRedisTemplate;
    }

    public List<FormMessage> getFormMessage(String name) {
        List<FormMessage> messages = new ArrayList<>();
        StringBuffer buffer = new StringBuffer();
        Set<String> keys = stringRedisTemplate.keys(name + "*" + "total");

        for (String key : keys) {
            FormMessage message = new FormMessage();
            buffer.append(key);
            int before = buffer.indexOf(":");
            int last = buffer.lastIndexOf(".");
            String total = stringRedisTemplate.opsForValue().get(key);

            message.setProjectName(buffer.substring(0, before));
            message.setInterfaceName(buffer.substring(before + 1, last));
            message.setTotal(Integer.parseInt(total));
            messages.add(message);
            buffer.setLength(0);
        }
        return messages;
    }

    public List<ListMessage> getList() {
        List<ListMessage> messages = new ArrayList<>();
        StringBuffer buffer = new StringBuffer();
        Set<String> keys = stringRedisTemplate.keys(  "*" + "total");
        Set<String> project=new HashSet<>();

        for (String key : keys) {
            buffer.append(key);
            int before = buffer.indexOf(":");
            project.add(buffer.substring(0,before));
            buffer.setLength(0);
        }

        for (String mes:project){
            ListMessage message=new ListMessage();
            message.setName(mes);
            message.setTotal(this.number(mes));
            messages.add(message);
        }

        return messages;
    }
    /*
    * 获取指定项目调用总数
    * */
    public int number(String name){
        ValueOperations<String, String> operations = stringRedisTemplate.opsForValue();
        int number=0;
        Set<String> keys = stringRedisTemplate.keys(  name+"*" + "total");
for (String key:keys){
    number+= Integer.parseInt( operations.get(key));
}
    return number;
    }
}
