package com.example.shop1;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Controller
@RequiredArgsConstructor
public class ShopController {

    private final itemRepository itemRepository;

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
    @GetMapping("/info")
    @ResponseBody
    public String info(){
        List<item> result = itemRepository.findAll();
        for(item it : result){
            log.info(it.id + " " +it.date + " " + it.title);
        }
        return "1";
    }

}
