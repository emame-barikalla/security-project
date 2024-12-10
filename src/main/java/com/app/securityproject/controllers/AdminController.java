package com.app.securityproject.controllers;

import com.app.securityproject.services.AdminService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
public class AdminController {
    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    /**
     * Approve a user by their ID.
     *
     * @param userId the ID of the user to approve
     * @return a success message
     */
    @PostMapping("/approve/{userId}")
    public ResponseEntity<String> approveUser(@PathVariable Long userId) {
        adminService.approveUser(userId);
        return ResponseEntity.ok("User approved successfully.");
    }

    /**
     * Reject and delete a user by their ID.
     *
     * @param userId the ID of the user to reject
     * @return a success message
     */
    @DeleteMapping("/reject/{userId}")
    public ResponseEntity<String> rejectUser(@PathVariable Long userId) {
        adminService.rejectUser(userId);
        return ResponseEntity.ok("User rejected and deleted successfully.");
    }
}