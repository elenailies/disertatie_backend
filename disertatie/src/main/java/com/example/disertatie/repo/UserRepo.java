package com.example.disertatie.repo;
import com.example.disertatie.model.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long> {

    @Transactional
    void deleteUserById(Long id);

    Optional<User> findUserById(Long id);

}
