package vn.edu.iuh.fit.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import vn.edu.iuh.fit.user.models.User;
import vn.edu.iuh.fit.user.repositories.UserRepository;

@SpringBootApplication
public class UserApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
    }

    @Autowired
    private UserRepository userRepository;
    //@Bean
    CommandLineRunner commandLineRunner() {
        return args -> {
            for (int i = 0; i < 5; i++) {
                User user = new User("name #" + i);
                userRepository.save(user);
            }
        };
    }
}
