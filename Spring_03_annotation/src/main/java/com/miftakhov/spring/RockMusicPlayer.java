package com.miftakhov.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RockMusicPlayer {
    @Autowired
    private RockMusic music;

    public RockMusicPlayer(RockMusic music) {
        this.music = music;
    }

    public void playMusic() {
        System.out.println(music.getSong());
    }
}
