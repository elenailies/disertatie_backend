package com.example.disertatie.resource;

import com.example.disertatie.model.Token;
import com.example.disertatie.service.TokenService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/token")
public class TokenResource {

    private final TokenService tokenService;

    public TokenResource(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Token>> getAllTokens (){
        List <Token> tokens = tokenService.findAllTokens();
        return new ResponseEntity<>(tokens, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Token> getTokenById (@PathVariable("id") Long id){
        Token token = tokenService.findTokenById(id);
        return new ResponseEntity<>(token, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Token> addToken(@RequestBody Token token){
        Token newToken = tokenService.addToken(token);
        return new ResponseEntity<>(newToken, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Token> updateToken(@RequestBody Token token){
        Token updateToken = tokenService.updateToken(token);
        return new ResponseEntity<>(updateToken, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteToken(@PathVariable("id") Long id){
        tokenService.deleteToken(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
