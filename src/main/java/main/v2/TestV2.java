package main.v2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Abhijeet Gulve
 */
@RestController
@RequestMapping("testApi/2")
public class TestV2 {
    @GetMapping(value = "/1")
    public String getRes1() {
        return "testApi/1/1";
    }

    @GetMapping(value = "/2")
    public String getResponse() {
        return "testApi/1/2";
    }

    @GetMapping(value = "/0")
    public String getRes() {
        return "testApi/1/0";
    }
}
