package first.spring.students.services.studentServiceImplemented;

import first.spring.students.models.Student;
import first.spring.students.repository.InMemoryStudentsDAO;
import first.spring.students.services.IStudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
// А внедрения конструктором поля inMemoryStudentDAO используем @AllArgsConstructor,
// т.е Spring будет передавать в конструктор StudentService экземпляр класса
// InMemoryStudentsDAO автоматически.
@AllArgsConstructor
public class StudentService implements IStudentService {
    private final InMemoryStudentsDAO repository;

    @Override
    public List<Student> findAllStudents() {
        return repository.findAllStudents();
    }

    @Override
    public Student createStudent(Student student) {
        return repository.createStudent(student);
    }

    @Override
    public Student findStudentByMail(String mail) {
        return repository.findStudentByMail(mail);
    }

    @Override
    public Student updateStudent(Student student) {
        return repository.updateStudent(student);
    }

    @Override
    public void deleteStudentByMail(String mail) {
        repository.deleteStudentByMail(mail);
    }
}
