package com.mytests.spring.springUrlsRequestBodyGenerating.controllers;

import com.mytests.spring.springUrlsRequestBodyGenerating.models.MyXmlPojo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/xml")
public class XMLController {

    // no completion for body
    @PostMapping(path = "/pojo", consumes = {"application/xml"})
    public String m0(@RequestBody MyXmlPojo pojo){
        return "i've got pojo: " + pojo;
    }
}
