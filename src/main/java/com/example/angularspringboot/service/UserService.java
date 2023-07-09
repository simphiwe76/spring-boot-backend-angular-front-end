package com.example.angularspringboot.service;

import com.example.angularspringboot.model.User;
import com.example.angularspringboot.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private  final UserRepository userRepository;

    public User createUser(User user){
        return userRepository.save(user);
    }

    public List<User> getAllUsers(){
      return userRepository.findAll();
    }

    public User getUserById(Long id){
        return  userRepository.findById(id).orElseThrow();
    }

    public  User updateUser(Long id,User user){

        User saved = userRepository.findById(id).orElseThrow();
        if (userRepository.findById(id).isPresent()){
            saved = userRepository.save(user);
            return saved;
        }
        return  saved;
    }

    public List<User> deleteUser(Long id){
        userRepository.deleteById(id);
        return userRepository.findAll();
    }
}
