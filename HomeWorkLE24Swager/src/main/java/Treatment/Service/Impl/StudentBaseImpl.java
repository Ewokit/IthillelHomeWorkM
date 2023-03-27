package Treatment.Service.Impl;

import DTO.StudentCreate;
import DTO.StudentDTO;
import Treatment.Service.Studentbase;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import Exception.UserNotFoundException;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentBaseImpl implements Studentbase {
    public static final String serverZone = "UTC";
    public static final String serverName = "localhost";
    public static final String databaseName = "hillelsttest";
    public static final Integer portNumber = 3306;
    public static final String user = "root";
    public static final String password = "RootrootSQL";

    private Connection getConnection() throws SQLException {
        MysqlDataSource mysqlDataSource = new MysqlDataSource();
        mysqlDataSource.setUseSSL(false);
        mysqlDataSource.setServerTimezone(serverZone);
        mysqlDataSource.setServerName(serverName);
        mysqlDataSource.setDatabaseName(databaseName);
        mysqlDataSource.setPortNumber(portNumber);
        mysqlDataSource.setUser(user);
        mysqlDataSource.setPassword(password);

        return mysqlDataSource.getConnection();
    }

    @Override
    public void addStudent(StudentCreate student) throws SQLException {
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        String SQL = "insert into students (name, group_id, date) value  ('%s', '%s', '%s')";
        statement.execute(String.format(SQL, student.getName(), student.getDate(), student.getIdGroup()));
        connection.close();
    }

    @Override
    public void deleteStudent(int id) throws SQLException {
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        String SQL = "DELETE FROM students WHERE id = %s";
        statement.execute(String.format(SQL, id));
        connection.close();
    }

    private List<StudentDTO> getStudentsFromDB(ResultSet resultSet) throws SQLException {
        List<StudentDTO> dtoList = new ArrayList<>();
        while (resultSet.next()){
            int id = resultSet.getInt("id");
            int group = resultSet.getInt("group");
            String name = resultSet.getString("name");
            String date = resultSet.getString("date");
            dtoList.add(new StudentDTO(id, name, group,  date));
        }
        return dtoList;
    }

    @Override
    public List<StudentDTO> getAll() throws SQLException {
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from student");

        List<StudentDTO> studentDTOS = getStudentsFromDB(resultSet);
        connection.close();
        return studentDTOS;
    }

    @Override
    public List<StudentDTO> getByName(String studentName) throws SQLException {
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        String SQL = "Select * from student where name = %s";
        ResultSet resultSet = statement.executeQuery(String.format(SQL, studentName));
        List<StudentDTO> studentDTOS = getStudentsFromDB(resultSet);
        connection.close();
        if (studentDTOS.isEmpty()){
            throw new UserNotFoundException(String.valueOf(studentName));
        } else {
        return studentDTOS;
    }
}

    @Override
    public List<StudentDTO> getByIDs(List<Integer> listStudentsIDs) throws SQLException {
        List<StudentDTO> dtoList = new ArrayList<>();
        List<StudentDTO> studentsDTOList = getAll();
        StringBuilder stringBuilder = new StringBuilder();

        for (Integer id : listStudentsIDs) {
            for (StudentDTO studentDTO : studentsDTOList) {
                if (id == studentDTO.getId()) {
                    dtoList.add(studentDTO);
                } else {
                    stringBuilder.append(id).append(" ");
                }
            }
        }
        if (dtoList.isEmpty()) {
            throw new UserNotFoundException(stringBuilder.toString());
        } else {
            return dtoList;
        }
    }
    @Override
    public void updateStudent(StudentDTO studentId) throws SQLException {
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        String SQL = "UPDATE students SET name = '%s', group_id = %s, date = '%s' WHERE id = %s";

        statement.executeUpdate(String.format(
                SQL,
                studentId.getName(),
                studentId.getIdGroup(),
                studentId.getDate(),
                studentId.getId()));

        connection.close();
    }
}
