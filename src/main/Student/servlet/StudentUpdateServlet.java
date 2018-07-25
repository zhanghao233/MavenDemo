package servlet;

import dao.StudentDAO;
import entity.Student;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StudentUpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        long nowTime = System.currentTimeMillis()/1000;
        Integer nowTimeInt = new Long(nowTime).intValue();
        int ids = nowTimeInt;
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String birthday = request.getParameter("birthday");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = simpleDateFormat.parse(birthday  );

        } catch (ParseException e) {
            e.printStackTrace();
        }
        String description = request.getParameter("description");
        int avgscore = Integer.parseInt(request.getParameter("avgscore"));
        Student student = new Student(ids,id,name,date,description,avgscore);
        StudentDAO studentDAO = new StudentDAO();
        studentDAO.add(student);
        request.getRequestDispatcher("StudentListServlet").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);

    }
}
