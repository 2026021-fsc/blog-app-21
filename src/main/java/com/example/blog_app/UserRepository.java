package com.example.blog_app;

import java.util.Optional;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {
  private final JdbcClient jdbcClient;

  public UserRepository(JdbcClient jdbcClient) {
    this.jdbcClient = jdbcClient;
  }
  // ユーザーの認証
  public Optional<String> findPasswordHash(String username) {
    return jdbcClient.sql("SELECT password_hash FROM users WHERE username = :username")
        .param("username", username)
        .query(String.class)
        .optional();
  }
  // ユーザーの新規保存
  public void saveUser(User user){
    jdbcClient.sql("INSERT INTO users (username, password_hash)VALUES(:username, :password_hash)")
      .param("username", user.getUserName())
      .param("password_hash", user.getPasswordHash())
      .update();
  }
}