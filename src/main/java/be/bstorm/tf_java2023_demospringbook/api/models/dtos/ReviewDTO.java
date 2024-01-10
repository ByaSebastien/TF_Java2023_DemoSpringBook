package be.bstorm.tf_java2023_demospringbook.api.models.dtos;

import be.bstorm.tf_java2023_demospringbook.domain.entities.Review;

public record ReviewDTO(
        Long id,
        int rating,
        String comment,
        BookDTO book,
        UserDTO writtenBy
) {

    public static ReviewDTO fromEntity(Review entity) {
        if( entity == null )
            return null;

        return new ReviewDTO(
                entity.getId(),
                entity.getRating(),
                entity.getComment(),
                BookDTO.fromEntity( entity.getBook() ),
                UserDTO.fromEntity( entity.getWrittenBy() )
        );
    }

}
