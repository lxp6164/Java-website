package com.lxp.LittleMusic.models;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserMessageRepository extends JpaRepository<UserMessage, Integer> {

    @Query("from UserMessage u where u.userName=:userName")
    List<UserMessage> findBy(@Param("userName") String userName);

    @Query("from UserMessage u where u.userName=:userName and u.password=:password ")
    List<UserMessage> findBy(@Param("userName") String userName,@Param("password") String password);



}


