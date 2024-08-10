package first.spring.students.repository;

import first.spring.students.models.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Repository
public class InMemoryStudentsDAO {
    private final List<Student> STUDENTS = new ArrayList<>();

    public List<Student> findAllStudents() {
        return STUDENTS;
    }

    public Student createStudent(Student student) {
        STUDENTS.add(student);
        return student;
    }

    public Student findStudentByMail(String mail) {
        return STUDENTS.stream().filter(student -> student.getMail()
                .equals(mail))
                .findFirst()
                .orElse(null);
    }

    public Student updateStudent(Student student) {
        var studentIndex = IntStream.range(0, STUDENTS.size())
                .filter(index -> STUDENTS.get(index).getMail().equals(student.getMail()))
                .findFirst()
                .orElse(-1);

        if (studentIndex > -1) {
            STUDENTS.set(studentIndex, student);
            return student;
        }

        return null;
    }

    public void deleteStudentByMail(String mail) {
        var student = findStudentByMail(mail);
        if (student != null) {
            STUDENTS.remove(student);
        }
    }

}
