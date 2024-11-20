package com.example.shop1;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @GetMapping("/list")
    public String list(Model model) {
        List<Map<String, String>> thing = new ArrayList<>();

        Map<String, String> thing1 = new HashMap<>();
        thing1.put("name", "권민재");
        thing1.put("value", "10000");
        thing1.put("count", "10");
        thing.add(thing1);

        Map<String, String> thing2 = new HashMap<>();
        thing2.put("name", "이건우");
        thing2.put("value", "20000");
        thing2.put("count", "20");
        thing.add(thing2);

        Map<String, String> thing3 = new HashMap<>();
        thing3.put("name", "김태현");
        thing3.put("value", "30000");
        thing3.put("count", "30");
        thing.add(thing3);

        model.addAttribute("thing", thing);
        return "list";
    }


}
