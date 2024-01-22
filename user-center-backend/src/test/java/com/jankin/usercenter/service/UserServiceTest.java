package com.jankin.usercenter.service;

import com.jankin.usercenter.model.domain.User;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * 用户服务测试
 *
 * @author jankin
 */
@SpringBootTest
class UserServiceTest {

    @Resource
    private UserService userService;

    @Test
    public void testAddUser() {
        User user = new User();
        user.setUsername("林耿杰");
        user.setUserAccount("201");
        user.setAvatarUrl("https://img2.woyaogexing.com/2023/09/14/c9426e941a6cf9dfe89d7d1508a8ea96.jpg");
        user.setGender(0);
        user.setUserPassword("201");
        user.setEmail("111");
        user.setPhone("111111");

        boolean result = userService.save(user);
        System.out.println(user.getId());
        Assertions.assertTrue(result);
    }

    @Test
    void userRegister() {
        String username = "rhh";
        String userAccount = "240240";
        String userPassword = "";
        String checkPassword = "240";
        long result = userService.userRegister(username, userAccount, userPassword, checkPassword);
        Assertions.assertEquals(-1, result);

        userAccount = "240";
        result = userService.userRegister(username, userAccount, userPassword, checkPassword);
        Assertions.assertEquals(-1, result);

        userAccount = "240240";
        userPassword = "240240";
        result = userService.userRegister(username, userAccount, userPassword, checkPassword);
        Assertions.assertEquals(-1, result);

        userAccount = "240 240";
        userPassword = "240240240";
        result = userService.userRegister(username, userAccount, userPassword, checkPassword);
        Assertions.assertEquals(-1, result);

        userAccount = "240240";
        checkPassword = "240240240240";
        result = userService.userRegister(username, userAccount, userPassword, checkPassword);
        Assertions.assertEquals(-1, result);

        userAccount = "201201";
        checkPassword = "240240240";
        result = userService.userRegister(username, userAccount, userPassword, checkPassword);
        Assertions.assertEquals(-1, result);

        userAccount = "240240";
        result = userService.userRegister(username, userAccount, userPassword, checkPassword);
        Assertions.assertTrue(result > 0);
    }

    @Test
    public void testSearchUsersByTags(){
        List<String> tagNameList = Arrays.asList("java", "python");
        List<User> userList = userService.searchUsersByTags(tagNameList);
        Assert.assertNotNull(userList);
    }
}