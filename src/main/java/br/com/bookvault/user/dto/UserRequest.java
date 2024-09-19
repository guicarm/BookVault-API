package br.com.bookvault.user.dto;

import br.com.bookvault.user.User;

public record UserRequest(
        String username,
        String password
) {
    public User toModel() {
        return User.builder()
                .username(username)
                .password(password)
                .build();
    }
}
