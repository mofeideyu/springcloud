package top.mofeideyu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import top.mofeideyu.feignclient.ProductClient;

@RestController
public class CategoryController {

    @Autowired
    private ProductClient productClient;

    @GetMapping("category")
    public String category() {
        String product = productClient.product();
        return "category ok !" + product;
    }

    @GetMapping("test")
    public String test() {
        String test = productClient.test("mofei", 24);
        return "category ok !" + test;
    }

    @GetMapping("test1")
    public String test1() {
        String test = productClient.test1("mofei", 24);
        return "category ok !" + test;
    }

    @GetMapping("test2")
    public String test2() {
        String test = productClient.test1("mofei", 24);
        return "category ok !" + test;
    }
}
