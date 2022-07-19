package senior.pe.post.app.domain.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserDto implements Serializable {

    private UUID id;

    private String firstName;

    private String lastName;

    private String fullName;

    private String email;

    private String gender;

    private String ipAddress;
}
