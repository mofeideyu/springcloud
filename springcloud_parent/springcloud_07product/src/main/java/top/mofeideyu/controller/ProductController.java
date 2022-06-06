package top.mofeideyu.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import top.mofeideyu.entity.Product;

@RestController
public class ProductController {
    @Value("${server.port}")
    private String port;

    @GetMapping("product")
    public String product() {
        return "product ok! 当前服务端口为：" + port;
    }

    @GetMapping("test")
    public String test(@RequestParam("name") String name, @RequestParam("age") Integer age) {
        System.out.println(name + " " + age);
        return "test ok,当前服务端口为" + port;
    }

    @GetMapping("test1/{name}/{age}")
    public String test1(@PathVariable("name") String name, @PathVariable("age") Integer age) {
        System.out.println(name + " " + age);
        return "test ok,当前服务端口为" + port;
    }

    @PostMapping("test1/{name}/{age}")
    public String test2(@RequestBody Product product) {
        System.out.println(product);
        return "test ok,当前服务端口为" + product.getName() + " " + product.getPrice();
    }
}
