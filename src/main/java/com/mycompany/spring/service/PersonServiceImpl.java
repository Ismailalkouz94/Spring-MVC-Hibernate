/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.spring.service;

import com.mycompany.spring.DAO.PersonDAO;
import com.mycompany.spring.model.Person;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ismail
 */
@Service
public class PersonServiceImpl implements PersonService {
    
    private PersonDAO personDao;
    
    public void setPersonDao(PersonDAO personDao) {
        this.personDao = personDao;
    }
    
    @Override
    @Transactional
    public void addPerson(Person p) {
        this.personDao.addPerson(p);
    }
    
    @Override
    @Transactional
    public void updatePerson(Person p) {
        this.personDao.updatePerson(p);
    }
    
    @Override
    @Transactional
    public List<Person> listPersons() {
        return this.personDao.listPersons();
    }
    
    @Override
    @Transactional
    public Person getPersonById(int id) {
        return this.personDao.getPersonById(id);
    }
    
    @Override
    @Transactional
    public void removePerson(int id) {
        this.personDao.removePerson(id);
    }
    
}
