package Dubak.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dubak.dao.StudentDao;
import Dubak.dao.impl.StudentDaoImpl;
import Dubak.domain.Student;

@WebServlet("/student/register")
public class StudentRegistrationController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private StudentDao studentDao = StudentDaoImpl.getInstance();

    public StudentRegistrationController() {
        // Do Nothing
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String studId = request.getParameter("id");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String mobile = request.getParameter("mobile");

        Student student = new Student(firstName, lastName, email, mobile);

        if (studId == null || studId == "")
            studentDao.saveStudent(student);
        else {
            Long id = Long.parseLong(studId);
            student.setId(id);
            studentDao.updateStudent(student);
        }

        response.sendRedirect(request.getContextPath() + "/");
    }

}
