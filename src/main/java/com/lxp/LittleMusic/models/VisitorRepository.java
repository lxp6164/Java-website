package com.lxp.LittleMusic.models;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VisitorRepository extends JpaRepository<Visitor, Integer> {

    @Query("from Visitor v where v.ip=:ip")
    List<Visitor> findBy(@Param("ip") String ip);

    /* List<Visitor> findVisitorsByIp( String ip); */
}
