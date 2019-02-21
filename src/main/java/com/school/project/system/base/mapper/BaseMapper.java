package com.school.project.system.base.mapper;

import java.util.List;
import java.util.Map;

public interface BaseMapper<T> {

    <V extends T> List<V> selectList();

    <V extends T> List<V> selectList(Map<String, Object> query);
}
