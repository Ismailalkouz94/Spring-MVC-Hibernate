/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.spring.service;

import com.mycompany.spring.DAO.DepartmentDAO;
import com.mycompany.spring.model.Department;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ismail
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentDAO departmentDao;

    public void setDepartmentDao(DepartmentDAO departmentDao) {
        this.departmentDao = departmentDao;
    }

    @Override
    @Transactional
    public void addDepartment(Department d) {
        this.departmentDao.addDepartment(d);
    }

    @Override
    @Transactional
    public void updateDepartment(Department d) {
        this.departmentDao.updateDepartment(d);
    }

    @Override
    @Transactional
    public List<Department> listDepartments() {
        return this.departmentDao.listDepartments();
    }

    @Override
    @Transactional
    public Department getDepartmentById(int id) {
        return this.departmentDao.getDepartmentById(id);
    }

    @Override
    @Transactional
    public void removeDepartment(int id) {
        this.departmentDao.removeDepartment(id);
    }

}
