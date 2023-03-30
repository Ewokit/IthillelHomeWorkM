package Fields;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "lessons")
public class Lessons {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idLessons")
    private int idLessons;

    @Column(name = "nameLess")
    private String nameLess;

    @ManyToOne
    @JoinColumn(name = "idProffessor")
    private Proffessor proffessor;

    @Column(name = "semester")
    private int semester;

    @Column(name = "yearId")
    private int yearId;

    public Lessons(){

    }

    public Lessons(int idLessons, String nameLess, Proffessor proffessor, int semester, int yearId) {
        this.idLessons = idLessons;
        this.nameLess = nameLess;
        this.proffessor = proffessor;
        this.semester = semester;
        this.yearId = yearId;
    }

    @Override
    public String toString() {
        return "Lessons{" +
                "idLessons=" + idLessons +
                ", nameLess='" + nameLess + '\'' +
                ", proffessor=" + proffessor +
                ", semester=" + semester +
                ", yearId=" + yearId +
                '}';
    }
}
