package com.example.pojo;

import lombok.Data;

import java.util.List;

@Data
public class PageBean {
    private Long total;
    private List<Emp> rows;

    public PageBean() {
    }

    public PageBean(Long count, List<Emp> empList) {
        this.total = count;
        this.rows = empList;
    }

}
