package com.miftakhov.spring;

public class SwingMusic implements Music{
    /**
     * для реализации фабричного метода конструктор сделан приватным, это означает,
     * что объект класса можно создать только через getSwingMusic(). Обычно
     * подобный фабричный мтеод принимает какой-либо параметр и выполняет определенную
     * логику (см паттерн), в данном случае реализация фабричного метода нужна для
     * дополнительной инкапсуляции
     * */
    private SwingMusic() {}

    public static SwingMusic getSwingMusic(){
        System.out.println("getSwingMusic()");
        return new SwingMusic();
    }

    public void doMyInit(){
        System.out.println("Doing initialization SwingMusic class");
    }

    public void doMyDestroy(){
        System.out.println("Destroying SwingMusic class");
    }

    @Override
    public String getSong() {
        return "Parov Stelar - All Night";
    }
}
