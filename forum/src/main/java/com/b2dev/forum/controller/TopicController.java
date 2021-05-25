package com.b2dev.forum.controller;

import com.b2dev.forum.entity.EnumRole;
import com.b2dev.forum.security.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.b2dev.forum.entity.Topic;
import com.b2dev.forum.repository.TopicRepository;

import java.util.Optional;


@RestController
@RequestMapping("/topic")
public class TopicController {

    @Autowired
    private TopicRepository topicRepository;

    @ResponseBody
    @GetMapping
    public Page<Topic> getTopics(Pageable pageable) {
        return topicRepository.findAll(pageable);
    }

    @ResponseBody
    @GetMapping("{id}")
    public Topic getTopicById(final @PathVariable("id") String topicId) {
        try {
            Topic topic = topicRepository.findById(Long.parseLong(topicId));
            System.out.println(topic);
            return topic;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    @PostMapping("")
    public Topic addTopic(@RequestBody Topic topic) {
        Topic topicToSave = new Topic();
        topicToSave.setTitle(topic.getTitle());
        topicToSave.setPosts(topic.getPosts());
        topicToSave.setAuthor(topic.getAuthor());
        topicToSave.setLocked(false);
        if(topicToSave.getTitle() == null){
            return null;
        }
        if(topicToSave.getPosts().size() < 1){
            return null;
        }
        topicToSave = topicRepository.save(topicToSave);
        return topicToSave;
    }


    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_MODERATOR')")
    @ResponseBody
    @PutMapping("{id}")
    public Topic editTopic(final @RequestBody Topic topic, @PathVariable Long id) {
        Topic updateTopic = topicRepository.findById(id);
        updateTopic.setLocked(topic.isLocked());
        if(topic.getTitle() != null){
            updateTopic.setTitle(topic.getTitle());
        }
        if(topic.getAuthor() != null){
            updateTopic.setAuthor(topic.getAuthor());
        }
        if(topic.getCategory() != null){
            updateTopic.setCategory(topic.getCategory());
        }
        if(topic.getPosts() != null){
            updateTopic.setPosts(topic.getPosts());
        }

        return topicRepository.save(updateTopic);
    }

    @DeleteMapping("{id}")
    public void deleteTopic(final @PathVariable("id") Integer topicId) {
        try{
            Topic topic = topicRepository.findById(topicId).get();
            if(UserDetailsServiceImpl.getCurrentUser() == topic.getAuthor() && topic.getPosts().size() > 0){
                topicRepository.deleteById(topicId);
            }else{
                System.out.println("user is not the creator or the topic contains more than one post");
            }
        }catch(Exception e){
            System.out.println(e);
        }

    }


}
