package model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="subject")
public class Subject {

    @Id
    @GeneratedValue
    @Column(name="id")
    private Integer id;

    @Column(name="subjectId")
    private String subject;

    @ManyToMany(mappedBy = "subjects")
    private List<Professor> professors = new ArrayList<Professor>();

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

    public List<Professor> getProfessors() {
        return professors;
    }

    public void setProfessors(List<Professor> professors) {
        this.professors = professors;
    }
}
