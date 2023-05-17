package com.iftm.subscription.services;

import com.iftm.subscription.controllers.UserController;
import com.iftm.subscription.data.vo.UserVO;
import com.iftm.subscription.exceptions.RequiredObjectIsNullException;
import com.iftm.subscription.exceptions.ResourceNotFoundException;
import com.iftm.subscription.mapper.DozerMapper;
import com.iftm.subscription.models.User;
import com.iftm.subscription.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.stereotype.Service;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<UserVO> findAll() {
        var userDbList = repository.findAll();
        var users = DozerMapper.parseListObject(userDbList, UserVO.class);
        users.stream().forEach(user -> {
            try {
                user.add(linkTo(methodOn(UserController.class).findById(user.getId()))
                        .withSelfRel()
                );
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        });
        return users;
    }

    public UserVO findById(Long id) throws Exception {
        var userDb = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records for this ID."));
        var user = DozerMapper.parseObject(userDb, UserVO.class);
        user.add(linkTo(methodOn(UserController.class).findById(id)).withSelfRel());
        //user.add(linkTo(methodOn(UserController.class).update(user)).withSelfRel());
        //user.add(linkTo(methodOn(UserController.class).delete(id)).withSelfRel());
        return user;
    }

    public List<UserVO> findByGroupName(String groupName) {
        List<User> users = repository.findUsersByGroupName(groupName);
        var usersVO = DozerMapper.parseListObject(users, UserVO.class);
        usersVO.stream().forEach(user -> {
            try {
                user.add(linkTo(methodOn(UserController.class).findById(user.getId()))
                        .withSelfRel()
                );
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        return usersVO;
    }

    public UserVO save(UserVO userVO) throws Exception{
        if(userVO == null) throw new RequiredObjectIsNullException();

        User user = DozerMapper.parseObject(userVO, User.class);
        var userDb = repository.save(user);
        userVO = DozerMapper.parseObject(userDb, UserVO.class);
        userVO.add(linkTo(methodOn(UserController.class).findById(userVO.getId())).withSelfRel());
        return userVO;
    }

    public UserVO update(UserVO userVO) throws Exception {
        if(userVO == null) throw new RequiredObjectIsNullException();

        var dbUser = repository.findById(userVO.getId()).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID."));
        User user = DozerMapper.parseObject(userVO, User.class);
        user = repository.save(user);
        userVO = DozerMapper.parseObject(user, UserVO.class);
        userVO.add(linkTo(methodOn(UserController.class).findById(userVO.getId())).withSelfRel());
        return userVO;
    }

    public String delete(Long id) {
        var dbUser = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID."));
        repository.deleteById(id);
        return "User with id " + id + " has been deleted!";
    }
}
