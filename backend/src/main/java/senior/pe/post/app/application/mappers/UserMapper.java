package senior.pe.post.app.application.mappers;

import senior.pe.post.app.domain.dtos.UserDto;
import senior.pe.post.app.domain.entities.User;

public interface UserMapper {
    UserDto userToUserDto(User user);
}
