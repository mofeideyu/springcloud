package top.mofeideyu.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RefreshScope //
public class TestController {

    @Value("${name}")
    private String name;

    @GetMapping("test")
    @ResponseBody
    public String test() {
        return "demo ok " + name;
    }
}
