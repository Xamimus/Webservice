package com.b2dev.forum.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.b2dev.forum.entity.Topic;

@Repository
public interface TopicRepository extends JpaRepository<Topic, Integer> {

    Topic getById(long id);



    Topic findById(long id);

    Void deleteById(long id);


}
