package net.seehope.foodie_shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @Version 1.0
 * @Author NathanChen
 * @Date 2021/1/28 16:54
 * 整个工程的启动器
 */
@SpringBootApplication
@MapperScan(basePackages = { "net.seehope.**.mapper" })
@EnableScheduling
@EnableAsync
public class FoodieShopApplication {
    public static void main(String[] args) {
        SpringApplication.run(FoodieShopApplication.class, args);
    }
}
