package be.bstorm.tf_java2023_demospringbook.bll.services.impl;

import be.bstorm.tf_java2023_demospringbook.bll.services.ReviewService;
import be.bstorm.tf_java2023_demospringbook.dal.repositories.BookRepository;
import be.bstorm.tf_java2023_demospringbook.dal.repositories.ReviewRepository;
import be.bstorm.tf_java2023_demospringbook.dal.repositories.UserRepository;
import be.bstorm.tf_java2023_demospringbook.domain.entities.Book;
import be.bstorm.tf_java2023_demospringbook.domain.entities.Review;
import be.bstorm.tf_java2023_demospringbook.domain.entities.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;
    private final BookRepository bookRepository;
    private final UserRepository userRepository;

    @Override
    public List<Review> getAll() {
        return reviewRepository.findAll();
    }

    @Override
    public Review getById(Long id) {
        return reviewRepository.findById(id).orElseThrow();
    }

    @Override
    public Review insert(Review entity) {
        User user = userRepository.findById( entity.getWrittenBy().getId() ).orElseThrow();
        Book book = bookRepository.findById( entity.getBook().getId() ).orElseThrow();

        entity.setWrittenBy(user);
        entity.setBook(book);

        return reviewRepository.save( entity );
    }

    @Override
    public Review update(Long id, Review entity) {
        Review toUpdate = getById( id );

        toUpdate.setRating( entity.getRating() );
        toUpdate.setComment( entity.getComment() );
        Book book = bookRepository.findById( entity.getBook().getId() ).orElseThrow();
        toUpdate.setBook( book );
        User user = userRepository.findById( entity.getWrittenBy().getId() ).orElseThrow();
        toUpdate.setWrittenBy( user );

        return reviewRepository.save( toUpdate );
    }

    @Override
    public void delete(Long id) {
        Review toDelete = getById(id);
        reviewRepository.delete(toDelete);
    }
}
