package Dubak.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dubak.dao.StudentDao;
import Dubak.dao.impl.StudentDaoImpl;

@WebServlet("/student/delete")
public class DeleteStudentController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public DeleteStudentController() {
        // Do Nothing
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String studId = request.getParameter("studId");

        if (studId == "" || studId == null)
            request.getRequestDispatcher("/").forward(request, response);
        else {
            Long id = Long.parseLong(studId);
            StudentDao studentDao = StudentDaoImpl.getInstance();

            studentDao.deleteStudent(id);

            response.sendRedirect(request.getContextPath() + "/");
        }
    }
}
