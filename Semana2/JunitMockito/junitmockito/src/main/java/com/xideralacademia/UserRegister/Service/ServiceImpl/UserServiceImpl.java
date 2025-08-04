package com.xideralacademia.UserRegister.Service.ServiceImpl;

import org.springframework.stereotype.Service;

import com.xideralacademia.UserRegister.Model.UserEntity;
import com.xideralacademia.UserRegister.Repository.UserRepository;
import com.xideralacademia.UserRegister.Service.UserService;

@Service
public class UserServiceImpl implements UserService {
    UserRepository user;

    UserServiceImpl(UserRepository user) {
        this.user = user;
    }

    @Override
    public UserEntity registrarUsr(UserEntity usr) {
        return user.save(usr);
    }
}
