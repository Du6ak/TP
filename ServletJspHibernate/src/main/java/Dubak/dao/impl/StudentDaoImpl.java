package Dubak.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import Dubak.dao.StudentDao;
import Dubak.domain.Student;
import Dubak.util.HibernateUtil;

public class StudentDaoImpl implements StudentDao {

    private static StudentDaoImpl studentDaoImpl = null;

    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public Long saveStudent(Student student) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Long id = (Long) session.save(student);
        transaction.commit();
        session.close();

        return id;
    }

    @Override
    public void updateStudent(Student student) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(student);
        transaction.commit();
        session.close();
    }

    @Override
    public void deleteStudent(Long id) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Student student = session.get(Student.class, id);
        session.delete(student);
        transaction.commit();
        session.close();
    }

    @Override
    public Student findStudentById(Long id) {
        Session session = this.sessionFactory.openSession();
        Student student = session.get(Student.class, id);
        session.close();

        return student;
    }

    @Override
    @SuppressWarnings({ "unchecked", "deprecation" })
    public List<Student> findAllStudents() {
        Session session = this.sessionFactory.openSession();
        List<Student> studentList = session.createCriteria(Student.class).list();
        session.close();

        return studentList;
    }

    public static StudentDao getInstance() {
        if (studentDaoImpl == null)
            studentDaoImpl = new StudentDaoImpl();

        return studentDaoImpl;
    }
}
