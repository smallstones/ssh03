package com.stone.shs.controller;

import com.stone.shs.model.Employee;
import com.stone.shs.service.IEmpService;
import org.omg.CORBA.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by Administrator on 2017/2/22.
 */
@Controller
@RequestMapping("/emp")
public class EmpController {
    @Autowired
    private IEmpService empService;

    @RequestMapping("/list")
    public String list(Model model){
        List<Employee> list = empService.list();
        model.addAttribute("emps",list);
        return "emp/list";
    }

    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public String add(){
        return "emp/add";
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String add(Employee emp){
        empService.save(emp);
        return "redirect:/emp/list";
    }
}






