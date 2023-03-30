package Fields;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "proffessor")
public class Proffessor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idProffessor")
    private int idProffessor;

    @Column(name = "fullName")
    private String fullName;

    @ManyToOne
    @JoinColumn(name = "departmentId")
    private Department department;

    public Proffessor(){

    }

    public Proffessor(int idProffessor, String fullName, Department department) {
        this.idProffessor = idProffessor;
        this.fullName = fullName;
        this.department = department;
    }

    @Override
    public String toString() {
        return "Proffessor{" +
                "idProffessor=" + idProffessor +
                ", fullName='" + fullName + '\'' +
                ", department=" + department +
                '}';
    }
}
