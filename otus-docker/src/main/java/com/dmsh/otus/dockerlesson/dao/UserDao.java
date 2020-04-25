package com.dmsh.otus.dockerlesson.dao;

import com.dmsh.otus.dockerlesson.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User, Long> {
}
