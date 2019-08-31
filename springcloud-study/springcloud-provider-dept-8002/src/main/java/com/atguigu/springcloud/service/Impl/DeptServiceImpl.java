package com.atguigu.springcloud.service.Impl;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.springcloud.dao.DeptDao;
import com.atguigu.springcloud.entities.DeptEntity;
import com.atguigu.springcloud.service.DeptService;

/**
 * @author GongXings
 * @createTime 30 15:04
 * @description
 */
@Service
public class DeptServiceImpl implements DeptService{

    @Autowired
    DeptDao deptDao;
    @Override
    public boolean addDept(DeptEntity deptEntity) {
      return   deptDao.addDept(deptEntity);
    }

    @Override
    public DeptEntity findById(Long deptNo) {
        return  deptDao.findById(deptNo);
    }

    @Override
    public List<DeptEntity> findAll() {
        return deptDao.findAll();
    }
}