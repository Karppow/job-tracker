package com.karppow.job_tracker.controller;


import com.karppow.job_tracker.dto.RegisterRequest;
import com.karppow.job_tracker.dto.UserResponse;
import com.karppow.job_tracker.entity.User;
import com.karppow.job_tracker.mapper.UserMapper;
import com.karppow.job_tracker.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public UserResponse register(@RequestBody RegisterRequest request) {

        User user = userService.register(request);

        return UserMapper.toResponse(user);
    }
}
