package com.example.pbbackend.controller;

import com.example.pbbackend.model.Streak;
import com.example.pbbackend.model.StreakPost;
import com.example.pbbackend.service.StreakPostService;
import com.example.pbbackend.service.StreakService;
import com.example.pbbackend.utils.GetAccountOfLoggedInUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class TimelineController {
    @Autowired
    StreakService streakService;
    StreakPostService streakPostService;

    @Autowired
    GetAccountOfLoggedInUser getAccountOfLoggedInUser;

    @RequestMapping(value={"/timeline"}, method = RequestMethod.GET)
    public ModelAndView viewTimeline(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("timeline");
        return modelAndView;
    }

    @RequestMapping(value="/startNewStreak", method = RequestMethod.GET)
    public ModelAndView creationStreak(){
        ModelAndView modelAndView = new ModelAndView();
        Streak streak = new Streak();
        modelAndView.addObject("streak", streak);
        modelAndView.setViewName("newStreak");
        return modelAndView;
    }

    @RequestMapping(value = "/startNewStreak", method = RequestMethod.POST)
    public ModelAndView createNewStreak(Streak streak, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
//        User userExists = userService.findUserByName(user.getName());
        //if findStreaksByAccountid has size more than one than can't create new
        System.out.println("Binding result " + bindingResult);
        String userName = getAccountOfLoggedInUser.getLoggedInUser();
        System.out.println("logged in user: "+userName);
//        Streak streakExists = streakService.findStreakByName(userName);
        Streak streakExists = null;
        if (streakExists != null) {
            bindingResult
                    .rejectValue("userName", "error.user",
                            "You already have a streak created! Give your best there..");
        }
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("newStreak");
        } else {
            System.out.println("else mein aaya ");
            streak.setName(userName);
            streakService.saveStreak(streak);
            modelAndView.addObject("successMessage", "streak created successfully! All the best..");
            modelAndView.addObject("streak", new Streak());
            modelAndView.setViewName("newStreak");

        }
        return modelAndView;
    }


    @RequestMapping(value="/addNewPost", method = RequestMethod.GET)
    public ModelAndView additionPost(){
        ModelAndView modelAndView = new ModelAndView();
        StreakPost streakPost = new StreakPost();
        modelAndView.addObject("streakPost", streakPost);
        modelAndView.setViewName("newPost");
        return modelAndView;
    }

    @RequestMapping(value = "/addNewPost", method = RequestMethod.POST)
    public ModelAndView createNewPost(StreakPost streakPost, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
//        User userExists = userService.findUserByName(user.getName());
        //if findStreaksByAccountid has size more than one than can't create new
        String userName = getAccountOfLoggedInUser.getLoggedInUser();
        System.out.println("logged in user: "+userName);

        streakPostService.saveStreakPost(streakPost);
        modelAndView.addObject("successMessage", "post created successfully! Great job..");
        modelAndView.addObject("streak", new Streak());
        modelAndView.setViewName("newPost");

        return modelAndView;
    }
}
