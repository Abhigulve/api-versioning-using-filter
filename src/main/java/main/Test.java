package main;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Abhijeet Gulve
 */

@RestController
@RequestMapping("testApi/0")
public class Test {
    @GetMapping(value = "/1")
    public String getRes1() {
        return "testApi/0/1";
    }

    @GetMapping(value = "/0")
    public String getRes() {
        return "testApi/0/0";
    }
}
