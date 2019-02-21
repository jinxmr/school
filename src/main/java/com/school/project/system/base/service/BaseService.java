package com.school.project.system.base.service;

import java.util.List;

public interface BaseService<T> {

    List<T> selectAll();
}
