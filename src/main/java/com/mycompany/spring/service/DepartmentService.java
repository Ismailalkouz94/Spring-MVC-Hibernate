/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.spring.service;

import com.mycompany.spring.model.Department;
import com.mycompany.spring.model.Person;
import java.util.List;

/**
 *
 * @author ismail
 */
public interface DepartmentService {

    public void addDepartment(Department d);

    public void updateDepartment(Department d);

    public List<Department> listDepartments();

    public Department getDepartmentById(int id);

    public void removeDepartment(int id);
}
