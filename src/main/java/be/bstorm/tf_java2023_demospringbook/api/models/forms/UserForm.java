package be.bstorm.tf_java2023_demospringbook.api.models.forms;

import be.bstorm.tf_java2023_demospringbook.api.validation.constraint.Password;
import be.bstorm.tf_java2023_demospringbook.domain.entities.User;
import jakarta.validation.constraints.NotBlank;

public record UserForm(
        @NotBlank
        String username,
        @Password
        String password
) {
        public User toEntity(){
                User user = new User();
                user.setUsername( username );
                user.setPassword( password );
                return user;
        }
}
