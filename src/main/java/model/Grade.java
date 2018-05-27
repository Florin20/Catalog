package model;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="grade")
public class Grade {

    @Id
    @GeneratedValue
    @Column(name="id")
    private Integer id;

    @Column(name="subject")
    private String subject;

    @Column(name="gradeVal")
    private Integer gradeVal;

    @ManyToMany
    @JoinTable(name="grade_student",
            joinColumns = @JoinColumn(name = "gradeId"),
            inverseJoinColumns = @JoinColumn(name = "studentId"))
    private List<Student> studentsG = new ArrayList<Student>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Integer getGradeVal() {
        return gradeVal;
    }

    public void setGradeVal(Integer gradeVal) {
        this.gradeVal = gradeVal;
    }

    public List<Student> getStudents() {
        return studentsG;
    }

    public void setStudents(List<Student> students) {
        this.studentsG = students;
    }
}
