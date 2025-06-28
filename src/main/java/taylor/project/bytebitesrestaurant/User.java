package taylor.project.bytebitesrestaurant;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue
    private UUID uuid;

    @NotBlank(message = "Username cannot be blank")
    private String username;

    @NotBlank(message = "Password cannot be blank")
    @Column(columnDefinition = "TEXT")
    private String password;

    @NotBlank(message = "Email cannot be blank")
    @Email
    private String email;

    @Enumerated(EnumType.STRING)
    private UserRole Role;
}
