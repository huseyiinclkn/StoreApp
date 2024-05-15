package com.example.storeapp.business.concretes;

import com.example.storeapp.business.abstracts.UserService;
import com.example.storeapp.core.dataAccess.UserRepository;
import com.example.storeapp.core.entities.User;
import com.example.storeapp.core.utilities.results.DataResult;
import com.example.storeapp.core.utilities.results.Result;
import com.example.storeapp.core.utilities.results.SuccessDataResult;
import com.example.storeapp.core.utilities.results.SuccessResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserManager implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserManager(UserRepository userRepository) {

        this.userRepository = userRepository;
    }

    @Override
    public Result add(User user) {
        userRepository.save(user);
        return new SuccessResult("Kullanıcı eklendi.");
    }

    @Override
    public DataResult<User> getByEmail(String email) {
        return new SuccessDataResult<User>
        (this.userRepository.getByEmail(email),"Kullanıcı bulundu");
    }
}
