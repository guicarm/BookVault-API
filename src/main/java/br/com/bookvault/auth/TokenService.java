package br.com.bookvault.auth;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import br.com.bookvault.user.User;
import br.com.bookvault.user.UserRepository;

@Service
public class TokenService {

    @Autowired
    UserRepository userRepository;
    
    private Algorithm algorithm;


    public TokenService(UserRepository userRepository, @Value("${jwt.secret}") String secret) {
        this.userRepository = userRepository;
        this.algorithm = Algorithm.HMAC256(secret);
    }


    public Token create(Credentials credentials) {
        var expiresAt = LocalDateTime.now().plusHours(1).toInstant(ZoneOffset.ofHours(-3));
        var token = JWT.create()
                .withSubject(credentials.username())
                .withExpiresAt(expiresAt)
                .sign(algorithm);
        return new Token(token, credentials.username());
    }

    
    public User getUserFromToken(String token) {
        var username = JWT.require(algorithm)
                .build()
                .verify(token)
                .getSubject();

        return userRepository.findByUsername(username).orElseThrow(
                () -> new UsernameNotFoundException("User not found.")
        );
    }
}
