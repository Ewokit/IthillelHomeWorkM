package Service;

import Fields.Student;

import java.util.List;

public interface HibService {
    void addStudent(String stName, String groupName);
    List<Student> getAll();
    List<Student> studentsName(String name);
    Student studentId(int id);
}
