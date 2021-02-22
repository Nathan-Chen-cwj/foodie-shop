package net.seehope.foodie_shop.web.controller;

import net.seehope.foodie_shop.common.ProjectProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Version 1.0
 * @Author NathanChen
 * @Date 2021/1/28 16:51
 */
@RestController
@RequestMapping("/hello")
public class HelloController {

    @Autowired
    private ProjectProperties projectProperties;

    @GetMapping
    public String helloSpringCloud() {
        return "success" + projectProperties.getQq().getAppid() + "  " + projectProperties.getQq().getAppsecret();
    }
}
