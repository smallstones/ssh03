package com.stone.shs.service;

import com.stone.shs.dao.IEmpDao;
import com.stone.shs.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Administrator on 2017/2/22.
 */
public class EmpService implements IEmpService {

    @Autowired
    private IEmpDao empDao;

    @Override
    public void save(Employee emp) {
        empDao.add(emp);
    }

    @Override
    public Employee load(int id) {
        return empDao.load(id);
    }

    @Override
    public List<Employee> list() {
        return empDao.list("from Employee");
    }

    @Override
    public List<Employee> list(int pageIndex, int pageSize) {
        return empDao.list("from Employee",null,pageIndex,pageSize);
    }
}
