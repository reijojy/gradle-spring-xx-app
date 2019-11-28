package cradle.spring.xx.app.controller;

// This controller class has been made only for JUNIT testing practising

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@PropertySource("classpath:/datasource.properties")
public class HomeController {

    @Value("${user}")
    private String dbUserName;

    @RequestMapping("/home")
    public @ResponseBody String greeting() {
        return "Default one printing";
        //return "Database username: " + dbUserName;
        //return getDefaultText();
    }
    @RequestMapping("/greeting2")
    public String getGreeting2() {
        return "Greeting Number 2";
    }
    @RequestMapping("/dbuser")
    public String getDbuserName() {
        return "Database username: " + dbUserName;
    }
    @RequestMapping("/rcvnothing")
    public String receiveNothing() {

        return "Id was passed to function receiveNothing:";
    }
    // Test receiving a variable
    @RequestMapping("/xxxx")
    public @ResponseBody String receiveParm(@RequestParam("id") int theId) {
        // This function works as curl http://localhost:8080/xxxx?id=502

        return "Id was passed to function receiveParm: " + theId;
    }
    @RequestMapping("/dspform")
    public @ResponseBody String showForm() {
        return "form";
    }

    private String getDefaultText() {
        String s1 = "Default one printing";
        String s2 = "Default two printing";
        int i1 = 12;
        int i2 = 44;
        i2 += i1;
        if (i2 > i1) {
            return s1;
        } else {
            return s2;
        }
    }

}
