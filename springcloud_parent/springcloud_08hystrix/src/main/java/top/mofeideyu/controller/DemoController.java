package top.mofeideyu.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @GetMapping("demo")
//    @HystrixCommand(fallbackMethod = "demoFallBack"")
    @HystrixCommand(defaultFallback = "defaultFallback")
    public String Demo(@RequestParam Integer id) {
        if (id < 0) {
            throw new RuntimeException("无效id");
        }
        return "demo ok!";
    }


    public String demoFallBack(Integer id) {
        return "服务已熔断";
    }

    public String defaultFallback() {
        return "网络链接失败,请重试!";
    }
}
