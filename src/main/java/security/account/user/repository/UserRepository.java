package security.account.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import security.account.user.domain.User;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    // 이메일과 이름으로 찾기
    Optional<User> findByEmail(String email);

    Optional<User> findByUsername(String username);



}
