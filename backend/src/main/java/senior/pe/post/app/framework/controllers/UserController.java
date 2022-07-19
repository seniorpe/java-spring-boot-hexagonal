package senior.pe.post.app.framework.controllers;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import senior.pe.post.app.application.services.UserService;
import senior.pe.post.app.domain.entities.User;
import senior.pe.post.shared.dto.CustomHttpResponse;

import java.util.List;

import static senior.pe.post.shared.util.BuildResponse.customResponse;

@RequiredArgsConstructor
@RestController
@RequestMapping("users")
public class UserController {
    @NonNull
    private UserService userService;

    @GetMapping
    public ResponseEntity<Page> findAll(
            @RequestParam int page,
            @RequestParam int size,
            @RequestParam String sort) {
        return ResponseEntity.ok(userService.findAll(page, size, sort));
    }
}
