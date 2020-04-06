package controller;

import Entity.BookExample;
import Service.BookExampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;

@Controller
public class BookExampleController {

    @Autowired
    private BookExampleService bookExampleService;

    @GetMapping(value = "/getBookExampleCountDuringIndependence")
    public String getBookExampleCountDuringIndependence(Model model) {
        Long l = bookExampleService.getBookExamplesCountDuringIndependence();
        String s = "We have " + l + " book examples published during independence.";
        model.addAttribute("independence", s);
        return "BookExample";
    }


    @GetMapping(value = "/getBookExampleInfoByBookName")
    public String getBookExampleInfoByBookName(@PathVariable String name, Model model) {
        ArrayList<Long> list = (ArrayList<Long>) bookExampleService.getBookExampleInfoByBookName(name);
        String s = "We have " + list.get(0) + " examples of this book. " + list.get(1) + " are available now " +
                "and " + list.get(2) + " are in use.";
        model.addAttribute("info", s);
        return "BookExample";
    }

}
