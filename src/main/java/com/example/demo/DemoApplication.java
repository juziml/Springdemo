package com.example.demo;

import com.example.demo.model.Coffee;
import com.example.demo.model.CoffeeOrder;
import com.example.demo.model.OrderState;
import com.example.demo.repository.CoffeeOrderRepository;
import com.example.demo.repository.CoffeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Arrays;
import java.util.Collections;

@SpringBootApplication
@EnableJpaRepositories
@Slf4j
public class DemoApplication implements CommandLineRunner {

    @Autowired
    private CoffeeRepository coffeeRepository;

    @Autowired
    private CoffeeOrderRepository coffeeOrderRepository;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        initOrder();
    }

    private void initOrder() {
        Coffee latte = Coffee.builder().name("latte")
                .price(Money.of(CurrencyUnit.of("CNY"), 30.0))
                .build();
        coffeeRepository.save(latte);
        log.info("Coffee: {}", latte);

        Coffee espresso = Coffee.builder().name("espresso")
                .price(Money.of(CurrencyUnit.of("CNY"), 20.0))
                .build();
        coffeeRepository.save(espresso);
        log.info("Coffee: {}", espresso);

        CoffeeOrder latteOrder = CoffeeOrder.builder()
                .customer("Shi A")
                .items(Collections.singletonList(latte))
                .state(OrderState.INIT)
                .build();
        coffeeOrderRepository.save(latteOrder);
        log.info("CoffeeOrder: {}", latteOrder);


        CoffeeOrder eOrder = CoffeeOrder.builder()
                .customer("Shi A")
                .items(Arrays.asList(latte, espresso))
                .state(OrderState.INIT)
                .build();
        coffeeOrderRepository.save(eOrder);
        log.info("CoffeeOrder: {}", eOrder);

    }

}
