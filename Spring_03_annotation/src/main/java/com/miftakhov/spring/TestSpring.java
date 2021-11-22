package com.miftakhov.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml"
        );

        // указан id
        Music music = context.getBean("someRockMusic", Music.class);
        MusicPlayer musicPlayer = new MusicPlayer(music);
        musicPlayer.playMusic();

        // не указан id
        Music popMusic = context.getBean("popMusic", Music.class);
        MusicPlayer musicPlayer1 = new MusicPlayer(popMusic);
        musicPlayer1.playMusic();

        /**
         * @Component - создает бин
         * @Autowired - автозаполнение поля, в данном случае в конструктор подходит только один
         * конкретный бин classicalMusic и конфликтов не возникает. Spring автоматически сканирует
         * контейнер бмнов и подставляет подходящий, в случае, если он есть. Если нет - ошибка.
         */
        ClassicalMusicPlayer classicalMusicPlayer = context.getBean("classicalMusicPlayer", ClassicalMusicPlayer.class);
        classicalMusicPlayer.playMusic();

        /**
         * @Autowired указан не над методом, а над полем, куда Spring также подтянул единственный подходящий бин
         */
        RockMusicPlayer rockMusicPlayer = context.getBean("rockMusicPlayer", RockMusicPlayer.class);
        rockMusicPlayer.playMusic();

        /**
         * @Autowired указан над методом сеттер
         */
        PopMusicPlayer popMusicPlayer = context.getBean("popMusicPlayer", PopMusicPlayer.class);
        popMusicPlayer.playMusic();


        /**
         *  @Qualifier - уточняет какой именно бин мы хотим применить в данной ситуации
         *  В примере класс может принять любой класс, расширяющий интерфейс Music,
         *  но при помощи @Qualifier мы уточнили, что нужен именно бин classicalMusic
         */
        AnyMusicPlayer anyMusicPlayer = context.getBean("anyMusicPlayer", AnyMusicPlayer.class);
        anyMusicPlayer.playMusic();


        /**
         * @Value("${musicPlayer.name}") - при помощи данной аннотации мы можем внедрять значения
         * из стороннего файла
         * @Scope("singleton") @Scope("prototipe") - позволяют указать скоп создаваемого бина
         */
        SomeMusicPlayer someMusicPlayer = context.getBean("someMusicPlayer", SomeMusicPlayer.class);
        System.out.println(someMusicPlayer.getName() + " " + someMusicPlayer.getVolume());


        /**
         * @PostConstruct - init method
         * @PreDestroy - destroy method
         */
        SwingMusic swingMusic = context.getBean("swingMusic", SwingMusic.class);
        System.out.println(swingMusic.getSong());

        context.close();
    }
}
