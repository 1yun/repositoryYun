package com.atguigu.springcloud.dao;

import org.apache.ibatis.annotations.Mapper;

import com.atguigu.springcloud.entities.DeptEntity;

import java.util.List;

/**
 * @author GongXings
 * @createTime 30 14:48
 * @description
 */
@Mapper
public interface DeptDao {

    /**
     * 插入
     * @param deptEntity
     *
     * @return
     */
    boolean addDept(DeptEntity deptEntity);

    /**
     * 根据id查找
     * @param deptNo
     * @return
     */
    DeptEntity findById(Long deptNo);

    /**
     * 查询全部
     * @return
     */
    List<DeptEntity> findAll();

}