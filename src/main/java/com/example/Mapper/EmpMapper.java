package com.example.Mapper;

import com.example.pojo.Emp;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface EmpMapper {
    //新增员工
    @Insert("insert into emp (username, name, gender, image, job, entrydate, dept_id, create_time, update_time) " +
            "value (#{username},#{name},#{gender},#{image},#{job},#{entrydate},#{deptId},#{createTime},#{updateTime})")
    void insert(Emp emp);

    //获取总记录数

    Long count(String name, Short gender, LocalDate begin,LocalDate end);

    //获取当前页的结构列表
    List<Emp> list(Integer start, Integer pageSize, String name, Short gender, LocalDate begin,LocalDate end);

    void delete(List<Integer> ids);

    @Update("UPDATE emp " +
            "SET username = #{username}," +
            "    name = #{name}," +
            "    gender = #{gender}," +
            "    image = #{image}," +
            "    dept_id = #{deptId}," +
            "    entrydate = #{entrydate}," +
            "    job = #{job} " +
            "WHERE id = #{id}")
    void update(Emp emp);

    @Select("select * from emp where id = #{id}")
    Emp selectById(Integer id);

    @Select("select id, username, password, name, gender, image, job, entrydate, dept_id, create_time, update_time " +
            "from emp " +
            "where username=#{username} and password =#{password}")
    Emp getByUsernameAndPassWord(Emp emp);
}
