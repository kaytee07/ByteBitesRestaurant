package taylor.project.bytebitesrestaurant;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

interface userRepository extends JpaRepository<User, UUID> {
}
