package com.jankin.usercenter.model.domain.request;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户登录请求体
 *
 * @author jankin
 */
@Data
public class UserLoginRequest implements Serializable {

    private static final long serialVersionUID = 6229526856199796527L;

    private String userAccount;

    private String userPassword;

}
