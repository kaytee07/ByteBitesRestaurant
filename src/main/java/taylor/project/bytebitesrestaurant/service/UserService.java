package taylor.project.bytebitesrestaurant.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import taylor.project.bytebitesrestaurant.model.User;
import taylor.project.bytebitesrestaurant.repository.UserRepository;



@AllArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    public User createUser(User user){
        return userRepository.save(user);
    }
}

