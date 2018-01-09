package com.yexuejc.util.exp.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @PackageName: com.yexuejc.util.exp
 * @Description:
 * @author: maxf
 * @date: 2018/1/2 15:02
 */
@RestController
public class IndexCtrl {

    @Value("${application.version}")
    String version;

    @RequestMapping(value = "/")
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView("index");
        mv.addObject("version", version);
        return mv;
    }

    @RequestMapping(value = "/md/full")
    public ModelAndView mdFull() {
        ModelAndView mv = new ModelAndView("full");
        return mv;
    }
}
