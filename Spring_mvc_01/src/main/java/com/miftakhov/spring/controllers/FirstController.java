package com.miftakhov.spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
/**
 *
 * @RequestMapping("/first") - добавляет префикс к адресной строке всех имеющихся в классе методов
 * http://localhost:8080/goodbye - было
 * http://localhost:8080/first/goodbye - стало
*/
public class FirstController {

    @GetMapping("/hello") // http://localhost:8080/hello
    public String helloPage(){
        return "first/hello";
    }

    @GetMapping("/hello1") // http://localhost:8080/hello1?name=Il'yas&surname=Miftakhov
    public String helloPage1(HttpServletRequest request){
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        System.out.println(name + " " + surname);

        return "first/hello";
    }

    /**
     *
     * @param name
     * @param surname
     * http://localhost:8080/hello2?name=Il'yas&surname=Miftakhov -
     * если указан required=true или не указан то в запросе обязательно должны быть указаны парамметры
     */
    @GetMapping("/hello2") //
    public String helloPage2(@RequestParam(value = "name", required = false) String name,
                            @RequestParam(value = "surname", required = false) String surname){
        System.out.println(name + " " + surname);
        return "first/hello";
    }


    @GetMapping("/goodbye")
    public String goodByePage(){
        return "first/goodbye";
    }
}
