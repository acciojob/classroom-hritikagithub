package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public void addStudent(Student student){
        studentRepository.addStudent(student);
    }

    public void addTeacher(Teacher teacher){
       studentRepository.addTeacher(teacher);
    }
    public void createStudentTeacherPair(String student, String teacher){
        studentRepository.addStudentTeacherPair(student, teacher);
    }
    public Student findStudent(String studentName){
        return studentRepository.findStudent(studentName);
    }

    public Teacher findTeacher(String teacherName){
        return studentRepository.findTeacher(teacherName);
    }
    public List<String> findStudentFromTeacher(String teacherName){
        return studentRepository.findStudentFromTeacher(teacherName);
    }

    public List<String> findAllStudents(){
        return studentRepository.findAllStudents();
    }

    public void removeTeacher(String teacher){
        studentRepository.removeTeacher(teacher);
    }
    public void removeAllTeachers(){
        studentRepository.removeAllTeachers();
    }

}

