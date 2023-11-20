package com.example.resource.service;

import com.example.resource.Exception.ResourceNotFoundException;
import com.example.resource.Model.Login;
import com.example.resource.Repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


import java.util.List;
@Component
@Service
public class LoginServicImp implements LoginService{

    @Autowired
    private LoginRepository loginRepository;

    @Autowired
    public LoginServicImp(LoginRepository loginRepository) {
        super();
        this.loginRepository = loginRepository;
    }

    @Override
    public Login saveLogin(Login login) {
        return loginRepository.save(login);
    }

    @Override
    public List<Login> getAllLoginDetails() {
         return loginRepository.findAll();
    }

    @Override
    public Login getLoginDetailsById(long id) {
        return loginRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Login", "Id", id));
    }

    @Override
    public Login updateLoginDetails(Login login, long id) {
        Login existingLogin = loginRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Login", "Id", id));

        existingLogin.setUsername(login.getUsername());
        existingLogin.setPassword(login.getPassword());

        loginRepository.save(existingLogin);
        return existingLogin;
    }

    @Override
    public void deleteLoginDetails(long id) {
        loginRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Login", "Id", id));
        loginRepository.deleteById(id);
    }
}
