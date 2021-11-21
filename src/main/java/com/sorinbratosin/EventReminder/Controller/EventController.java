package com.sorinbratosin.EventReminder.Controller;


import com.sorinbratosin.EventReminder.DAO.Event;
import com.sorinbratosin.EventReminder.Security.UserSession;
import com.sorinbratosin.EventReminder.Service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class EventController {

    @Autowired
    EventService eventService;

    @Autowired
    UserSession userSession;


    @GetMapping("/events")
    @ResponseBody
    public List<Event> eventList() {
        return eventService.findAll();
    }

    @GetMapping("/check")
    public ModelAndView checkIfSessionIsActive() {
        if(userSession.getUserId() == 0) {
            return new ModelAndView("redirect:index.html");
        }
        return new ModelAndView("redirect:events");
    }
}
