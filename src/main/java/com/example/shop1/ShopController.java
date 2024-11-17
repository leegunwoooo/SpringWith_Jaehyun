package com.example.shop1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;

@Controller
public class ShopController {
    @GetMapping("/about")
    @ResponseBody
    public String fiss(){
        return "피싱사이트에요";
    }

    @GetMapping("/html")
    @ResponseBody
    public String html(){
        return "<h4>반갑습니다</h4>";
    }

    @GetMapping("/html1")
    public String html1(){
        return "index.html";
    }

    @GetMapping("/date")
    @ResponseBody
    public String time(){
        return LocalDateTime.now().toString();
    }

}
