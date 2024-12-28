package org.nda.osp;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/imitation")
public class Imitation {

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public String getImitation() {
        System.out.println("I have got request");
        return "{\"name\":\"My\"}";
    }

}
