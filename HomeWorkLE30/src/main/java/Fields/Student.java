package Fields;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.swing.*;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "groupid")
    private GroupLayout.Group group;

    @Column(name = "yearADM")
    @Temporal(TemporalType.DATE)
    private Date yearADM;

    public Student(String stName, String groupName) {

    }
    public Student(String studentName, GroupLayout.Group group) {
        this.name = studentName;
        this.group = group;
        this.yearADM = new Date();
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", group=" + group +
                ", yearADM=" + yearADM +
                '}';
    }

}
