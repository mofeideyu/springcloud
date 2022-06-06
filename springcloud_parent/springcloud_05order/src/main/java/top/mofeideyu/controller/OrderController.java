package top.mofeideyu.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class OrderController {

    @Value("${server.port}")
    private String port;

    @ResponseBody
    @GetMapping("order")
    public String order() {
        return "order-> " + port;
    }
}
