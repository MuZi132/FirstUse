package com.example.Service;

import com.example.pojo.Emp;
import com.example.pojo.PageBean;
import org.apache.ibatis.annotations.Update;

import java.time.LocalDate;
import java.util.List;

public interface EmpService {
    /**
     * 添加员工
     * @param emp
     */
    void save(Emp emp);

    /**
     * 分页查询员工
     * @param page       页数
     * @param pageSize   每页显示数据数
     * @param name       姓名
     * @param gender     性别
     * @param begin      开始时间
     * @param end        结束时间
     * @return
     */
    PageBean page(Integer page, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end);

    void delete(List<Integer> ids);

    void update(Emp emp);

    Emp selectById(Integer id);

    Emp login(Emp emp);
}
