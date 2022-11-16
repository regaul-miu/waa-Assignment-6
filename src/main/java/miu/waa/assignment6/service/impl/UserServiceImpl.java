package miu.waa.assignment6.service.impl;

import miu.waa.assignment6.domain.Post;
import miu.waa.assignment6.domain.User;
import miu.waa.assignment6.domain.dto.PostDto;
import miu.waa.assignment6.domain.dto.UserDto;
import miu.waa.assignment6.repo.UserRepo;
import miu.waa.assignment6.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<UserDto> getUsers() {
        List<User> users = userRepo.findAll();
        return users.stream()
                .map(u -> modelMapper.map(u, UserDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public UserDto getUserById(long id) {
        return modelMapper.map(userRepo.findById(id),UserDto.class);
    }

    @Override
    public void save(UserDto userDto) {
        User user = modelMapper.map(userDto, User.class);
        userRepo.save(user);
    }


    @Override
    public void deleteById(long userId) {
        userRepo.deleteById(userId);
    }

    @Override
    public List<UserDto> getUsersWithMoreThanNum(int num) {
        List<User> users = userRepo.getUsersWithMoreThanNum(num);
        return users.stream().map(u -> modelMapper.map(u, UserDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<PostDto> getAllPostByUserId(long userId) {
        List<Post> posts = userRepo.getAllPostByUserId(userId);
        return posts.stream().map(p -> modelMapper.map(p, PostDto.class)).collect(Collectors.toList());
    }
}
