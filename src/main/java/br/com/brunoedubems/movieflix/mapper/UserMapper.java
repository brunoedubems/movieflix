package br.com.brunoedubems.movieflix.mapper;

import br.com.brunoedubems.movieflix.controller.request.UserRequest;
import br.com.brunoedubems.movieflix.controller.response.UserResponse;
import br.com.brunoedubems.movieflix.entity.User;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UserMapper {

    public static User toUser(UserRequest request) {
        return User.builder()
                .email(request.email())
                .name(request.name())
                .password(request.password())
                .build();
    }

    public static UserResponse toUserResponse(User user) {
        return UserResponse.builder()
                .id(user.getId())
                .email(user.getEmail())
                .name(user.getName())
                .build();
    }
}
