package com.miftakhov.spring;


import org.springframework.stereotype.Component;

@Component("someRockMusic") //в с кобках указан id бина
public class RockMusic implements Music{
    @Override
    public String getSong() {
        return "The Sonics - Have love will travel";
    }
}
