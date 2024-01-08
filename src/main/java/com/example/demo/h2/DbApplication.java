package com.example.demo.h2;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@RestController
@Slf4j//日志库
@SpringBootApplication
public class DbApplication implements CommandLineRunner {

    @Autowired
    DataSource dataSource;


    public static void main(String[] args) {
        SpringApplication.run(DbApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        showConnection();
        showData();
    }

    private void showData() {

    }

    private void showConnection() throws SQLException {
        log.info("[jzxs] showConnection");
        // HikariDataSource
        log.info("[jzxs] {}", dataSource.toString());
        Connection connection = dataSource.getConnection();
//        url=jdbc:h2:mem:5ed2bff1-b2ca-4180-adb5-e879e90f321e user=SA
        log.info("[jzxs] {}", connection.toString());
        connection.close();
    }


    @RequestMapping("/helloDb")
    public String hello() {
        return "hello i am db";
    }
}
