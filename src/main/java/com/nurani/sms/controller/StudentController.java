package com.nurani.sms.controller;


import com.nurani.sms.entity.Student;
import com.nurani.sms.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class StudentController {
    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    @GetMapping("/students")
    public String listStudents(Model model){
        model.addAttribute("students",studentService.getAllStudents());
        return "students";
    }

    @GetMapping("/students/new")
    public String createStudentForm(Model model){
        Student student = new Student();
        model.addAttribute("student",student);
        return "create_student";
    }

    @PostMapping("/students")
    public String saveStudent(@ModelAttribute("student") Student student){
        studentService.saveStudent(student);
        return "redirect:/students";
    }
    @GetMapping("/students/edit/{id}")
    public String editStudentForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("student",studentService.getStudentById(id));
        return "edit_student";
    }

    @PostMapping("/students/{id}")
    public String updateStudent(@PathVariable("id") Long id,
                                @ModelAttribute("student") Student student,
                                Model model){
        Student existingStudent = studentService.getStudentById(id);
        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());
        existingStudent.setEmail(student.getEmail());

        studentService.updateStudent(existingStudent);
        return "redirect:/students";
    }

    @GetMapping("/students/{id}")
    public String deleteStudent(@PathVariable("id") Long id){
        studentService.deleteStudent(id);
        return "redirect:/students";
    }
}
