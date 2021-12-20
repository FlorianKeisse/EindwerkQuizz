package com.keisse.eindwerkquiz.services;

import com.keisse.eindwerkquiz.models.User;
import com.keisse.eindwerkquiz.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public void saveUser(User user) {
    userRepository.save(user);
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
    userRepository.deleteById(id);
    }

    public User getUserByUserNameAndPassword(String userName,String passWord){
        return userRepository.findUserByUserNameAndPassword(userName,passWord);
    }

//    @Override
//    public User getTempUser(String userName) {
//        return userRepository.tempUserName(userName);
//    }
}
