package com.pucmm.springboot.controller;


import com.pucmm.springboot.entity.Student;
import com.pucmm.springboot.services.StudentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StudentController {
  @Autowired
  private StudentServices service;

  @RequestMapping(path = "/", method = RequestMethod.GET)
  public String home(Model model) {
    if(service.allStudents() == null){
      model.addAttribute("studentList", "empty");
    }else {
      model.addAttribute("studentList", service.allStudents());
    }
    return "home";
  }
//
  //create
  @RequestMapping(path = "/newStudent", method = RequestMethod.GET)
  public String create() {
    return "newStudent";
  }

  //create w/ Post
  @RequestMapping(path = "/newStudent", method = RequestMethod.POST)
  public String createPost(@RequestParam int idStudent, @RequestParam String name, @RequestParam String lastName, @RequestParam String phone) {
    Student student = new Student(idStudent, name, lastName, phone);
    service.createStudent(student);
    return "redirect:/";
  }
  //read
  @RequestMapping(path = "/readStudent/{idStudent}", method = RequestMethod.GET)
    public String readStudent(Model model, @PathVariable int idStudent){
      model.addAttribute("student",service.readStudent(idStudent));
    return "readStudent";
  }
  //update

  @RequestMapping(path = "/updateStudent/{idStudent}", method = RequestMethod.GET)
  public String update(Model model, @PathVariable int idStudent ){
    model.addAttribute("student", service.readStudent(idStudent));
    return "updateStudent";
  }

  @RequestMapping(path = "/updateStudent", method = RequestMethod.POST)
  public String update(@RequestParam int idStudent, @RequestParam String name, @RequestParam String lastName, @RequestParam String phone) {
    Student student = new Student(idStudent, name, lastName, phone);
    service.updateStudent(student);
    return "redirect:/";

  }
  @RequestMapping(path = "/deleteStudent/{idStudent}", method = RequestMethod.GET)
  public String deleteStudent(@PathVariable int idStudent) {
    service.deleteStudent(idStudent);
    return "redirect:/";
  }

}