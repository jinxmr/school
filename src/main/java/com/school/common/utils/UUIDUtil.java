package com.school.common.utils;

import java.util.UUID;

/**
 * Created by Administrator on 2019/2/19.
 */
public class UUIDUtil {

    /**
     * 获取UUID
     */
    public static String getUUID() {
        String uuid = UUID.randomUUID().toString().replace("-", "");
        return uuid;
    }
}