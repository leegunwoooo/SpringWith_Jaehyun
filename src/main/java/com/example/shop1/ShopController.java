package com.example.shop1;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        log.info(result.get(0).date);
        return "1";
    }

    @GetMapping("/list")
    String list(Model model){
        List<item> result = itemRepository.findAll();
        model.addAttribute("items", result);

        return "list.html";
    }

    @GetMapping("/Name")
    @ResponseBody
    public String name(Model model){
        People people = new People();
        people.setName("이건우");
        people.setAge(18);
        System.out.println(people.getName() + " " + people.getAge());
        people.addAge();
        System.out.println(people.getAge());
        people.changeAge(101);
        System.out.println(people.getAge());
        people.changeAge(-1);
        System.out.println(people.getAge());
        return people.getName() + " " + people.getAge();
    }

    @GetMapping("/writing")
    public String writing(){
        return "writing.html";
    }

    @PostMapping("/add")
    public String add(@RequestParam String title, @RequestParam String date){
        System.out.println("title = " + title);
        System.out.println("date = " + date);
        item item1 = new item();
        item1.setTitle(title);
        item1.setDate(date);
        itemRepository.save(item1);
        return "redirect:/list";
    }
}
