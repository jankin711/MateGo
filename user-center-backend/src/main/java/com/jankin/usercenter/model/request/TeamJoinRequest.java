package com.jankin.usercenter.model.request;

import lombok.Data;

import java.io.Serializable;

@Data
public class TeamJoinRequest implements Serializable {

    private static final long serialVersionUID = -4398469053430080690L;

    /**
     * id
     */
    private Long teamId;

    /**
     * 密码
     */
    private String password;
}