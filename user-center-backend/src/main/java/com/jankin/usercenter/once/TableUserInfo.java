package com.jankin.usercenter.once;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * 表格用户信息
 */
@Data
public class TableUserInfo {
    /**
     * 用户账号
     */
    @ExcelProperty("用户账号")
    private String userAccount;

    /**
     * 用户昵称
     */
    @ExcelProperty("用户昵称")
    private String username;
}