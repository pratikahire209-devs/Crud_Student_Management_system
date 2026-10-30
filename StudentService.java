package com.example.crudproject.service;

import com.example.crudproject.entity.Student;
import org.springframework.stereotype.Service;
import com.example.crudproject.repository.StudentRepo;

@Service
public class StudentService {

    private StudentRepo studentrepo;

    public StudentService(StudentRepo studentrepo) {
        this.studentrepo = studentrepo;
    }

    public Student createStudent(Student studentreq) {

        Student studentresp = studentrepo.save(studentreq);
        return studentresp;
    }

    public Student getstudent(Long id) {

        Student studentresp = studentrepo.findById(id).orElse(null);
        return studentresp;
    }

    public Student updatestudent(Long id , Student student){

         Student studentresp = studentrepo.findById(id).orElse(null);

         if(studentresp == null){
             return null;
         }
         studentresp.setName(student.getName());
         studentresp.setBranch(student.getBranch());

         return  studentrepo.save(student);
     }
}