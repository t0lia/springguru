package tech.bigtheta.springguru.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import tech.bigtheta.springguru.repositories.AuthorRepository;

@Controller
public class AuthorController {

    private final AuthorRepository authorRepository;

    public AuthorController(AuthorRepository bookRepository) {
        this.authorRepository = bookRepository;
    }

    @GetMapping("/authors")
    public String getBooks(Model model){
        model.addAttribute("authors", authorRepository.findAll() );
        return "authors";

    }
}
