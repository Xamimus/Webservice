package com.b2dev.forum.controller;

import java.util.List;

import com.b2dev.forum.entity.EnumRole;
import com.b2dev.forum.entity.Post;
import com.b2dev.forum.security.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import net.minidev.json.JSONObject;

import com.b2dev.forum.entity.Topic;
import com.b2dev.forum.repository.PostRepository;
import com.b2dev.forum.repository.TopicRepository;

@RestController
@RequestMapping("/topic")
public class TopicController {

    @Autowired
    private TopicRepository topicRepository;

    @Autowired
    private PostRepository postRepository;

    @ResponseBody
    @GetMapping
    public Page<Topic> getTopics(Pageable pageable) {
        return topicRepository.findAll(pageable);
    }

    // Exemples:
    // localhost:8080/topic/1
    // localhost:8080/topic/1?page=1
    @ResponseBody
    @GetMapping("{id}")
    public ResponseEntity<?> getTopicById(final @PathVariable("id") long topicId, @RequestParam(value = "page", defaultValue="0") int page) {
        try {
            Pageable pageable = PageRequest.of(page, 5);
            Topic topic = topicRepository.findById(topicId);
            List<Post> posts = postRepository.findByTopicIdOrderByCreatedAtDesc(topicId, pageable);
            topic.setPosts(posts);
            return ResponseEntity.ok(topic);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("")
    public ResponseEntity<Topic> addTopic(@RequestBody Topic topic) {
        Topic topicToSave = new Topic();
        topicToSave.setTitle(topic.getTitle());
        topicToSave.setPosts(topic.getPosts());
        topicToSave.setAuthor(topic.getAuthor());
        topicToSave.setLocked(false);
        if(topicToSave.getTitle() == null || topicToSave.getPosts().size() < 1){
            return ResponseEntity.badRequest().build();
        }
        topicToSave = topicRepository.save(topicToSave);
        return ResponseEntity.ok(topicToSave);
    }


    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_MODERATOR')")
    @ResponseBody
    @PutMapping("{id}")
    public ResponseEntity<Topic> editTopic(final @RequestBody Topic topic, @PathVariable long id) {
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

        return ResponseEntity.ok(topicRepository.save(updateTopic));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteTopic(final @PathVariable("id") long topicId) {
        try{
            Topic topic = topicRepository.findById(topicId);
            if(UserDetailsServiceImpl.getCurrentUser() == topic.getAuthor() && topic.getPosts().size() > 0){
                topicRepository.deleteById(topicId);
                return ResponseEntity.ok().build();
            }else{
                return new ResponseEntity<>("User is not the creator or the topic contains more than one post", HttpStatus.FORBIDDEN);
            }
        }catch(Exception e){
            return ResponseEntity.badRequest().build();
        }

    }


}
