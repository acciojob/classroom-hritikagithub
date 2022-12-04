package com.driver;


import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

@Repository
public class StudentRepository {

    private HashMap<String, Student> StudentsList;
    private HashMap<String,Teacher> TeachersList;
    private HashMap<String, List<String>> StudentTeacherList;

    public StudentRepository(){
        this.StudentsList = new HashMap<String,Student>();
        this.TeachersList = new HashMap<String, Teacher>();
        this.StudentTeacherList = new HashMap<String, List<String>>();
    }
    public void addStudent(Student student){
        StudentsList.put(student.getName(), student);
    }

    public void addTeacher(Teacher teacher){
        TeachersList.put(teacher.getName(), teacher);
    }
    public void addStudentTeacherPair(String student, String teacher){
        if(StudentsList.containsKey(student) && TeachersList.containsKey(teacher)){
            StudentsList.put(student, StudentsList.get(student));
            TeachersList.put(teacher, TeachersList.get(teacher));
            List<String> currentStudents = new ArrayList<String>();
            if(StudentTeacherList.containsKey(teacher)) currentStudents = StudentTeacherList.get(teacher);
            currentStudents.add(student);
            StudentTeacherList.put(teacher, currentStudents);
        }
    }


    public Student findStudent(String student){
        return StudentsList.get(student);
    }

    public Teacher findTeacher(String teacher){
        return TeachersList.get(teacher);
    }

    public List<String> findStudentFromTeacher(String teacher){
        List<String> students = new ArrayList<String>();
        if(StudentTeacherList.containsKey(teacher)) students = StudentTeacherList.get(teacher);
        return students;
    }

    public List<String> findAllStudents(){
        return new ArrayList<>(StudentsList.keySet());
    }

    public void removeTeacher(String teacher){
        List<String> students = new ArrayList<String>();
        if(StudentTeacherList.containsKey(teacher)){
            students = StudentTeacherList.get(teacher);
            for(String student: students){
                if(StudentsList.containsKey(student)){
                   StudentsList.remove(student);
                }
            }

            StudentTeacherList.remove(teacher);
        }

        if(TeachersList.containsKey(teacher)){
            TeachersList.remove(teacher);
        }
    }
    public void removeAllTeachers(){
        HashSet<String> StudentSet = new HashSet<String>();

        //directorMap = new HashMap<>();

        for(String teacher: StudentTeacherList.keySet()){
            for(String student: StudentTeacherList.get(teacher)){
                StudentSet.add(student);
            }
        }

        for(String student: StudentSet){
            if(StudentsList.containsKey(student)){
                StudentsList.remove(student);
            }
        }
    }

}
