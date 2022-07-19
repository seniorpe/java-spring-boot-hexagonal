package senior.pe.post.app.application.mappers.impl;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import senior.pe.post.app.application.mappers.UserMapper;
import senior.pe.post.app.domain.dtos.UserDto;
import senior.pe.post.app.domain.entities.User;

@RequiredArgsConstructor
public class UserMapperImpl implements UserMapper {

    @NonNull
    private ModelMapper mapper;

    @Override
    public UserDto userToUserDto(User user) {
        UserDto userDto = mapper.map(user, UserDto.class);

        return userDto;
    }
}
