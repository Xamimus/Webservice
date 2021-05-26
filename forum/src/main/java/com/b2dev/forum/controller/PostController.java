package com.b2dev.forum.controller;

import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.*;

import com.b2dev.forum.entity.EnumRole;
import com.b2dev.forum.entity.Post;
import com.b2dev.forum.entity.Topic;
import com.b2dev.forum.entity.Report;
import com.b2dev.forum.repository.PostRepository;
import com.b2dev.forum.repository.ReportRepository;
import com.b2dev.forum.repository.TopicRepository;
import com.b2dev.forum.security.service.UserDetailsServiceImpl;


@RestController
@RequestMapping("post")
public class PostController {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private TopicRepository topicRepository;

    @Autowired
    private ReportRepository reportRepository;

    @GetMapping
    public Page<Post> getPosts(Pageable pageable) {
        return postRepository.findAll(pageable);
    }

    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN', 'ROLE_MODERATOR')")
    @PostMapping
    public ResponseEntity<Post> addPost(@RequestBody Post post) {
        //On vérifie que le User n'est pas bloqué
        if (!UserDetailsServiceImpl.getCurrentUser().isLocked()) {
            Post postToSave = new Post();
            postToSave.setAuthor(UserDetailsServiceImpl.getCurrentUser());
            postToSave.setContent(post.getContent());
            postToSave.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
            Topic topic = topicRepository.findById(post.getTopic().getId());

            //On vérifie que le Topic n'est pas bloqué
            if(!topic.isLocked())
            {
                postToSave.setTopic(topic);
                return ResponseEntity.ok(postRepository.save(postToSave));
            }
            return ResponseEntity.status(403).build();
        }
        return ResponseEntity.badRequest().build();
    }

    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN', 'ROLE_MODERATOR')")
    @PutMapping("{id}")
    public ResponseEntity<?> editPost(final @RequestBody Post post, final @PathVariable("id") long postId) {
        Post updatePost = postRepository.findById(postId);
        if (post.getAuthor() == updatePost.getAuthor() || UserDetailsServiceImpl.isAdmin() || UserDetailsServiceImpl.isModerator()) {
            if (post.getContent() != null) {
                updatePost.setContent(post.getContent());
            }
            updatePost.setUpdatedAt(new Date());
            return ResponseEntity.ok(postRepository.save(updatePost));
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> adminDeletePost(final @PathVariable("id") Integer postId) {
      try {
        if (UserDetailsServiceImpl.isAdmin()) {
          long totalBeforeDelete = postRepository.count();
          postRepository.delete(postRepository.findById(postId).get());
          return ResponseEntity.ok(totalBeforeDelete > postRepository.count());
        } else {
          return ResponseEntity.status(HttpStatus.SC_UNAUTHORIZED).build();
        }
      } catch (Exception e) {
        return ResponseEntity.badRequest().build();
      }
    }

}
