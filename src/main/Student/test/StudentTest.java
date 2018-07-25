package test;

import dao.StudentDAO;
import entity.Student;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StudentTest {
    static StudentDAO studentDAO;
    public static void main(String[] args){
        //testSetStudents();
        testGetStudents();
        //testAdd();
        //testGetStudentsByIds();
        //testRemove();
    }
    public  static void testSetStudents() {
        StudentDAO studentDAO = new StudentDAO();
        List<Student> student=new ArrayList<Student>();
        student.add(new Student(1001, "0001", "zhangsan",new Date(),"ssss",99));
        studentDAO.setStudents(student);
        System.out.println("---------------------1---------------------");
        System.out.println(student);
    }

    /*
     * 查询所有
     */

    public static void testGetStudents() {
        StudentDAO studentDAO = new StudentDAO();
        List<Student> students = studentDAO.getStudents();
        System.out.println("------------------4-----------------------");
        for (Student student : students) {
            System.out.println(student);
        }
    }

    /*
     * 增加一辆车
     */

    public static void testAdd() {
        StudentDAO studentDAO = new StudentDAO();
        studentDAO.add(new Student(1006, "豪华", "0006",new Date(),"ssss",76));
    }

    /*
     * 根据编号获得一辆车
     */

    public static void testGetStudentsByIds() {
        StudentDAO studentDAO = new StudentDAO();
        System.out.println("----------获得编号为0001的数据----------");
        System.out.println(studentDAO.getStudentByIds(6));
    }

    /*
     * 移除汽车
     */

    public static void testRemove() {
        StudentDAO studentDAO = new StudentDAO();
        System.out.println("----------移除编号为0006的数据----------");
        studentDAO.remove(1);
    }
}
