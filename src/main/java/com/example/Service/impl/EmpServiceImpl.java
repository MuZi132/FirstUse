package com.example.Service.impl;

import com.example.Mapper.EmpMapper;
import com.example.Service.EmpService;
import com.example.pojo.Emp;
import com.example.pojo.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpMapper empMapper;

    @Override
    public void save(Emp emp) {
        //补全数据
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        //调用添加方法
        empMapper.insert(emp);
    }

    @Override
    public PageBean page(Integer page, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end) {
        //1、获取总记录数
        Long count = empMapper.count(name,gender,begin,end);
        //2、获取分页查询结果列表
        Integer start = (page - 1) * pageSize;//计算其实索引，公式：（页码-1）*每页展示数据数
        List<Emp> empList = empMapper.list(start, pageSize,name,gender,begin,end);
        //3、封装PageBean对象
        PageBean pageBean = new PageBean(count, empList);
        return pageBean;
    }

    @Override
    public void delete(List<Integer> ids) {
        empMapper.delete(ids);
    }

    @Override
    public void update(Emp emp) {
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.update(emp);
    }

    @Override
    public Emp selectById(Integer id) {
        Emp emp = empMapper.selectById(id);
        return emp;
    }

    @Override
    public Emp login(Emp emp) {
        Emp loginEmp = empMapper.getByUsernameAndPassWord(emp);

        return loginEmp;
    }
}
