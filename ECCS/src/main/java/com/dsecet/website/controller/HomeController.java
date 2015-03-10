package com.dsecet.website.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@Slf4j
public class HomeController{

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index() {
        String slogan = "Live long and prosper.";
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("slogan", slogan);
        return modelAndView;
    }
}
