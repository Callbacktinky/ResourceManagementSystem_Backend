package com.example.resource.service;

import com.example.resource.Model.Login;

import java.util.List;

public interface LoginService {

    Login saveLogin(Login login);
    List<Login> getAllLoginDetails();
    Login getLoginDetailsById(long id);
    Login updateLoginDetails(Login login, long id);
    void deleteLoginDetails(long id);
}
