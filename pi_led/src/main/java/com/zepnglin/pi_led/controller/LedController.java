package com.zepnglin.pi_led.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.zepnglin.pi_led.nio.*;

@Controller
public class LedController {

    @Autowired
    LedConnect ledConnect;

    @RequestMapping("/ledOn")
    public String ledOn(){
        ledConnect.turnOn();    //调用LedConnect的开启LED灯方法
        return "redirect:index.html";
    }
    @RequestMapping("/ledOff")
    public String ledOff(){
        ledConnect.turnOff();   //调用LedConnect的关闭LED灯方法
        return "redirect:index.html";
    }

}
