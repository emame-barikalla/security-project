package com.app.securityproject.services;

import com.app.securityproject.entities.User;

public interface IAuthService {
    void registerUser(User user);
    String authenticateUser(String email, String password);
    String generateJwtToken(User user);
}
