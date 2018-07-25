package dao;

import entity.Student;
import redis.clients.jedis.Jedis;
import utils.SerializeUitl;

import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
    private List<Student>students;
    public StudentDAO(){
        load();
    }

    public void save() {
        Jedis jedis = new Jedis("47.93.234.217", 6379);
        System.out.println("连接Redis成功！");
        jedis.set("students".getBytes(), SerializeUitl.serialize(students));
        jedis.bgsave();
        jedis.close();
    }

    /*
     * 从redis数据库中加载数据
     */
    public void load() {
        Jedis jedis = new Jedis("47.93.234.217", 6379);
        System.out.println("连接Redis成功！");
        byte[] byties = jedis.get("students".getBytes());
        if (byties != null && byties.length > 0) {
            students = SerializeUitl.deSerialize(byties, Student.class);
        }else{
            students=new ArrayList<Student>();
        }
        jedis.close();
    }

    public void add(Student student){
        this.students.add(student);
        save();
    }
    public Student getStudentByIds(int ids){
        for (Student student :students){
            if (student.getIds()==ids){
                return student;
            }
        }
        return null;
    }
    public void remove(int ids){
        students.remove(getStudentByIds(ids));
        save();
    }
    public List<Student> getStudents(){
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
        save();
    }
}
