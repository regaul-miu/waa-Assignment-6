package miu.waa.assignment6.controller;

import miu.waa.assignment6.aspect.annotation.ExecutionTime;
import miu.waa.assignment6.domain.dto.PostDto;
import miu.waa.assignment6.domain.dto.UserDto;
import miu.waa.assignment6.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users/")
public class UserController {
    @Autowired
    private UserService userService;


    @GetMapping
    public List<UserDto> getUsers(){
        return userService.getUsers();
    }
    @ExecutionTime
    @GetMapping("{id}")
    public UserDto getUserById(@PathVariable("id") long id){
        return userService.getUserById(id);
    }
    @PostMapping
    public void save(@RequestBody UserDto userDto){
        userService.save(userDto);
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable("id") long userId){
        userService.deleteById(userId);
    }

    @GetMapping("{id}/posts")
    public List<PostDto> getAllPostByUserId(@PathVariable("id") long userId){
        return userService.getAllPostByUserId(userId);
    }

    @GetMapping("postsMoreThan/{num}")
    public List<UserDto> getUsersWithMoreThanNum(@PathVariable("num") int num){
        return userService.getUsersWithMoreThanNum(num);
    }
}
