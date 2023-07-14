package com.mytests.spring.springUrlsRequestBodyGenerating.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/simple")
public class SimpleBodiesController {

  /////////////////////////////////////////////////////////////////////////////////
  // default content-type, request bodies of simple types - strings, booleans, ints
  /////////////////////////////////////////////////////////////////////////////////

    // application/json content-type is used; empty json is suggested, that is incorrect. probably some placeholder (like 'request body text') can be created instead
    @PostMapping(path="/stringNoContentType")
    public String m0(@RequestBody String str){
        return "got string: " + str;
    }

    // application/json content-type is used; empty json is suggested, no completion (expected - true/false)
    @PostMapping(path="/booleanNoContentType")
    public String m1(@RequestBody Boolean boo){
        return "got boolean: " + boo;
    }

    // application/json content-type is used; empty json is suggested. probably some placeholder (like `0`) can be created
    @PostMapping(path="/intNoContentType")
    public String m2(@RequestBody int number){
        return "got number: " + number;
    }


}
