package Treatment;

import DTO.StudentCreate;
import DTO.StudentDTO;
import Treatment.Service.Impl.StudentBaseImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api/")
@RequiredArgsConstructor
@Slf4j
public class StudentTreat {
    StudentBaseImpl studentBase = new StudentBaseImpl();

    @PostMapping("students")
    int createStudent (@RequestBody StudentCreate student) throws SQLException {
        studentBase.addStudent(student);
        return 0;
    }
    @PutMapping("students")
    boolean uppStudent(@RequestBody StudentDTO studentDTO) throws SQLException {
        studentBase.updateStudent(studentDTO);
        return true;
    }
    @DeleteMapping("students")
    boolean dropStudent(@PathVariable Integer id) throws SQLException {
        studentBase.deleteStudent(id);
        return true;
    }
    @GetMapping("students")
    List<StudentDTO> dtos() throws SQLException {
        return studentBase.getAll();
    }
    @GetMapping("students")
    List<StudentDTO> studentDTOSByName(@PathVariable String name) throws SQLException {
        return studentBase.getByName(name);
    }
    @GetMapping("students")
    List<StudentDTO> studentDTOSByIDs(@RequestBody List<Integer> IDs) throws SQLException {
        return studentBase.getByIDs(IDs);
    }
}
