package com.example.storeapp.business.abstracts;

import com.example.storeapp.core.entities.User;
import com.example.storeapp.core.utilities.results.DataResult;
import com.example.storeapp.core.utilities.results.Result;

public interface UserService {
    Result add(User user);
    DataResult<User> getByEmail(String email);
}
