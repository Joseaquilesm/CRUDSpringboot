package com.pucmm.springboot.services;


import com.pucmm.springboot.entity.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class StudentServices {

 private List<Student> studentList = new ArrayList<>();


//Función Create Estudiante
  public boolean createStudent(Student student){
      if(studentList.add(student)){
          return true;
      }
      return false;
  }

  public Student readStudent(int idStudent){
      for(Student s : studentList){
          if(s.getIdStudent() == idStudent){
              return s;
          }
      }
      return null;
  }

    public boolean updateStudent(Student student){
        for(Student s : studentList){
            if(s.getIdStudent() == student.getIdStudent()){
                studentList.set(studentList.indexOf(s), student);
                return true;
            }
        }
       return false;
    }

 public boolean deleteStudent(int idStudent){
      for(Student s: studentList){
          if(s.getIdStudent() == idStudent){
              studentList.remove(s);
              return true;
          }

      }
      return false;
 }



 public List<Student> allStudents(){


      return studentList;
 }

}

