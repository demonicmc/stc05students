package main.controllers;

import main.models.pojo.Student;
import main.services.StudentService;
import main.services.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 19.04.2017.
 */
public class ListServlet extends HttpServlet {


    private StudentService studentService;

    public StudentService getStudentService() {
        return studentService;
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        SpringBeanAutowiringSupport.
                processInjectionBasedOnServletContext(this,
                        config.getServletContext());
    }

    @Autowired
    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("studentHello", "Hello student from servlet!");
        req.setAttribute("studentList", studentService.getAllStudents());
        req.getRequestDispatcher("/list.jsp").forward(req, resp);
    }
}
