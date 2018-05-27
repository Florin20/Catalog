package dao;

import model.Student;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class StudentDAO {

    public Student getStudent(String name, String password){
        Student student = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("from Student where studentId=:sid");
        query.setParameter("sid", name);
        Student temp = (Student) query.uniqueResult();
        if(temp != null){
            if(temp.getPassword().equals(password)){
                student = temp;
            }
        }
        session.close();
        return student;
    }
}
