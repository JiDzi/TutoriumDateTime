package com.example.TutoriumDateTime.controller;

import com.example.TutoriumDateTime.service.DateService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalTime;

@RestController //Info an Spring, dass das unser Contr ist
@RequestMapping("/api") //"Link" beginnt immer so "localhost:8080/api ..."
public class DateController {

    private final DateService dateService;

    public DateController(DateService dateService) {
        this.dateService = dateService;
    }


    //1. wir wollen Antwort vom Server; welchen Pfad? "/time"
    @GetMapping("/time")
    public LocalTime getTime() {
        return dateService.getTime();
    }

    @GetMapping("/date")
    public String getDate(@RequestParam(required = false) String format) {
    //required=false heißt, dass man kein format mitgeben MUSS; dann hat "format" den wert NULL
        return dateService.getDate(format);
    }
}
