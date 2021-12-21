package com.keisse.eindwerkquiz.repository;

import com.keisse.eindwerkquiz.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    User findUserByUserNameAndPassword(String userName,String passWord);

    User findUserByUserName(String userName);

//    User tempUserName(String userName);
}
