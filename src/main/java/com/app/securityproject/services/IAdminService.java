package com.app.securityproject.services;

public interface IAdminService {
    void approveUser(Long userId);
    void rejectUser(Long userId);
}
