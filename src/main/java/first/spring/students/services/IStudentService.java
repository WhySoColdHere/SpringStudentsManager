package first.spring.students.services;

import first.spring.students.models.Student;
import java.util.List;

public interface IStudentService {
    List<Student> findAllStudents();
    Student createStudent(Student student);
    Student findStudentByMail(String mail);
    Student updateStudent(Student student);
    void deleteStudentByMail(String mail);
}
