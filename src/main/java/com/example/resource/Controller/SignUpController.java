package com.example.resource.Controller;

import com.example.resource.Model.SignUp;
import com.example.resource.service.SignupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/SignUp")
public class SignUpController {
    @Autowired
    private SignupService SignupService;

    @Autowired
    public SignUpController(SignupService SignUpService) {
        super();
        SignupService = SignupService;
    }

    //build create SignUp REST API

    @PostMapping
    public ResponseEntity<SignUp> saveSignUp(@RequestBody SignUp signUp) {
        return new ResponseEntity<>(SignupService.saveSignUp(signUp), HttpStatus.CREATED);

    }


    // build get all SignUP REST API
    @GetMapping("/SignUp")
    public List<SignUp> getAllSignUp() {
        return SignupService.getAllSignUp();

    }


    // build get SignUp by id REST API
    @GetMapping("{id}")
    public ResponseEntity<SignUp> getLoginDetailsById(@PathVariable("id") long signUpId) {
        return new ResponseEntity<SignUp>(SignupService.getSignUpById(signUpId), HttpStatus.OK);
    }

    //build Update signUp REST API

    @PutMapping("{id}")
    public ResponseEntity<SignUp> updateSignUp(@PathVariable("id") long id
            , @RequestBody SignUp signUp) {
        return new ResponseEntity<SignUp>(SignupService.updateSignUp(signUp, id), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteSignUp(@PathVariable("id") long id) {
        SignupService.deleteSignUp(id);
        return new ResponseEntity<>("SignUp Details Deleted Successfully", HttpStatus.OK);


    }
}
