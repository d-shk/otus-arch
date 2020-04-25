package com.dmsh.otus.dockerlesson.service.impl;

import com.dmsh.otus.dockerlesson.dao.UserDao;
import com.dmsh.otus.dockerlesson.model.User;
import com.dmsh.otus.dockerlesson.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public Optional<User> findById(Long id) {
        return userDao.findById(id);
    }

    @Override
    public User save(User user) {
        if(user.getId()!= null) {
            Optional<User> foundUserOpt = userDao.findById(user.getId());

            if(foundUserOpt.isPresent()) {
                User foundUser = foundUserOpt.get();
                if(user.getEmail() != null) {
                    foundUser.setEmail(user.getEmail());
                }

                if(user.getUsername() != null) {
                    foundUser.setUsername(user.getUsername());
                }

                if(user.getFirstName() != null) {
                    foundUser.setFirstName(user.getFirstName());
                }

                if(user.getLastName() != null) {
                    foundUser.setLastName(user.getLastName());
                }

                if(user.getPhone() != null) {
                    foundUser.setPhone(user.getPhone());
                }

                return userDao.save(foundUser);
            }
        }

        return userDao.save(user);
    }

    @Override
    public void deleteById(Long id) {
        userDao.deleteById(id);
    }
}
