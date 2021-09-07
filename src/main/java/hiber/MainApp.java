package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context =
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

       Car car1 = new Car("BMW", 3);
       User user1 = new User("User1", "Vasilev", "user1@mail.ru", car1);

       userService.add(user1);


       Car car2 = new Car("Mazerati", 555);
       User user2 = new User("User2", "Ivanov", "user2@mail.ru", car2);
       userService.add(user2);

       Car car3 = new Car("Bugatti", 999);
       User user3 = new User("User3", "Sidorov", "user3@mail.ru", car3);
       userService.add(user3);

       Car car4 = new Car("Lamborgini", 666);
       User user4 = new User("User4", "Petrov", "user4@mail.ru", car4);
       userService.add(user4);

//      List<User> users = userService.listUsers();
//      for (User user : users) {
//         System.out.println("Id = "+user.getId());
//         System.out.println("First Name = "+user.getFirstName());
//         System.out.println("Last Name = "+user.getLastName());
//         System.out.println("Email = "+user.getEmail());
//         System.out.println("Car = "+user.getCar().getId());
//         System.out.println();
//      }

      System.out.println(userService.getUserByModelAndSeries("BMW", 3).getLastName());

      context.close();
   }
}
