package com.example.disertatie.repo;

import com.example.disertatie.model.Token;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TokenRepo extends JpaRepository<Token, Long> {

    @Transactional
    void deleteTokenById(Long id);

    Optional<Token> findTokenById(Long id);

}
