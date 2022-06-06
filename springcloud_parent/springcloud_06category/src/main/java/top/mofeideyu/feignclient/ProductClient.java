package top.mofeideyu.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

/**调用商品服务接口*/
@FeignClient("PRODUCT")
public interface ProductClient {

    @GetMapping("product")
    String product();

    @GetMapping("test")
    String test(@RequestParam("name") String name, @RequestParam("age") Integer age);

    @GetMapping("test1/{name}/{age}")
    String test1(@PathVariable("name") String name, @PathVariable("age") Integer age);
}
