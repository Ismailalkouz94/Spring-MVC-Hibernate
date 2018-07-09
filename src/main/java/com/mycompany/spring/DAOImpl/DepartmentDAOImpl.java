/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.spring.DAOImpl;

import com.mycompany.spring.DAO.DepartmentDAO;
import com.mycompany.spring.model.Department;
import com.mycompany.spring.model.Person;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author ismail
 */
public class DepartmentDAOImpl implements DepartmentDAO {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addDepartment(Department d) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(d);
    }

    @Override
    public void updateDepartment(Department d) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(d);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Department> listDepartments() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Department> departmentList = session.createQuery("from Department").list();
        return departmentList;
    }

    @Override
    public Department getDepartmentById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Department d = (Department) session.load(Department.class, new Integer(id));
        System.out.println("getDepartmentById : " + d);
        return d;
    }

    @Override
    public void removeDepartment(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Department d = (Department) session.load(Department.class, new Integer(id));
        if (d != null) {
            session.delete(d);
        }
    }

}
