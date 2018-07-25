package servlet;

import dao.StudentDAO;
import entity.Student;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

public class StudentListServlet extends HttpServlet {


    protected void doPost(HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        StudentDAO studentDAO = new StudentDAO();
        List<Student> studentList = studentDAO.getStudents();
        for (Student student:studentList){
        }
        //request.setAttribute("studentList",studentList);
        //request.getRequestDispatcher("/studentlist.jsp").forward(request,response);
        int size=0;
        int pageCount = 0;//页数
        int pageSize = 10;//每页总数为10条
        int totalCount=studentList.size();
        int total=totalCount%pageSize;
        int currentPage =0;
        if(total>0) {
            pageCount=totalCount/pageSize+1;
        }else {
            pageCount=totalCount/pageSize;
            System.out.println(pageCount);
        }
        for(int j=1;j<=pageCount;j++){
            if(total==0) {
                studentList = studentList.subList((j-1)* pageSize, pageSize*(j));
                size=studentList.size();
                request.setAttribute("size", size);
                request.setAttribute("pageCount",pageCount );
                request.setAttribute("total",pageCount);
                request.setAttribute("currentPage",currentPage);
                request.setAttribute("studentList",studentList);
                request.getRequestDispatcher("/studentlist.jsp").forward(request,response);
            }else {
                if(j==pageCount) {
                    studentList = studentList.subList((j-1)* pageSize, totalCount);
                    size=studentList.size();
                    request.setAttribute("size", size);
                    request.setAttribute("pageCount",pageCount );
                    request.setAttribute("total",pageCount);
                    request.setAttribute("currentPage",currentPage);
                    request.setAttribute("studentList",studentList);
                    request.getRequestDispatcher("/studentlist.jsp").forward(request,response);
                }else {
                    studentList= studentList.subList((j-1)* pageSize, pageSize*(j) );
                    size=studentList.size();
                    request.setAttribute("size", size);
                    request.setAttribute("pageCount",pageCount );
                    request.setAttribute("total",pageCount);
                    request.setAttribute("currentPage",currentPage);
                    request.setAttribute("studentList",studentList);
                    request.getRequestDispatcher("/studentlist.jsp").forward(request,response);
                }
            }
        }
    }
    protected void doGet(HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}

