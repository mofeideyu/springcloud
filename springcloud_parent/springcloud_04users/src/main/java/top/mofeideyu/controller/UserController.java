package top.mofeideyu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
public class UserController {
    @Autowired
    private DiscoveryClient discoveryClient;
    @Autowired
    private LoadBalancerClient loadBalancerClient;
    @Autowired
    private RestTemplate restTemplate;

    @ResponseBody
    @GetMapping("user")
    public String invokeDemo() {
//        List<ServiceInstance> serviceInstances = discoveryClient.getInstances("ORDER");
//        serviceInstances.forEach(serviceInstance -> {
//            String service = "服务主机 " + serviceInstance.getHost() + " 服务端口 " + serviceInstance.getPort() + " 服务地址 " + serviceInstance.getUri();
//            System.out.println(service);
//        });
//        String orderResult = restTemplate.getForObject(serviceInstances.get(0).getUri() + "/order", String.class);
//        System.out.println(orderResult);

        ServiceInstance serviceInstance = loadBalancerClient.choose("ORDER");
//        String service = "服务主机 " + serviceInstance.getHost() + " 服务端口 " + serviceInstance.getPort() + " 服务地址 " + serviceInstance.getUri();
//        System.out.println(service);
//        String orderResult = restTemplate.getForObject(serviceInstance.getUri() + "/order", String.class);

        String result = restTemplate.getForObject("http://ORDER/order", String.class);

        return "success:" + result;
    }
}
