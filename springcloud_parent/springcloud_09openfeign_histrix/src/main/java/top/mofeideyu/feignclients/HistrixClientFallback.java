package top.mofeideyu.feignclients;

import org.springframework.stereotype.Component;

@Component
public class HistrixClientFallback implements HistrixClient{
    @Override
    public String demo(Integer id) {
        return "当前服务不可用，请稍后重试。";
    }
}
