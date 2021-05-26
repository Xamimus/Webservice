package com.b2dev.forum.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.b2dev.forum.entity.Topic;

import java.util.List;

@Repository
public interface TopicRepository extends JpaRepository<Topic, Integer> {

    Topic getById(long id);



    Topic findById(long id);

    void deleteById(long id);

    List<Topic> findTop5ByOrderByIdDesc();

}
