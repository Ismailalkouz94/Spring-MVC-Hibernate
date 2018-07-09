/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.spring.controller;

import com.mycompany.spring.model.Department;
import com.mycompany.spring.model.Person;
import com.mycompany.spring.service.DepartmentService;
import com.mycompany.spring.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author ismail
 */
@Controller
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

//    @Autowired(required = true)
//    @Qualifier(value = "departmentService")
    public void setdepartmentService(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @RequestMapping(value = "/departments", method = RequestMethod.GET)
    public String listDepartmentServices(Model model) {

        model.addAttribute("department", new Department());
        model.addAttribute("listDepartments", this.departmentService.listDepartments());
        return "department";
    }

    @RequestMapping(value = "/department/add", method = RequestMethod.POST)
    public String addDepartment(@ModelAttribute("department") Department d) {
        if (d.getId() == 0) {
            this.departmentService.addDepartment(d);
        } else {
            this.departmentService.updateDepartment(d);
        }
        return "redirect:/departments";
    }

    @RequestMapping(value = "/removeDept/{id}")
    public String removeDepartment(@PathVariable("id") int id) {
        this.departmentService.removeDepartment(id);
        return "redirect:/departments";
    }

    @RequestMapping("/editDept/{id}")
    public String editDepartment(@PathVariable("id") int id, Model model) {
        model.addAttribute("department", this.departmentService.getDepartmentById(id));
        System.out.println(" this.departmentService.getDepartmentById(id) :"+ this.departmentService.getDepartmentById(id));
        model.addAttribute("listDepartments", this.departmentService.listDepartments());
        return "department";
    }

}
