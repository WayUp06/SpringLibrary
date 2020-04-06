package controller;


import Entity.Book;
import Service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping(value = "/GetBooksOfAuthor")
    public String getBooksOfAuthor(@PathVariable String authorName, @PathVariable String authorSurname, Model model){
        ArrayList<String> list = (ArrayList<String>) authorService.getBooksOfAuthor(authorName, authorSurname);
        String books = authorName + " " + authorSurname + " wrote this books: ";
        String l = String.join(", ", list);
        books += l;
        model.addAttribute("booksOfAuthor", books);
        return "Author";
    }


    @GetMapping(value = "/GetBooksOfCoauthor")
    public String getBooksOfCoauthor(@PathVariable String coauthorName, @PathVariable String coauthorSurname, Model model){
        List<Book> books = authorService.getBooksOfCoauthor(coauthorName, coauthorSurname);
        ArrayList<String> list = new ArrayList<>();
        for (Book book : books) {
            list.add("title: " + book.getName() + " main author: " + book.getAuthor().getName() + " " + book.getAuthor().getSurname());
        }
        String result = coauthorName + " " + coauthorSurname + " was coauthor in this books:" + String.join(", ", list);
        model.addAttribute("booksOfCoauthor", result);
        return "Author";
    }

}
