package com.stone.shs.service;

import com.stone.shs.model.Employee;

import java.util.List;

/**
 * Created by Administrator on 2017/2/22.
 */
public interface IEmpService {
    public void save(Employee emp);
    public Employee load(int id);
    public List<Employee> list();
    public List<Employee> list(int pageIndex, int pageSize);
}
