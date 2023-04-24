package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);
      User user1 = new User("User1", "Lastname1", "user1@mail.ru");
      user1.setUserCars(new Car("Model1", "Series1"));
      userService.add(user1);

      User user2 = new User("User2", "Lastname2", "user2@mail.ru");
      user2.setUserCars(new Car("Model2", "Series2"));
      userService.add(user2);

      User user3 = new User("User3", "Lastname3", "user3@mail.ru");
      user3.setUserCars(new Car("Model3", "Series3"));
      userService.add(user3);

      User user4 = new User("User4", "Lastname4", "user4@mail.ru");
      user4.setUserCars(new Car("Model4", "Series4"));
      userService.add(user4);

      System.out.println(userService.getUserByCar("Model3", "Series3"));

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println(user);
      }

      context.close();
   }
}
