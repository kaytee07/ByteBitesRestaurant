package taylor.project.bytebitesrestaurant.security;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import taylor.project.bytebitesrestaurant.enums.UserRole;
import taylor.project.bytebitesrestaurant.model.User;
import taylor.project.bytebitesrestaurant.repository.UserRepository;
import taylor.project.bytebitesrestaurant.util.JwtUtil;

import java.io.IOException;
import java.util.List;
import java.util.Set;

@Component
public class OAuth2SuccessHandler implements AuthenticationSuccessHandler {

    private final JwtUtil jwtUtil;
    private final UserRepository userRepository;

    public OAuth2SuccessHandler(JwtUtil jwtUtil, UserRepository userRepository) {
        this.jwtUtil = jwtUtil;
        this.userRepository = userRepository;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException {
        OAuth2User oAuth2User = (OAuth2User) authentication.getPrincipal();
        String email = oAuth2User.getAttribute("email");
        String name = oAuth2User.getAttribute("name");


        User user = userRepository.findByEmail(email).orElseGet(() -> {
            User newUser = new User();
            newUser.setUsername(name);
            newUser.setEmail(email);
            newUser.setRoles(List.of(UserRole.CUSTOMER));
            return userRepository.save(newUser);
        });

        String jwtToken = jwtUtil.generateToken(user);
        String refreshToken = jwtUtil.generateRefreshToken(user.getUsername());

        // Send tokens as redirect or JSON
        response.sendRedirect("/oauth2/success?token=" + jwtToken + "&refreshToken=" + refreshToken);
    }
}
