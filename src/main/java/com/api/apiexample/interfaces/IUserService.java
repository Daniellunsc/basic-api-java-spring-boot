package com.api.apiexample.interfaces;

import com.api.apiexample.domain.User;
import com.api.apiexample.dto.UserCreationRequest;

import java.util.List;

public interface IUserService {
    public List<User> getAll();
    public User create(UserCreationRequest userCreationRequest) throws Exception;
    public User update();
    public void delete(String id);
    public User convert(UserCreationRequest userCreationRequest);
}
