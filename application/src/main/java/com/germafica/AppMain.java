package com.germafica;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class AppMain {

    public static void main(String[] args) {
        log.info("VRMMORPG Transaction System");
        SpringApplication.run(AppMain.class, args);
    }

}
