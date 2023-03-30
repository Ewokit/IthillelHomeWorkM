package Fields;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "departments")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "departmentId")
    private int departmentsId;

    @Column(name = "nameDep")
    private String nameDep;

    @Column(name = "manager")
    private String manager;

    public Department(){

    }

    public Department(int departmentsId, String nameDep, String manager) {
        this.departmentsId = departmentsId;
        this.nameDep = nameDep;
        this.manager = manager;
    }

    @Override
    public String toString() {
        return "Department{" +
                "departmentsId=" + departmentsId +
                ", nameDep='" + nameDep + '\'' +
                ", manager='" + manager + '\'' +
                '}';
    }
}
