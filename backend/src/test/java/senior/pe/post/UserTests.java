package senior.pe.post;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;
import senior.pe.post.app.domain.dtos.UserDto;
import senior.pe.post.app.domain.entities.User;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

//Referencia: https://www.baeldung.com/java-modelmapper
@SpringBootTest
class UserTests {

	private ModelMapper mapper;

	@BeforeEach
	public void setup() {
		this.mapper = new ModelMapper();
	}

	@Test
	public void whenMapUserWithExactMatch_thenConvertsToDTO() {
		UUID uuid = UUID.randomUUID();
		User user = new User(uuid, "firstName", "lastName", "email", "male", "172.0.0.1", null);
		UserDto userDto = this.mapper.map(user, UserDto.class);

		assertEquals(user.getId(), userDto.getId());
	}
}
