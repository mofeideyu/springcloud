package top.mofeideyu.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "HYSTRIX", fallback = HistrixClientFallback.class) //fallback:这个属性用来指定当前服务不可用时，默认的备选处理
public interface HistrixClient {

    @GetMapping("demo")
    String demo(@RequestParam("id") Integer id);

}
