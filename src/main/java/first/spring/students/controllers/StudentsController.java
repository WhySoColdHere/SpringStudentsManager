package first.spring.students.controllers;

import first.spring.students.models.Student;
import first.spring.students.services.IStudentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
// Благодаря этой аннотации из lombok, экземпляр класса studentService создает именно Spring, а не мы.
// Считай, кастомный DI. По факту, это CI - constructor injection (Внедрение через конструктор).
@AllArgsConstructor
public class StudentsController {
    private final IStudentService studentService;

    @GetMapping
    public List<Student> findAllStudents() {
        return studentService.findAllStudents();
    }

    @GetMapping("/get_student/{mail}")
    public Student findStudentByMail(@PathVariable String mail) {
        return studentService.findStudentByMail(mail);
    }
    
    @PostMapping("/create")
    // @RequestBody необходим для сериализации передаваемых объектов (типа преобразует body (header) в json).
    // Правда я хз нафига нам это здесь...
    public String createStudent(@RequestBody Student student) {
        studentService.createStudent(student);
        return "Student successfully created";
    }

    @PutMapping("/update")
    public String updateStudent(@RequestBody Student student) {
        studentService.updateStudent(student);
        return "Student info successfully updated";
    }

    @DeleteMapping("/del_student/{mail}")
    public String deleteStudent(@PathVariable String mail) {
        studentService.deleteStudentByMail(mail);
        return "Student successfully deleted";
    }
}
