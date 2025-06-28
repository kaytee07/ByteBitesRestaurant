package taylor.project.bytebitesrestaurant;

import lombok.AllArgsConstructor;
import org.jvnet.hk2.annotations.Service;

@Service
@AllArgsConstructor
public class UserService {
    private final userRepository userRepository;

    public User createUser(User user){
        return userRepository.save(user);
    }
}
