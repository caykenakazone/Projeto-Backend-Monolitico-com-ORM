package com.iftm.exercicio02.services;

import com.iftm.exercicio02.data.vo.UserVO;
import com.iftm.exercicio02.mapper.DozerMapper;
import com.iftm.exercicio02.models.User;
import com.iftm.exercicio02.models.Group;
import com.iftm.exercicio02.repositories.EmailRepository;
import com.iftm.exercicio02.repositories.GroupRepository;
import com.iftm.exercicio02.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EmailRepository emailRepository;

    @Autowired
    private GroupRepository groupRepository;

    public List<UserVO> findAll() {
        var users = userRepository.findAll();
        var usersVO = DozerMapper.parseListObject(users, UserVO.class);
        return usersVO;
    }

    public UserVO findById(Long id) {
        return DozerMapper.parseObject(userRepository.findById(id).orElse(null), UserVO.class);
    }

    public UserVO save(UserVO userVO) {
        if (verifyUser(userVO)) {
            var user = DozerMapper.parseObject(userVO, User.class);

            // Adicionar emails ao usuário
            if (userVO.getEmailIds() != null) {
                var emails = emailRepository.findAllById(userVO.getEmailIds());
                user.setEmails(emails);
            }

            // Adicionar grupos ao usuário
            if (userVO.getGroupIds() != null) {
                var groups = groupRepository.findAllById(userVO.getGroupIds());
                user.setGroups(groups);
            }

            user = userRepository.save(user);
            return DozerMapper.parseObject(user, UserVO.class);
        }
        return null;
    }

    public UserVO update(UserVO userVO) {
        var dbUser = userRepository.findById(userVO.getId());
        if (dbUser.isPresent() && verifyUser(userVO)) {
            var user = DozerMapper.parseObject(userVO, User.class);

            // Atualizar emails do usuário
            if (userVO.getEmailIds() != null) {
                var emails = emailRepository.findAllById(userVO.getEmailIds());
                user.setEmails(emails);
            } else {
                user.setEmails(null);
            }

            // Atualizar grupos do usuário
            if (userVO.getGroupIds() != null) {
                var groups = groupRepository.findAllById(userVO.getGroupIds());
                user.setGroups(groups);
            } else {
                user.setGroups(null);
            }

            user = userRepository.save(user);
            return DozerMapper.parseObject(user, UserVO.class);
        }
        return null;
    }

    public String delete(Long id) {
        var dbUser = userRepository.findById(id);
        if (dbUser.isPresent()) {
            userRepository.deleteById(id);
            return "User with id " + id + " has been deleted!";
        } else {
            return "ID " + id + " not found!";
        }
    }

    private boolean verifyUser(UserVO userVO) {
        if (userVO.getFirstName() != null && !userVO.getFirstName().isBlank()
                && userVO.getLastName() != null && !userVO.getLastName().isBlank()) {
            return true;
        }
        return false;
    }

    public List<UserVO> findByFirstName(String firstName) {
        List<User> users = userRepository.findByFirstName(firstName);
        return DozerMapper.parseListObject(users, UserVO.class);
    }

    public User findByFullNameAndUserName(String firstName, String lastName, String userName) {
        return userRepository.findByFullNameAndUserName(firstName, lastName, userName);
    }
}
