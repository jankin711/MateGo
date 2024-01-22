package com.jankin.usercenter.model.domain.request;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户注册请求体
 *
 * @author jankin
 */
@Data
public class UserRegisterRequest implements Serializable {

    private static final long serialVersionUID = 6229526856199796527L;

    private String userAccount;

    private String userPassword;

    private String checkPassword;

    private String username;

}
