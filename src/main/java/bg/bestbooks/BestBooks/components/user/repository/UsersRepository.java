package bg.bestbooks.BestBooks.components.user.repository;

import bg.bestbooks.BestBooks.components.user.model.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<User, Long> {

  Optional<User> findByUsername(String username);
}
