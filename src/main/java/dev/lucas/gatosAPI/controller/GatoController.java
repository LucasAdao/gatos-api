package dev.lucas.gatosAPI.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/gato")
public class GatoController {

    @GetMapping("/helloworld")
    public String getGato() {
        return "Miau!";
    }

}
