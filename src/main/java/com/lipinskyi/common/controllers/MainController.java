package com.lipinskyi.common.controllers;

import com.lipinskyi.common.dao.Entity;
import com.lipinskyi.common.dao.EntityService;
import com.lipinskyi.common.api.Translator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    EntityService entityService;

    @Autowired
    Translator translator;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView getEnData() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("table_en");
        List<Entity> entities = entityService.selectAll();
        modelAndView.addObject("entities", entities);
        return modelAndView;
    }

    @RequestMapping(value = "/tableru", method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView getRuData(@RequestParam("checkbox-data") ArrayList<Integer> myValues) {

        List<Entity> entities = new ArrayList<>();

        if (myValues == null || myValues.size() == 0) {
            System.out.println("Array is empty!!!");
        } else {

            for (Integer myValue : myValues) {
                entities.add(entityService.getEntityByID(myValue));
            }
        }

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("table_ru");
        List<Entity> translatedEntities = translator.translateEntityList(entities);
        modelAndView.addObject("entities", translatedEntities);
        return modelAndView;
    }

}
