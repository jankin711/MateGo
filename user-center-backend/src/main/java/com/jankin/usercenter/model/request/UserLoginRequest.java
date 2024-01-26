package com.jankin.usercenter.model.request;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户登录请求体
 *
 * @author jankin
 */
@Data
public class UserLoginRequest implements Serializable {

    private static final long serialVersionUID = -5004372686895658442L;

    private String userAccount;

    private String userPassword;

}
