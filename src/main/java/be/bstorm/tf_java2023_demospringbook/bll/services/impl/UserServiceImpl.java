package be.bstorm.tf_java2023_demospringbook.bll.services.impl;

import be.bstorm.tf_java2023_demospringbook.bll.services.UserService;
import be.bstorm.tf_java2023_demospringbook.dal.repositories.UserRepository;
import be.bstorm.tf_java2023_demospringbook.domain.entities.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User getById(Long id) {
        return userRepository.findById(id).orElseThrow();
    }

    @Override
    public User insert(User user) {
        return userRepository.save( user );
    }

    @Override
    public User update(Long id, User user) {
        User toUpdate = getById( id );
        toUpdate.setPassword( user.getPassword() );
        return userRepository.save( toUpdate );
    }

    @Override
    public void delete(Long id) {
        User toDelete = getById( id );
        userRepository.delete( toDelete );
    }
}
