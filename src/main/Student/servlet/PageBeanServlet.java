package servlet;

import dao.StudentDAO;
import entity.Student;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class PageBeanServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer currentPage=Integer.parseInt(request.getParameter("currentPage"));
        StudentDAO studentDAO = new StudentDAO();
        List<Student> studentList = studentDAO.getStudents();
        for (Student student:studentList){
        }
        List<Student> studentList1 = studentDAO.getStudents();
        for (Student student:studentList1){
        }
        int size=0;//当前页有几条信息
        int pageCount = 0;//页数
        int pageSize = 10;//每页总数为10条
        int totalCount=studentList1.size();
        int total=totalCount%pageSize;
        if(total>0) {
            pageCount=totalCount/pageSize+1;
        }else {
            pageCount=totalCount/pageSize;
        }
        for(int j=1;j<=pageCount;j++){
            if(total==0) {
                if(currentPage<=0) {
                    currentPage=0;
                    studentList = studentList1.subList((0)* pageSize, pageSize*(0+1));
                }
                if(currentPage>=pageCount) {
                    studentList = studentList1.subList((currentPage-1)* pageSize, totalCount);
                    currentPage=pageCount-1;
                }
                if(0<currentPage&&currentPage<pageCount) {
                    if((j-1)==currentPage) {
                        if((currentPage+1)==pageCount) {
                            studentList = studentList1.subList((currentPage)* pageSize, totalCount);
                        }else { studentList= studentList1.subList((currentPage)* pageSize, pageSize*(currentPage+1) );
                        }
                    }
                    if(j==pageCount) {
                        studentList = studentList1.subList((currentPage)* pageSize, totalCount);
                    }
                }
            }else {
                if(currentPage<=0) {
                    currentPage=0;
                    studentList = studentList1.subList((0)* pageSize, pageSize*(0+1));
                }
                if(currentPage>=pageCount) {
                    studentList = studentList1.subList((currentPage-1)* pageSize, totalCount);
                    currentPage=pageCount-1;
                }
                if(0<currentPage&&currentPage<pageCount) {
                    if((j-1)==currentPage) {
                        if((currentPage+1)==pageCount) {
                            studentList = studentList1.subList((currentPage)* pageSize, totalCount);
                        }else {
                            studentList= studentList1.subList((currentPage)* pageSize, pageSize*(currentPage+1) );
                        }
                    }
                    if(j==pageCount) {
                        studentList = studentList1.subList((currentPage)* pageSize, totalCount);
                    }
                }
            }
            size=studentList.size();
        }
        request.setAttribute("size", size);
        request.setAttribute("pageCount",pageCount );
        request.setAttribute("total",pageCount);
        request.setAttribute("currentPage",currentPage);
        request.setAttribute("studentList",studentList);
        request.getRequestDispatcher("/studentlist.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            this.doPost(request, response);
    }
}
