package com.miftakhov.spring;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class SwingMusic implements Music{

    public static SwingMusic getSwingMusic(){
        System.out.println("getSwingMusic()");
        return new SwingMusic();
    }

    @PostConstruct
    public void doMyInit(){
        System.out.println("Doing initialization SwingMusic class");
    }

    @PreDestroy
    public void doMyDestroy(){
        System.out.println("Destroying SwingMusic class");
    }

    @Override
    public String getSong() {
        return "Parov Stelar - All Night";
    }
}
