package Treatment.Service;

import DTO.StudentCreate;
import DTO.StudentDTO;

import java.sql.SQLException;
import java.util.List;

public interface Studentbase {
    void addStudent(StudentCreate student) throws SQLException;

    void deleteStudent(int id) throws SQLException;

    List<StudentDTO> getAll() throws SQLException;

    List<StudentDTO> getByName(String studentName) throws SQLException;

    List<StudentDTO> getByIDs(List<Integer> listStudentsIDs) throws SQLException;

    public void updateStudent(StudentDTO student) throws SQLException;
}
