package service;

import dao.StudentDAO;
import model.Student;

public class StudentService {

    private StudentDAO sdao = new StudentDAO();

    public Student checkCredentials(String name, String password){
        return sdao.getStudent(name, password);
    }
}
