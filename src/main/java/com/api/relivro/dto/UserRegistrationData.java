package com.api.relivro.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record UserRegistrationData(
        @NotBlank(message = "O campo de nome não pode estar vazio!")
        @Size(min = 5, message = "O nome precisa estar completo!")
        String name,
        @NotBlank(message = "O campo de username não pode estar vazio!")
        @Size(min = 3, message = "O nome de usuário precisa ter no mínimo 3 caracteres!")
        String username,
        @NotBlank(message = "O campo de email não pode estar vazio!")
        @Email(message = "O email precisa ter um formato válido!")
        String email,
        @NotBlank(message = "O campo de senha não pode estar vazio!")
        @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,16}$", message = "A senha deve ter entre 8 e 16 caracteres, incluindo pelo menos uma letra maiúscula, uma letra minúscula, um número e um caractere especial")
        String password,
        @NotBlank(message = "O campo de cidade não pode estar vazio!")
        String city,
        @NotBlank(message = "O campo de estado não pode estar vazio!")
        String state,
        @NotNull(message = "O campo data de nascimento não pode estar vazio!")
        @Pattern(regexp = "^\\d{4}-\\d{2}$", message = "A data deve estar no formato YYYY-MM")
        String birthdate
) {
}
