package guru.springframework.blog.controllers;

import guru.springframework.blog.domain.User;
import guru.springframework.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")

public class UserController {
        @Autowired
        private UserService userService;


       @RequestMapping(value = "/list", method= RequestMethod.GET)
        public Iterable list(Model model){
            Iterable userList = userService.listAllUsers();
            return userList;
        }

        @RequestMapping(value = "/show/{id}", method= RequestMethod.GET)
        public User getUser(@PathVariable Integer id){
            User user = userService.getUserById(id);
            return user;
        }


        @RequestMapping(value = "/add", method = RequestMethod.POST)
        public ResponseEntity saveUser(@RequestBody User user){
            userService.saveUser(user);
            return new ResponseEntity("User saved successfully", HttpStatus.OK);
        }


    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity updateUser(@PathVariable Integer id, @RequestBody User user){
        User storedUser = userService.getUserById(id);
        storedUser.setName(user.getName());
        storedUser.setAge(user.getAge());
        userService.saveUser(storedUser);
        return new ResponseEntity("User updated successfully", HttpStatus.OK);
    }


        @RequestMapping(value="/delete/{id}", method = RequestMethod.DELETE)
        public ResponseEntity delete(@PathVariable Integer id){
            userService.deleteUser(id);
            return new ResponseEntity("User deleted successfully", HttpStatus.OK);

        }

    }

