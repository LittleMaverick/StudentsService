package studentsservice;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import studentsservice.entities.StudentEntity;
import studentsservice.entities.UserEntity;
import studentsservice.repository.StudentRepository;
import studentsservice.repository.UserRepository;
import studentsservice.service.UserService;

import java.util.List;


public class Main {

    public static void main(String[] args) {
//        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
//        ctx.load("backend-spring-context.xml"); //move from src.main.java to src.main.resources
//        ctx.refresh();

        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("backend-spring-context.xml");

        UserService service = ctx.getBean("jpaUserService", UserService.class);
        List<UserEntity> entities = service.findAll();
        printAll(entities);

        System.out.println("------------------------------------------");
        System.out.println(service.findById(2));
    }

    private static void printAll(List<UserEntity> contacts) {
        System.out.println("printAll: ");
        for (UserEntity contact : contacts) {
            System.out.println(contact);
        }
    }
}
