package com.iba.auth;

import com.iba.Config.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@CrossOrigin(origins = "http://localhost:3000")
@RequiredArgsConstructor
public class AuthenticationController {
    @Autowired
    private final AuthenticationService authenticationService;
    @Autowired
    private JwtService jwtService;


    @PostMapping("/valide")
    public ResponseEntity<?> validateToken(@RequestBody authenticationRequest req){
        try{
            boolean isvalid =  jwtService.isTokenNotExpired(req.getEmail());
            return ResponseEntity.ok(!isvalid);
        }catch (Exception e){
            return ResponseEntity.ok(false);
        }
    }


    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody registerRequest request) throws Exception {
        try{
            AuthenticationResponse register = authenticationService.register(request);
            return ResponseEntity.ok(register);
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }

    }

    @PostMapping("/authenticate")
    public ResponseEntity<?> authenticate(@RequestBody authenticationRequest request){
        try {
            if(request.getEmail().isBlank() || request.getPassword().isBlank()) {
                throw new BadCredentialsException("Please Enter All Fields");
            }
            AuthenticationResponse response = authenticationService.authenticate(request);
            return ResponseEntity.ok(response);
        }catch (BadCredentialsException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
    }

/*
    @GetMapping(path = "/confirm")
    public String confirm(@RequestParam("token") String token) {
        return authenticationService.confirmToken(token);
    }*/



}
