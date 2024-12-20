package org.nda.osp.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/imitation")
public class Imitation {

    @GetMapping
    public String getImitation() {
        return "I was wrong. Apologies";
    }

}
