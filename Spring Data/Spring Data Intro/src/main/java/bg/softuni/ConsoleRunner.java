package bg.softuni;

import bg.softuni.services.MajorService;
import bg.softuni.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ConsoleRunner implements CommandLineRunner {

    private final StudentService studentService;

    private final MajorService majorService;

    @Autowired
    public ConsoleRunner(StudentService studentService, MajorService majorService) {
        this.studentService = studentService;
        this.majorService = majorService;
    }

    @Override
    public void run(String... strings) throws Exception {
        this.studentService.register();
        this.majorService.register();

        //       Major major = new Major("Java DB Fundamentals");
        //       entities.Student student = new entities.Student("John",new Date(), major);
        //       majorService.create(major);
        //       studentService.register(student);
    }
}
