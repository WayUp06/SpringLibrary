package controller;


import Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.persistence.criteria.CriteriaBuilder;
import java.time.Period;
import java.util.ArrayList;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/getBooksUsedByUser")
    public String getBooksUsedByUser(@PathVariable String id, Model model){
        String str;
        ArrayList<String> list = userService.getBooksUsedByUser(Integer.parseInt(id));
        String books = String.join(", ",list);
        String res = "This user used " + books;
        model.addAttribute("booksUsed", res);
        return "User";
    }


    @GetMapping(value = "/getBooksUsingByUser")
    public String getBooksUsingByUser(@PathVariable String id2, Model model){
        ArrayList<String> list = userService.getBooksUsingByUser(Integer.parseInt(id2));
        String s;
        if(list.size() != 0) s = "This user is currently using " + String.join(", ", list);
        else  s = "This user is currently using no books.";
        model.addAttribute("booksUsing", s);
        return "User";
    }

    @GetMapping(value = "/getDebtorsInPast")
    public String getDebtorsInPast(@PathVariable String t1, Model model){
        ArrayList<String> list = userService.getDebtorsInPast(Integer.parseInt(t1));
        String s = "Debtors in past are: " + String.join(", ", list);
        model.addAttribute("pastDebtors", s);
        return "User";
    }

    @GetMapping(value = "/getPeriodOfLibraryUsing")
    public String getPeriodOfLibraryUsing(@PathVariable String id3, Model model){
        Period p = userService.getPeriodOfLibraryUsing(Integer.parseInt(id3));
        String s = "This user is using library for " + p.getYears() + " years " +
                p.getMonths() + " months " + p.getDays() + " days";
        model.addAttribute("usingPeriod", s);
        return "User";
    }

    @GetMapping(value = "/getTodayDebtors")
    public String getTodayDebtors(@PathVariable String t2, Model model){
        ArrayList<String> list = userService.getTodayDebtors(Integer.parseInt(t2));
        String s = "Today's debtors are: " + String.join(", ",list);
        model.addAttribute("todaysDebtors", s);
        return "User";
    }

    @GetMapping(value = "/getUserAverageAge")
    public String getUserAverageAge(Model model){
        double d = userService.getUserAverageAge();
        String s = "User average age is " + d;
        model.addAttribute("avAgeAll",s);
        return "User";
    }

    @GetMapping(value = "/getUserAverageAgeByAuthor")
    public String getUserAverageAgeByAuthor(@PathVariable String aan, @PathVariable String aas, Model model){
        double d = userService.getUserAverageAgeByAuthor(aan,aas);
        String s = "Average age by this author is " + d;
        model.addAttribute("avgAgeByAuthor", s);
        return "User";
    }

    @GetMapping(value = "/getUserAverageAgeByBook")
    public String getUserAverageAgeByBook(@PathVariable String aat, Model model){
        Double d = userService.getUserAverageAgeByBook(aat);
        String s = "Average age by this book is " + d;
        model.addAttribute("avgAgeByBook", s);
        return "User";
    }
}
