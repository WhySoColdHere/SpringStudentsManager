package first.spring.students.services.studentServiceImplemented;

import first.spring.students.models.Student;
import first.spring.students.repository.IStudentRepository;
import first.spring.students.services.IStudentService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
@Primary
public class StudentServiceImp implements IStudentService {
    private final IStudentRepository repository;

    @Override
    public List<Student> findAllStudents() {
        return repository.findAll();
    }

    @Override
    public Student createStudent(Student student) {
        return repository.save(student);
    }

    @Override
    public Student findStudentByMail(String mail) {
        return repository.findStudentByMail(mail);
    }

    @Override
    public Student updateStudent(Student student) {
        return repository.save(student);
    }

    @Override
    @Transactional
    public void deleteStudentByMail(String mail) {
        repository.deleteStudentByMail(mail);
    }
}
