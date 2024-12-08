package report_code.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import report_code.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}