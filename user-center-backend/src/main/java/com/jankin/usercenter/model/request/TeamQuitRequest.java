package com.jankin.usercenter.model.request;

import lombok.Data;

import java.io.Serializable;

@Data
public class TeamQuitRequest implements Serializable {

    private static final long serialVersionUID = 2237977830107120979L;

    /**
     * id
     */
    private Long teamId;
}