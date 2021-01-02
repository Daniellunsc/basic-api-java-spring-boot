package com.api.apiexample.service;

import com.api.apiexample.domain.User;
import com.api.apiexample.dto.UserCreationRequest;
import com.api.apiexample.exceptions.CustomException;
import com.api.apiexample.interfaces.IUserService;
import com.api.apiexample.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User create(UserCreationRequest userCreationRequest) throws Exception {
        User userToSave = this.convert(userCreationRequest);
        if(Objects.nonNull(userRepository.findFirstByName(userToSave.getName()))) {
            throw new CustomException("This name already exists!", "You can't create a user with the same name", "Try another name!");
        }

        return userRepository.save(userToSave);
    }

    @Override
    public User update() {
        return null;
    }

    @Override
    public void delete(String id) {
        Optional<User> user = userRepository.findById(id);
        if(!user.isPresent()) {
            throw new CustomException("You cant delete this user!", "You cant delete a user who doenst exists", "Try a valid user!");
        }

        userRepository.deleteById(id);
    }

    @Override
    public User convert(UserCreationRequest userCreationRequest) {
        return User.builder()
                .id(UUID.randomUUID().toString())
                .name(userCreationRequest.getName())
                .build();
    }
}
