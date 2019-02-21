package com.school.project.system.base.service;


import com.school.project.system.base.mapper.BaseMapper;

import java.util.List;

/**
 * 方法描述：
 * 创建人：jxm
 * 创建时间：2019/2/218:44
 */
public abstract class BaseServiceImpl<T> implements BaseService<T> {

    protected abstract BaseMapper<T> getBaseMapper();

    @Override
    public List<T> selectAll() {
        List<T> list = this.getBaseMapper().selectList();
        return list;
    }
}
