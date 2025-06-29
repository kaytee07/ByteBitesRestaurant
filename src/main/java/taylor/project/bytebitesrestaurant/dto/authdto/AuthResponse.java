package taylor.project.bytebitesrestaurant.dto.authdto;

public record AuthResponse(
        String accessToken,
        String refreshToken
) {}