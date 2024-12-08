package report_code.config;

import report_code.entity.User;
import report_code.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataLoader {

    @Bean
    public CommandLineRunner loadData(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            User user = new User();
            user.setUsername("user@example.com");
            user.setPassword(passwordEncoder.encode("password"));
            user.setRole("USER");
            user.setUnlocked(true);
            userRepository.save(user);

            User admin = new User();
            admin.setUsername("admin@example.com");
            admin.setPassword(passwordEncoder.encode("adminpassword"));
            admin.setRole("ADMIN");
            admin.setUnlocked(true);
            userRepository.save(admin);
        };
    }
}
