package vn.edu.iuh.fit.user.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.edu.iuh.fit.user.models.User;

public interface UserRepository extends JpaRepository<User,Long> {
}
