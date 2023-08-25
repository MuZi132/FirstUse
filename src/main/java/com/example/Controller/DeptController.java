package com.example.Controller;

import com.example.Service.DeptService;
import com.example.pojo.Dept;
import com.example.pojo.Emp;
import com.example.pojo.Result;
import jakarta.websocket.server.PathParam;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/depts")
public class DeptController {
    @Autowired
    private DeptService deptService;

    /**
     * 查询所有部门数据
     * @return
     */
    @GetMapping
    public Result list() {
        log.info("查询所有部门数据");
        List<Dept> deptList = deptService.list();
        return Result.success(deptList);
    }

    /**
     * 根据id删除部门
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public Result delete (@PathVariable Integer id){
        //日志记录
        log.info("根据id删除部门");
        //调用service层功能
        deptService.delete(id);
        return Result.success();
    }

    /**
     * 新增部门
     * @param dept
     * @return
     */
    @PostMapping
    public Result add(@RequestBody Dept dept){
        //记录日志
        log.info("新增部门：" + dept);
        //调用service层添加功能
        deptService.add(dept);
        return Result.success();
    }

    /**
     * 根据id查询部门
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result queryById(@PathVariable Integer id){
        //记录日志
        log.info("根据id查询部门");
        //调用service层查询功能
        Dept dept = deptService.query(id);
        return Result.success(dept);
    }

    /**
     *修改部门
     * @param dept
     * @return
     */
    @PutMapping
    public Result update(@RequestBody Dept dept){
        //记录日志
        log.info("修改部门");
        //调用service层修改功能
        deptService.update(dept);
        return Result.success();
    }
}
