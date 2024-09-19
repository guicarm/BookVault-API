package br.com.bookvault.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    
    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    // Permite a busca de usuários por nome
    public List<User> findByUsername(String username){
        return userRepository.findByUsernameContainingIgnoreCase(username);
    }

    // Ao criar um usuário, encripta a senha do mesmo
    public User create(User user){
        user.setPassword(
            passwordEncoder.encode(user.getPassword())
    );
        return userRepository.save(user);
    }
}
