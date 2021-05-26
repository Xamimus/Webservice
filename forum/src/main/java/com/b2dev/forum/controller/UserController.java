package com.b2dev.forum.controller;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import com.b2dev.forum.entity.User;
import com.b2dev.forum.entity.EnumRole;
import com.b2dev.forum.entity.Role;
import com.b2dev.forum.repository.RoleRepository;
import com.b2dev.forum.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/user")
public class UserController {
    
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping("{id}/moderator")
    public ResponseEntity<?> toggleModerator (final @PathVariable("id") long userId){
        User newModerator = userRepository.getById(userId);
        Role roleAdmin = roleRepository.findByName(EnumRole.ROLE_ADMIN).get();
        Role roleModerator = roleRepository.findByName(EnumRole.ROLE_MODERATOR).get();
        // Si l'utilisateur visé est Admin, on annule l'opération
        if (newModerator.getRoles().contains(roleAdmin)) {
            return ResponseEntity.badRequest().build();
        }
        Set<Role> moderatorRoles = new HashSet<>();
        moderatorRoles.add(roleRepository.findByName(EnumRole.ROLE_USER).get());

        // Si l'utilisateur visé est déjà modérateur, on lui enlève le statut
        if (!newModerator.getRoles().contains(roleModerator))
        {
            moderatorRoles.add(roleRepository.findByName(EnumRole.ROLE_MODERATOR).get());
        }
        newModerator.setRoles(moderatorRoles);
        return ResponseEntity.ok(userRepository.save(newModerator));
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_MODERATOR')")
    @PutMapping("{id}/lock")
    public ResponseEntity<?> toggleUserLock (final @PathVariable("id") long userId) {
        Role roleAdmin = roleRepository.findByName(EnumRole.ROLE_ADMIN).get();
        Role roleModerator = roleRepository.findByName(EnumRole.ROLE_MODERATOR).get();
        User user = userRepository.getById(userId);
        //Si l'utilisateur est modérateur ou admin, on ne peut pas le lock
        if(!user.getRoles().contains(roleAdmin) && !user.getRoles().contains(roleModerator))
        {
            if(user.isLocked()){
                user.setLocked(false);
            } else {
                user.setLocked(true);
            }
            return ResponseEntity.ok(userRepository.save(user));
        }
        return ResponseEntity.badRequest().build();
    }
}
