package be.bstorm.tf_java2023_demospringbook.api.models.dtos;

import be.bstorm.tf_java2023_demospringbook.domain.entities.User;

public record UserDTO(
        Long id,
        String username
) {

    public static UserDTO fromEntity(User user){

        if( user == null )
            return null;

        return new UserDTO(
                user.getId(),
                user.getUsername()
        );

    }

}
