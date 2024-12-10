package com.app.securityproject.services;

import com.app.securityproject.entities.User;
import com.app.securityproject.repositories.UserRepository;
import com.app.securityproject.security.JwtTokenProvider;
import lombok.RequiredArgsConstructor;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService implements IAuthService {

    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;
    private final PasswordEncoder passwordEncoder;


    @Override
    public void registerUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setEnabled(false); // Par défaut, en attente de validation
        userRepository.save(user);
    }

    @Override
    public String authenticateUser(String email, String password) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Utilisateur non trouvé"));

        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new RuntimeException("Mot de passe incorrect");
        }

        return generateJwtToken(user);
    }

    @Override
    public String generateJwtToken(User user) {
        return jwtTokenProvider.generateToken(user);
    }


}
