package top.mofeideyu.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import top.mofeideyu.feignclients.HistrixClient;

@RestController
public class TestController {
    @Autowired
    private HistrixClient histrixClient;

    @GetMapping("test")
    public String test() {
        System.out.println("test ok");
        String result = histrixClient.demo(24);
        System.out.println(result);
        return "09 test ok!" + result;
    }
}
