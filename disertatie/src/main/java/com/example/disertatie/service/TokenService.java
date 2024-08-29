package com.example.disertatie.service;

import com.example.disertatie.exception.UserNotFoundException;
import com.example.disertatie.model.Token;
import com.example.disertatie.repo.TokenRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TokenService {

    private final TokenRepo tokenRepo;

    @Autowired
    public TokenService(TokenRepo tokenRepo) {
        this.tokenRepo = tokenRepo;
    }

    public Token addToken(Token token){
        //token.setName(UUID.randomUUID().toString());
        return tokenRepo.save(token);
    }

    public List<Token> findAllTokens() {
        return tokenRepo.findAll();
    }

    public Token updateToken(Token token){
        return tokenRepo.save(token);
    }

    public Token findTokenById(Long id){
        return tokenRepo.findTokenById(id)
                .orElseThrow(() -> new UserNotFoundException("Token by id " + id + " was not found"));
    }

    public void deleteToken(Long id){
        tokenRepo.deleteTokenById(id);

    }

}
