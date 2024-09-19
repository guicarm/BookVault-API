package br.com.bookvault.user.dto;

import br.com.bookvault.user.User;

public record UserResponse (
        Long id,
        String username,
        String password,
        String email
) {
    public static UserResponse from(User user) {
        return new UserResponse(
                user.getId(),
                user.getUsername(),
                user.getPassword(),
                user.getEmail()
        );
    }
}
