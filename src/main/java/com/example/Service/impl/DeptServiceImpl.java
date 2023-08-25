package com.example.Service.impl;

import com.example.Mapper.DeptMapper;
import com.example.Service.DeptService;
import com.example.pojo.Dept;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptMapper deptMapper;
    @Override
    public List<Dept> list() {
        return deptMapper.list();
    }

    @Override
    public void delete(Integer id) {
        //调用持久层删除功能
        deptMapper.deleteById(id);
    }

    @Override
    public void add(Dept dept) {
        //补全部门数据
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());
        //调用持久层删除功能
        deptMapper.add(dept);
    }

    @Override
    public Dept query(Integer id) {
        //调用持久层查询功能
        return deptMapper.query(id);
    }

    @Override
    public void update(Dept dept) {
        //更新修改时间
        dept.setUpdateTime(LocalDateTime.now());
        //调用持久层更新功能
        deptMapper.update(dept);
    }
}
