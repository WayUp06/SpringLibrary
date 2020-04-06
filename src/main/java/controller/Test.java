package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Test {

    @GetMapping("/ho")
    public void ho(){
        System.out.println("yelihsjldvsjlbvsjbnsjbjlsfnjlbjsf");
    }

}
