package controller;

import Service.UsageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class UsageController {

    @Autowired
    private UsageService usageService;

    @GetMapping(value = "/getCountOfUsagesOfPeriod")
    public String getCountOfUsagesOfPeriod(@PathVariable String start, @PathVariable String end, Model model){
        long i = usageService.getCountOfUsagesOfPeriod(start, end);
        String s = "There were " + i + " usages.";
        model.addAttribute("period", s);
        return "Usage";
    }

}
