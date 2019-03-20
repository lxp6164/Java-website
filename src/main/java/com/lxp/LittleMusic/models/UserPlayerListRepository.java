package com.lxp.LittleMusic.models;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserPlayerListRepository extends JpaRepository<UserPlayerList, Integer>{

    @Query("from UserPlayerList u where u.userName=:userName")
    List<UserPlayerList> findBy(@Param("userName") String userName);

}
