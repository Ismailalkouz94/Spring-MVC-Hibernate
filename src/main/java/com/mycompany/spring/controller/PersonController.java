/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.spring.controller;

import com.mycompany.spring.model.Person;
import com.mycompany.spring.service.DepartmentService;
import com.mycompany.spring.service.PersonService;
import java.lang.reflect.Method;
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
public class PersonController {

    @Autowired
    private PersonService personService;

    @Autowired
    private DepartmentService departmentService;

//    @Autowired(required = true)
//    @Qualifier(value = "departmentService")
    public void setDepartmentService(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

//    @Autowired(required = true)
//    @Qualifier(value = "personService")
    public void setPersonService(PersonService personService) {
        this.personService = personService;
    }

    @RequestMapping(value = "/persons", method = RequestMethod.GET)
    public String listPersons(Model model) {

        model.addAttribute("person", new Person());
        model.addAttribute("listPersons", this.personService.listPersons());
        model.addAttribute("listDept", this.departmentService.listDepartments());
        return "person";
    }

    @RequestMapping(value = "/person/add", method = RequestMethod.POST)
    public String addPerson(@ModelAttribute("person") Person p) {
        if (p.getId() == 0) {
            this.personService.addPerson(p);
        } else {
            this.personService.updatePerson(p);
        }
        return "redirect:/persons";
    }

    @RequestMapping(value = "/remove/{id}")
    public String removePerson(@PathVariable("id") int id) {
        this.personService.removePerson(id);
        return "redirect:/persons";
    }

    @RequestMapping("/edit/{id}")
    public String editPerson(@PathVariable("id") int id, Model model) {
        System.out.println("id :" + id);
        model.addAttribute("person", this.personService.getPersonById(id));
//        System.out.println("this.personService.getPersonById(id) :" + this.personService.getPersonById(id));
        model.addAttribute("listPersons", this.personService.listPersons());
        System.out.println("");
        return "person";
    }

}
