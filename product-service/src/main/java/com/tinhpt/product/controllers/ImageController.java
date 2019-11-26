package com.tinhpt.product.controllers;

import com.tinhpt.product.entities.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/")
public class ImageController {

    @Autowired
    private Environment env;

    @GetMapping("/images")
    public List<Image> getImages() {

        return Arrays.asList(
                new Image(1L, "Treehouse of Horror V", "https://www.imdb.com/title/tt0096697/mediaviewer/rm3842005760"),
                new Image(2L, "The Town", "https://www.imdb.com/title/tt0096697/mediaviewer/rm3698134272"),
                new Image(3L, "The Last Traction Hero", "https://www.imdb.com/title/tt0096697/mediaviewer/rm1445594112"),
                new Image(4L, "Running on: " + env.getProperty("local.server.port"), "https://www.imdb.com/title/tt0096697/mediaviewer/rm1445594112"));
    }
}
