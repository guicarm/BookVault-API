package br.com.bookvault.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.bookvault.user.dto.UserRequest;
import br.com.bookvault.user.dto.UserResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("user")
@Slf4j
@Tag(name = "User")
public class UserController {
    
    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

 // ========== GET(Buscar Usuarios) ============
    @Operation(
        summary = "Get user by username.",
        description = "Retorna um usuário de acordo com seu username."
    )
    @GetMapping
    public List<User> findByUsername(@RequestParam String username){
        return userService.findByUsername(username);
    }

 // ========== POST(Criar Usuarios) ============
 
    @Operation(
            summary = "Create user.",
            description = "Cria um usuário."
        )
    @PostMapping
    public ResponseEntity<UserResponse> create(@RequestBody UserRequest userRequest, UriComponentsBuilder uriBuilder){
        var user = userService.create(userRequest.toModel());

        var uri = uriBuilder
                    .path("/user/{id}")
                    .buildAndExpand(user.getId())
                    .toUri();

        return ResponseEntity
                .created(uri)
                .body(UserResponse.from(user));
    }




}
