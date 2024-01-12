package be.bstorm.tf_java2023_demospringbook.api.controllers;

import be.bstorm.tf_java2023_demospringbook.api.models.dtos.UserDTO;
import be.bstorm.tf_java2023_demospringbook.api.models.forms.UserForm;
import be.bstorm.tf_java2023_demospringbook.bll.services.UserService;
import be.bstorm.tf_java2023_demospringbook.domain.entities.User;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDTO>> getAll(){
        return ResponseEntity.ok(
                userService.getAll().stream()
                        .map( UserDTO::fromEntity )
                        .toList()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getById(@PathVariable Long id){
        return ResponseEntity.ok(
                UserDTO.fromEntity( userService.getById(id) )
        );
    }

    @PostMapping
    public ResponseEntity<UserDTO> create(@RequestBody @Valid UserForm form){
        User toCreate = form.toEntity();
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(
                        UserDTO.fromEntity( userService.insert( toCreate ) )
                );
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> update(@PathVariable Long id, @RequestBody @Valid UserForm form ){
        return ResponseEntity.ok(
                UserDTO.fromEntity( userService.update(id, form.toEntity()) )
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        userService.delete(id);
        return ResponseEntity.ok().build();
    }
}
