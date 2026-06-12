package com.example.blog_app;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AuthController {
  private final UserService userService;

  public AuthController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping("/login")
  public String loginForm() {
    return "login";
  }

  @PostMapping("/login")
  public String login(@ModelAttribute LoginForm form, HttpSession session,
      RedirectAttributes redirectAttributes) {
    if (userService.authenticate(form.getUsername(), form.getPassword())) {
      session.setAttribute("username", form.getUsername());
      redirectAttributes.addFlashAttribute("message", "ログインしました");
      return "redirect:/blogs";
    }
    redirectAttributes.addFlashAttribute("message", "ユーザー名かパスワードが違います");
    return "redirect:/login";
  }

  @PostMapping("/logout")
  public String logout(HttpSession session) {
    session.invalidate();
    return "redirect:/blogs";
  }
}