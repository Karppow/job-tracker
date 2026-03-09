package com.karppow.job_tracker.mapper;

import com.karppow.job_tracker.dto.UserResponse;
import com.karppow.job_tracker.entity.User;

public class UserMapper {

    public static UserResponse toResponse(User user) {
        return new UserResponse(
                user.getId(),
                user.getEmail()
        );
    }
}
