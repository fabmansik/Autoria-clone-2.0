package milansomyk.springboothw.mapper;

import milansomyk.springboothw.dto.UserDto;
import milansomyk.springboothw.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public UserDto toResponseDto(User user){
        return UserDto.builder()
                .id(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .phone(user.getPhone())
                .premium(user.getPremium())
                .enabled(user.isEnabled())
                .role(user.getRole())
                .cars(user.getCars())
                .build();
    }
    public User fromDto(UserDto userDto){
        return new User(userDto.getId(), userDto.getUsername(), userDto.getPassword(), userDto.getEmail(), userDto.getPhone(), userDto.isPremium(), userDto.isEnabled(), userDto.getRole(),userDto.getCars());
    }
}
