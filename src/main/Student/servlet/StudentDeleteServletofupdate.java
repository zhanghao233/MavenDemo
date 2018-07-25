package servlet;

import dao.StudentDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class StudentDeleteServletofupdate extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        int ids = Integer.parseInt(request.getParameter("ids"));
        System.out.println(ids);
        StudentDAO studentDAO = new StudentDAO();
        studentDAO.remove(ids);
        request.getRequestDispatcher("/studentupdate.jsp").forward(request,response);
    }
}
