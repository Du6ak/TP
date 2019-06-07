package Dubak.dao;

import java.util.List;

import Dubak.domain.Student;

public interface StudentDao {
    Long saveStudent(Student student);

    void updateStudent(Student student);

    void deleteStudent(Long id);

    Student findStudentById(Long id);

    List<Student> findAllStudents();
}
