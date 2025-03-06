package com.insurance.controller;

import com.insurance.config.JwtUtil;
import com.insurance.model.AuthenticationRequest;
import com.insurance.model.AuthenticationResponse;
import com.insurance.model.User;
import com.insurance.model.Vehicle;
import com.insurance.repository.UserRepository;
import com.insurance.service.UserService;
import com.insurance.service.VehicleService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;


@RestController
@RequestMapping("/api/auth")

public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Autowired
    private VehicleService vehicleService;

    
    


    @PostMapping("/register")
    public String registerUser(@RequestBody User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return "User registered successfully";
    }

//    @PostMapping("/login")
//    public AuthenticationResponse login(@RequestBody AuthenticationRequest authRequest) {
//        try {
//            authenticationManager.authenticate(
//                    new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
//            );
//
//            final UserDetails userDetails = userService.loadUserByUsername(authRequest.getUsername());
//            final String jwt = jwtUtil.generateToken(userDetails);
//
//            System.out.println("✅ User Logged In: " + authRequest.getUsername());
//           // System.out.println("✅ User Logged In: " + authRequest.getUsername());
//
//            return new AuthenticationResponse(jwt);
//
//        } catch (UsernameNotFoundException e) {
//            System.out.println("❌ User Not Found: " + authRequest.getUsername());
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found", e);
//        } catch (Exception e) {
//            System.out.println("❌ Invalid Credentials for user: " + authRequest.getUsername());
//            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid credentials", e);
//        }
//    }

    @PostMapping("/login")
    public AuthenticationResponse login(@RequestBody AuthenticationRequest authRequest) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
            );

            // Fetch user from database to get ID along with username
            User user = userRepository.findByUsername(authRequest.getUsername())
                    .orElseThrow(() -> new UsernameNotFoundException("User not found: " + authRequest.getUsername()));

            final UserDetails userDetails = userService.loadUserByUsername(authRequest.getUsername());
            final String jwt = jwtUtil.generateToken(userDetails);

            // Print user ID and username
            System.out.println("✅ User Logged In: ID = " + user.getId() + ", Username = " + user.getUsername());

            return new AuthenticationResponse(jwt);

        } catch (UsernameNotFoundException e) {
            System.out.println("❌ User Not Found: " + authRequest.getUsername());
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found", e);
        } catch (Exception e) {
            System.out.println("❌ Invalid Credentials for user: " + authRequest.getUsername());
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid credentials", e);
        }
    }

}
