package dao;

import model.Grade;
import model.Professor;
import model.Student;
import model.Subject;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class ProfessorDAO {

    public List<Professor> getAllTheProfessors(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        List<Professor> professors = null;
        try{
            tx = session.beginTransaction();
             professors = session.createQuery("FROM professor").list();
            tx.commit();
        }catch(HibernateException he){
            he.printStackTrace();
        }
        return professors;
    }

    public Professor getProfessor(String id, String password) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        Professor professor = null;
        try {
            tx = session.beginTransaction();
            Query query = session.createQuery("from professor where id=:id and password=:password");
            query.setParameter("id", id);
            query.setParameter("password", password);
            professor = (Professor) query.uniqueResult();
        } catch (HibernateException he) {
            he.printStackTrace();
        }
        return professor;
    }

    public void initialize(){
        List<Subject> subjects = new ArrayList<Subject>();
        List<Student> students = new ArrayList<Student>();
        List<Grade> grades = new ArrayList<Grade>();

        Subject math = new Subject();
        math.setSubject("Math");

        Subject softwareEngineering = new Subject();
        softwareEngineering.setSubject("Software Engineering");

        Subject operatingSystems = new Subject();
        operatingSystems.setSubject("Operating Systems");

        subjects.add(math);
        subjects.add(softwareEngineering);
        subjects.add(operatingSystems);

        Grade grade1 = new Grade();
        grade1.setSubject("Math");
        grade1.setGradeVal(5);

        Grade grade2 = new Grade();
        grade2.setSubject("Software Engineering");
        grade2.setGradeVal(5);

        Grade grade3 = new Grade();
        grade3.setSubject("Operating Systems");
        grade3.setGradeVal(5);

        grades.add(grade1);
        grades.add(grade2);
        grades.add(grade3);


        Student student1 = new Student();
        Student student2 = new Student();

        student1.setStudentName("student1");
        student1.setPassword("student1");
        student1.setGrades(grades);

        student2.setStudentName("student2");
        student2.setPassword("student2");
        student2.setGrades(grades);

        students.add(student1);
        students.add(student2);

        Professor professor = new Professor();
        professor.setProfessorName("professor");
        professor.setPassword("password");
        professor.setSubjects(subjects);
        professor.setStudents(students);

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(softwareEngineering);
        session.save(operatingSystems);
        session.save(math);
        session.save(grade1);
        session.save(grade2);
        session.save(grade3);
        session.save(student1);
        session.save(student2);
        session.save(professor);
        session.getTransaction().commit();
        session.close();
    }
}
