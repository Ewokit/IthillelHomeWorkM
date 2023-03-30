package Fields;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "qgroup")
public class Qgroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "groupID")
    private int groupID;

    @Column(name = "groupsName")
    private String groupsName;

    public Qgroup(String groupName) {

    }

    public Qgroup(int groupID, String groupsName) {
        this.groupID = groupID;
        this.groupsName = groupsName;
    }

    @Override
    public String toString() {
        return "Qgroup{" +
                "groupID=" + groupID +
                ", groupsName='" + groupsName + '\'' +
                '}';
    }
}
