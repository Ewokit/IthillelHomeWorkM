package Fields;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "points")
public class Points {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "id")
    private Student student;

    @Column(name = "lessons")
    private String lessons;

    @Column(name = "lesPoint")
    private int lesPoint;

    public Points(){

    }

    public Points(int id, Student student, String lessons, int lesPoint) {
        this.id = id;
        this.student = student;
        this.lessons = lessons;
        this.lesPoint = lesPoint;
    }

    @Override
    public String toString() {
        return "Points{" +
                "id=" + id +
                ", student=" + student +
                ", lessons='" + lessons + '\'' +
                ", lesPoint=" + lesPoint +
                '}';
    }
}
