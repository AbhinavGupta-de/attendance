package com.scaler.attendance.service;

import com.scaler.attendance.model.User;
import com.scaler.attendance.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // It has no use, we can directly make an object of userRepo and call the method getId()
    public Optional<Integer> getUserId(String email, String password) {
        if(email == null || password == null){
            return Optional.empty();
        }


        if(userRepository.findByEmailAndPassword(email, password).isEmpty()){
            return Optional.empty();
        }

        Optional<User> user = userRepository.findByEmailAndPassword(email, password);

        return Optional.of(user.get().getId());
    }

    // It has no use, we can directly make an object of userRepo and call the method getRole()
    public String getUserRole(Integer id) {
        if(id == null){
            return null;
        }

        Optional<User> user = userRepository.findById(id);

        return user.map(User::getRole).orElse(null);

    }

    public boolean addUser(String name, String email, String password, String role) {
        if(name == null || email == null || password == null || role == null){
            return false;
        }
        try{
            User user = new User();
            user.setName(name);
            user.setEmail(email);
            user.setPassword(password);
            user.setRole(role);
            userRepository.save(user);
            return true;
        }catch (Exception e){
            return false;
        }
    }


    public Optional<User> getUser(String email, String password) {
        if(email == null || password == null){
            return Optional.empty();
        }
        return userRepository.findByEmailAndPassword(email, password);
    }

}
