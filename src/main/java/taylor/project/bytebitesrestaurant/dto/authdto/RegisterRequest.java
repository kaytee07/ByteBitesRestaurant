package taylor.project.bytebitesrestaurant.dto.authdto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import taylor.project.bytebitesrestaurant.enums.UserRole;

public record RegisterRequest(
        @NotBlank String username,
        @NotBlank String password,
        @NotBlank String email,
        @NotNull UserRole role
) {}
