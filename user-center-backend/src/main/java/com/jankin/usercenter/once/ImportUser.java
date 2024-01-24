package com.jankin.usercenter.once;

import com.alibaba.excel.EasyExcel;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 导入用户到数据库
 */
public class ImportUser {

    public static void main(String[] args) {
        String fileName = "D:\\Code\\user-center\\user-center-backend\\src\\main\\resources\\userExcel.xlsx";
        List<TableUserInfo> userInfoList =
                EasyExcel.read(fileName).head(TableUserInfo.class).sheet().doReadSync();

        System.out.println("总数 = " + userInfoList.size());
        // 判断是否有重复
        Map<String, List<TableUserInfo>> listMap =
                userInfoList.stream()
                        .filter(userInfo -> StringUtils.isNotEmpty(userInfo.getUsername()))
                        .collect(Collectors.groupingBy(TableUserInfo::getUsername));

        for (Map.Entry<String, List<TableUserInfo>> stringListEntry : listMap.entrySet()) {
            if (stringListEntry.getValue().size() > 1) {
                System.out.println("重复昵称：" + stringListEntry.getKey());
            }
        }
        System.out.println("不重复昵称数 = " + listMap.keySet().size());
    }
}