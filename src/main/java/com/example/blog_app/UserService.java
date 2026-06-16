package com.example.blog_app;

import java.util.Optional;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import io.micrometer.common.util.StringUtils;

@Service
public class UserService {
  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }
  // 認証
  public boolean authenticate(String username, String password) {
    Optional<String> hash = userRepository.findPasswordHash(username);
    if (hash.isEmpty()) {
      return false;
    }
    return passwordEncoder.matches(password, hash.get());
  }

  // 新規登録
  public void addUser(UserForm form){
    if(StringUtils.isEmpty(form.getUserName())){
      throw new IllegalArgumentException();
    }else{
      BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			String hashedPassword = encoder.encode(form.getPassword());
      userRepository.saveUser(new User(null, form.getUserName(), hashedPassword));
    }
  }
}