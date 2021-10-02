package controller;

import business.UserService;
import data.dtos.UserDto;
import data.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public User postUser(@RequestBody UserDto userDto){
        return userService.save((userDto));
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id){
        return userService.findOneById(id);
    }
}
