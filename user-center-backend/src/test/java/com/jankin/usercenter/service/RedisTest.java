package com.jankin.usercenter.service;

import com.jankin.usercenter.model.domain.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import javax.annotation.Resource;

@SpringBootTest
public class RedisTest {
    @Resource
    private RedisTemplate redisTemplate;

    @Test
    void test() {
        ValueOperations valueOperations = redisTemplate.opsForValue();
        //增
        valueOperations.set("jankinString", "dog");
        valueOperations.set("jankinInt", 1);
        valueOperations.set("jankinDouble", 2.0);
        User user = new User();
        user.setId(1L);
        user.setUsername("jankin");
        valueOperations.set("jankinUser", user);
        //查
        Object jankin = valueOperations.get("jankinString");
        Assertions.assertTrue("dog".equals((String) jankin));
        jankin = valueOperations.get("jankinInt");
        Assertions.assertTrue(1 == ((Integer) jankin));
        jankin = valueOperations.get("jankinDouble");
        Assertions.assertTrue(2.0 == ((Double) jankin));
        System.out.println(valueOperations.get("jankinUser"));
//        valueOperations.set("jankinString","dog");
//        redisTemplate.delete("jankinString");
    }
}