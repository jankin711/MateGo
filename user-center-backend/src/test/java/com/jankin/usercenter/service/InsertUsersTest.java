package com.jankin.usercenter.service;

import com.jankin.usercenter.model.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.StopWatch;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

@SpringBootTest
public class InsertUsersTest {

    @Resource
    private UserService userService;

    private ExecutorService executorService = new ThreadPoolExecutor(25, 1000, 10000, TimeUnit.MINUTES, new ArrayBlockingQueue<>(10000));

    /**
     * 批量插入用户  耗时：15924 ms
     */
    @Test
    public void doInsertUser() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        final int INSERT_NUM = 100000;
        List<User> userList = new ArrayList<>();
        for (int i = 0; i < INSERT_NUM; i++) {
            User user = new User();
            user.setUsername("假数据");
            user.setUserAccount("fakeAccount");
            user.setAvatarUrl("https://img0.baidu.com/it/u=3514514443,3153875602&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=500");
            user.setGender(0);
            user.setUserPassword("12345678");
            user.setProfile("这是一条假数据");
            user.setPhone("12345");
            user.setEmail("12345@qq.com");
            user.setUserStatus(0);
            user.setUserRole(0);
            user.setTags("[]");
            userList.add(user);
        }
        userService.saveBatch(userList, 5000);
        stopWatch.stop();
        System.out.println(stopWatch.getLastTaskTimeMillis());

    }

    /**
     * 并发批量插入用户  耗时：5030 ms
     */
    @Test
    public void doConcurrencyInsertUser() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        final int INSERT_NUM = 100000;
        int j = 0;
        //批量插入数据的大小
        int batchSize = 5000;
        List<CompletableFuture<Void>> futureList = new ArrayList<>();
        for (int i = 0; i < INSERT_NUM / batchSize; i++) {
            List<User> userList = new ArrayList<>();
            while (true) {
                j++;
                User user = new User();
                user.setUsername("假数据");
                user.setUserAccount("fakeAccount");
                user.setAvatarUrl("https://img0.baidu.com/it/u=3514514443,3153875602&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=500");
                user.setGender(0);
                user.setUserPassword("12345678");
                user.setProfile("这是一条假数据");
                user.setPhone("12345");
                user.setEmail("12345@qq.com");
                user.setUserStatus(0);
                user.setUserRole(0);
                user.setTags("[]");
                userList.add(user);
                if (j % batchSize == 0) {
                    break;
                }
            }
            CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
                System.out.println("ThreadName：" + Thread.currentThread().getName());
                userService.saveBatch(userList, batchSize);
            }, executorService);
            futureList.add(future);
        }
        CompletableFuture.allOf(futureList.toArray(new CompletableFuture[]{})).join();

        stopWatch.stop();
        System.out.println(stopWatch.getLastTaskTimeMillis());
    }
}
