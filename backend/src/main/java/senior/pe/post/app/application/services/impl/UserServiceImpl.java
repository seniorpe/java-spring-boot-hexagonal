package senior.pe.post.app.application.services.impl;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import senior.pe.post.app.application.services.UserService;
import senior.pe.post.app.domain.entities.User;
import senior.pe.post.app.domain.repositories.UserRepository;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    @NonNull
    private UserRepository userRepository;

    @Override
    public Page<User> findAll(int page, int size, String sort) {
        PageRequest pr = PageRequest.of(page,size, Sort.by(sort));

        return userRepository.findAll(pr);
    }
}
