package model;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="professor")
public class Professor {

    @Id
    @GeneratedValue
    @Column(name="id")
    private Integer id;

    @Column(name="professorName")
    private String professorName;

    @Column(name="password")
    private String password;

    @ManyToMany
    @JoinTable(name="professor_subject",
            joinColumns = @JoinColumn(name = "professorId"),
            inverseJoinColumns = @JoinColumn(name = "subjectId"))
    private List<Subject> subjects = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "professor_student",
                joinColumns = @JoinColumn(name="professorId"),
                inverseJoinColumns = @JoinColumn(name="studentId"))
    private List<Student> students = new ArrayList<>();


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProfessorName() {
        return professorName;
    }

    public void setProfessorName(String professorName) {
        this.professorName = professorName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }
}
