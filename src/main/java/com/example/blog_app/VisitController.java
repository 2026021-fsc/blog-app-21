package com.example.blog_app;

import org.springframework.web.bind.annotation.RestController;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class VisitController {
    @GetMapping("/visit")
    public String visit(HttpSession session) {
        Integer count = (Integer) session.getAttribute("count");
        if(count == null){
            count = 0;
        }
        count += 1;
        session.setAttribute("count", count);
        return "Number of visits: " + count;
    }
    
}
