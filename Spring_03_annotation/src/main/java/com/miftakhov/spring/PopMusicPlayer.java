package com.miftakhov.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PopMusicPlayer {
    private PopMusic popMusic;

    public PopMusicPlayer() {
    }

    @Autowired
    public void setPopMusic(PopMusic popMusic) {
        this.popMusic = popMusic;
    }

    public void playMusic() {
        System.out.println(popMusic.getSong());
    }
}
