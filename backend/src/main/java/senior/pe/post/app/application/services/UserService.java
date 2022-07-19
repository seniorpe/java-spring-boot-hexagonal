package senior.pe.post.app.application.services;

import org.springframework.data.domain.Page;
import senior.pe.post.app.domain.entities.User;

public interface UserService {
    Page<User> findAll(int page, int size, String sort);
}
