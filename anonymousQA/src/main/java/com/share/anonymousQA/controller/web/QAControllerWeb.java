package com.share.anonymousQA.controller.web;

import com.share.anonymousQA.service.QAService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

@Controller
@RequestMapping(value = "/web")
public class QAControllerWeb {

    @Autowired
    private QAService qaService;

    @RequestMapping("/index")
    public String index(Locale locale, Model model) {
        String[] count = qaService.getQACount();
        model.addAttribute("todayQACount", count[0]);
        model.addAttribute("monthQACount", count[1]);
        model.addAttribute("yearQACount", count[2]);
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
        String formattedDate = dateFormat.format(date);
        model.addAttribute("currentTime", formattedDate);

        return "index";
    }

    @RequestMapping("/indexDemo")
    public String indexDemo() {
        return "indexDemo";
    }

    @RequestMapping("/indexSimple")
    public String indexSimple() {
        return "indexSimple";
    }
}
