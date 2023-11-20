package com.example.resource.Controller;

import com.example.resource.Model.Login;
import com.example.resource.Repository.LoginRepository;
import com.example.resource.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {
        super();
        this.loginService = loginService;
    }


    @PostMapping
    public ResponseEntity<Login> saveLogin(@RequestBody Login login){
        return new ResponseEntity<Login>(loginService.saveLogin(login), HttpStatus.CREATED);
    }

    @GetMapping
    public List<Login> getAllLoginDetails(){
        return loginService.getAllLoginDetails();
    }

    @GetMapping("{id}")
    public ResponseEntity<Login> getLoginDetailsById(@PathVariable("id") long loginId){
        return new ResponseEntity<Login>(loginService.getLoginDetailsById(loginId), HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Login>updateLoginDetails(@PathVariable("id") long id
            ,@RequestBody Login login){
        return new ResponseEntity<Login>(loginService.updateLoginDetails(login, id), HttpStatus.OK);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteLoginDetails(@PathVariable("id") long id){
        loginService.deleteLoginDetails(id);
        return new ResponseEntity<>("Login Details Deleted Successfully", HttpStatus.OK);
    }
}
