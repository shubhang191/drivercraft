package org.example;

import org.example.config.AppConfig;
import org.example.controller.SystemController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        SystemController sc = context.getBean(SystemController.class);
        sc.startApplicationLoop();
    }
}