package taylor.project.bytebitesrestaurant.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import taylor.project.bytebitesrestaurant.enums.AuthProvider;
import taylor.project.bytebitesrestaurant.enums.UserRole;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users") // or "app_user"
public class User {
    @Id
    @GeneratedValue
    private UUID uuid;

    @NotBlank(message = "Username cannot be blank")
    private String username;


    @Column(columnDefinition = "TEXT")
    private String password;


    @Email
    @Column(unique = true)
    private String email;

    @Enumerated(EnumType.STRING)
    private AuthProvider provider;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<UserRole> roles = new ArrayList<>();


}
