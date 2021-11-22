package com.miftakhov.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml"
        );

        Music music = context.getBean("musicBean", Music.class);
        MusicPlayer musicPlayer = new MusicPlayer(music);
        musicPlayer.playMusic();

        MusicPlayer musicPlayer1 = context.getBean("musicPlayer", MusicPlayer.class);
        musicPlayer1.playMusic();

        MusicPlayer musicPlayer2 = context.getBean("musicPlayerSetter", MusicPlayer.class);
        musicPlayer2.playMusic();
        System.out.printf("Player name %s volume %d\n", musicPlayer2.getName(), musicPlayer2.getVolume());

        MusicPlayer musicPlayer3 = context.getBean("musicPlayerFile", MusicPlayer.class);
        musicPlayer3.playMusic();
        System.out.printf("Player name %s volume %d\n", musicPlayer3.getName(), musicPlayer3.getVolume());

        MusicPlayer musicPlayer4 = context.getBean("musiPlayerList", MusicPlayer.class);
        musicPlayer4.showPlaylist();

        //по умолчанию бины реализуют синглтон, то есть все объекты ссылаются на один и тот же
        MusicPlayer musicPlayer5 = context.getBean("musicPlayer", MusicPlayer.class);
        MusicPlayer musicPlayer6 = context.getBean("musicPlayer", MusicPlayer.class);
        System.out.println(musicPlayer5 == musicPlayer6); //true
        System.out.println(musicPlayer5);
        System.out.println(musicPlayer6);
        musicPlayer5.setVolume(15);
        musicPlayer6.setVolume(51);
        System.out.println(musicPlayer5.getVolume());
        System.out.println(musicPlayer6.getVolume());
        // вернут один и тот же объект, изменения в одном, приведут к изменениям во всех

        //для избежания ошибок связанных с этим необходимо напрямую указать скоп прототип
        MusicPlayer musicPlayer7 = context.getBean("musicPlayerPrototype", MusicPlayer.class);
        MusicPlayer musicPlayer8 = context.getBean("musicPlayerPrototype", MusicPlayer.class);
        System.out.println(musicPlayer7 == musicPlayer8); //false different obj
        System.out.println(musicPlayer7);
        System.out.println(musicPlayer8);
        musicPlayer7.setVolume(15);
        musicPlayer8.setVolume(51);
        System.out.println(musicPlayer7.getVolume());
        System.out.println(musicPlayer8.getVolume());
        //изменения в одном не ведут к изменениям в другом

        //проверка для init/destroy методов (создан класс SwingMusic, в который добавлены мтеоды инициализации и дестроя)



        SwingMusic classicalMusic = context.getBean("musicBean2", SwingMusic.class);
        System.out.println(classicalMusic.getSong());

        context.close();
    }
}
