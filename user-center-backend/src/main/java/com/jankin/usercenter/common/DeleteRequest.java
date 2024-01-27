package com.jankin.usercenter.common;

import lombok.Data;

import java.io.Serializable;

@Data
public class DeleteRequest implements Serializable {

    private static final long serialVersionUID = 4910079491715474568L;

    private long id;
}