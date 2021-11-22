package com.miftakhov.spring;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class AnyMusicPlayer {
    private Music music1;
    private  Music music2;

    @Autowired
    public AnyMusicPlayer(@Qualifier("classicalMusic")Music music1, @Qualifier("popMusic")Music music2) {
        this.music1 = music1;
        this.music2 = music2;
    }



    public void playMusic(){
        System.out.println("AnyMusicPlayer has next song :\n 1. " + music1.getSong() + "\n2. " + music2.getSong());
    }
}
