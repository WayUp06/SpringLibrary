package controller;


import Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping(value = "/checkAvailability")
    public String checkAvailability(@PathVariable String name, Model model){
        String bookAvailability;
        if (bookService.checkBookAvailability(name)) {
            bookAvailability = "This book is available.";
        } else {
            bookAvailability = "This book isn't available.";
        }
        model.addAttribute("bookAvailability", bookAvailability);
        return "Book";
    }

    @GetMapping(value = "/getAverageBookReadingPeriod")
    public String getAverageBookReadingPeriod(@PathVariable String readName, Model model){
        int i = bookService.getAverageBookReadingPeriod(readName);
        String result = "It takes " + i + " days to read this book";
        model.addAttribute("readingPeriod", result);
        return "Book";
    }

    @GetMapping(value = "/getCountOfBookUsage")
    public String getCountOfBookUsage(@PathVariable String usageName, Model model){
        Long l = bookService.getCountOfBookUsage(usageName);
        String result = "This book was used " + l + " times.";
        model.addAttribute("usageCount", result);
        return "Book";
    }

    @GetMapping(value = "/getCountOfBookUsageByExample")
    public String getCountOfBookUsageByExample(@PathVariable String usageCountByEx, Model model){
        ArrayList<String> list = bookService.getCountOfBookUsageByExamples(usageCountByEx);
        model.addAttribute("usageCountByExample", String.join(", ", list));
        return "Book";
    }

    @GetMapping(value = "/getMostAndLessPopularBooks")
    public String getMostAndLessPopularBooks(@PathVariable String start, @PathVariable String end, Model model){
        ArrayList<String> list = bookService.getMostPopularAndUnpopularBookByPeriod(start, end);
        String result = "The most popular book is " + list.get(0) + " and the less popular is " + list.get(1);
        model.addAttribute("popularity", result);
        return "Book";
    }

}
