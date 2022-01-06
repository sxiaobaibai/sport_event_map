package jp.co.xiaobai.controller;

import jp.co.xiaobai.service.EventPlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Controller
public class RootController {
    @Autowired
     EventPlaceService eventPlaceService;

    @RequestMapping("/")
    public String getToday(Model model) {
        return "redirect:" + eventPlaceService.getURLForTodayEvent();
    }

    @RequestMapping("/event/{eventDate}")
    public String getEvent(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @PathVariable("eventDate") Date eventDate, Model model) {
        // 現状ではeventDateで指定した1日だけの大会情報を取得する
        model.addAttribute("events", eventPlaceService.getEventsFromDate(eventDate));
        model.addAttribute("eventDuration", eventPlaceService.getDuration(eventDate));
        return "showEvents";
    }
}
