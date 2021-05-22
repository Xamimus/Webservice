package academy.campus.rest.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import academy.campus.rest.entity.EnumRole;
import academy.campus.rest.entity.Role;
import academy.campus.rest.entity.User;
import academy.campus.rest.payload.request.LoginRequest;
import academy.campus.rest.payload.request.SignupRequest;
import academy.campus.rest.payload.response.JwtResponse;
import academy.campus.rest.payload.response.MessageResponse;
import academy.campus.rest.repository.RoleRepository;
import academy.campus.rest.repository.UserRepository;
import academy.campus.rest.security.jwt.JwtUtils;
import academy.campus.rest.security.service.UserDetailsImpl;

/**
 * 
 * @author Matthieu BACHELIER
 * @since 2021
 * @version 1.0
 */
@RestController
@RequestMapping("auth")
public class AuthController {
  @Autowired
  AuthenticationManager authenticationManager;

  @Autowired
  UserRepository userRepository;

  @Autowired
  RoleRepository roleRepository;

  @Autowired
  PasswordEncoder encoder;

  @Autowired
  JwtUtils jwtUtils;

  @PostMapping("login")
  public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
    try {
      Authentication authentication = authenticationManager
          .authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));
      SecurityContextHolder.getContext().setAuthentication(authentication);
      String jwt = jwtUtils.generateJwtToken(authentication);

      UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
      List<String> roles = userDetails.getAuthorities().stream().map(item -> item.getAuthority())
          .collect(Collectors.toList());

      return ResponseEntity.ok(new JwtResponse(jwt, userDetails.getId(), userDetails.getUsername(), roles));
    } catch (AuthenticationException e) {
      return ResponseEntity.ok(new MessageResponse(ApiMessage.ERROR_LOGIN_FAILED, "Identifiants invalides"));
    }
  }

  @PostMapping("register")
  public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
    if (userRepository.existsByEmail(signUpRequest.getEmail())) {
      return ResponseEntity.ok()
          .body(new MessageResponse(ApiMessage.ERROR_REGISTER_EMAIL_TAKEN, "L'adresse email est déjà prise"));
    }

    User user = new User();
    user.setEmail(signUpRequest.getEmail());
    user.setPassword(encoder.encode(signUpRequest.getPassword()));
    Set<Role> roles = new HashSet<Role>();
    Optional<Role> optional = roleRepository.findByName(EnumRole.ROLE_USER);
    roles.add(optional.get());
    user.setRoles(roles);
    userRepository.save(user);
    return ResponseEntity.ok(new MessageResponse(ApiMessage.REGISTER_OK, "Utilisateur inscrit avec succès !"));
  }
}
