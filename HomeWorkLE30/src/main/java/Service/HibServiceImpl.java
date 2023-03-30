package Service;

import Exception.NotFoundStudent;
import Fields.Qgroup;
import Fields.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.Arrays;
import java.util.List;

public class HibServiceImpl implements HibService {
    private final SessionFactory sessionFactory = HUtil.getSessionFactory();
    @Override
    public void addStudent(String stName, String groupName) {
        Session session = (Session) sessionFactory.openSession();
        session.getTransaction().begin();
        Qgroup group = (Qgroup) session.createQuery("groupName").setParameter("groupName", groupName)
                .uniqueResult();
        if (group == null) {
            group = new Qgroup(groupName);
        }
        Student students = new Student(stName, groupName);
        session.save(group);
        session.save(students);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<Student> getAll() {
        org.hibernate.Session session = sessionFactory.openSession();
        List listSt = session.createQuery("student").list();
        session.close();
        System.out.println(Arrays.toString(listSt.toArray()));
        return listSt;
    }

    @Override
    public List<Student> studentsName(String name) {
        org.hibernate.Session session = sessionFactory.openSession();

        List listSt = session
                .createQuery("from Student where STUDENT_NAME = :studentName")
                .setParameter("studentName", name)
                .list();
        session.close();

        System.out.println(Arrays.toString(listSt.toArray()));
        return listSt;
    }

    @Override
    public Student studentId(int id) {
        org.hibernate.Session session = sessionFactory.openSession();

        Student student = (Student) session
                .createQuery("from Student where STUDENT_ID = :studentId")
                .setParameter("studentId", id)
                .uniqueResult();
        session.close();

        if (student == null) {
            throw new NotFoundStudent();
        }

        System.out.println(student);
        return student;
    }
}
