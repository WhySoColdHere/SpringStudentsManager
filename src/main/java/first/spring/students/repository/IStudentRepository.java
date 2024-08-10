package first.spring.students.repository;

import first.spring.students.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IStudentRepository extends JpaRepository<Student, Long> {
    void deleteStudentByMail(String mail);
    Student findStudentByMail(String mail);
}
