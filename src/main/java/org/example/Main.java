package org.example;

import org.example.config.Appconfig;
import org.example.controller.systemController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args){
        ApplicationContext context = new AnnotationConfigApplicationContext(Appconfig.class);
        //fetch systemcontroller bean from spring container
        systemController sc = context.getBean(systemController.class);
        sc.startApplicationLoop();
    }
}
