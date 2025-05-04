package com.example.Microservice1Demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }

   @GetMapping
   public List<User> getAllUsers() {
       return userRepository.findAll();
   }

    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {
        return userRepository.findById(id).orElseThrow();
    }

    @PutMapping("/{id}")
    public User users(@PathVariable Long id, @RequestBody User details) {
        User temp = userRepository.findById(id)
                .orElseThrow();
        temp.setName(details.getName());
        temp.setEmail(details.getEmail());
        return userRepository.save(temp);
    }
}
