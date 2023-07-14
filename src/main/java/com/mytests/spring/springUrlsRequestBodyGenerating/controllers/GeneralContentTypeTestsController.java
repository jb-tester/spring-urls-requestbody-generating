package com.mytests.spring.springUrlsRequestBodyGenerating.controllers;

import com.mytests.spring.springUrlsRequestBodyGenerating.models.MyPojo;
import com.mytests.spring.springUrlsRequestBodyGenerating.models.MyPojoWithPojoRef;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping("/general")
public class GeneralContentTypeTestsController {

    // should ask for method and work for post; ok
    @RequestMapping(path= "/reqMappingNoMethod")
    public String m0(@RequestBody MyPojo pojo){

        return "i've got the pojo: "+ pojo;
    };

    /////////////////////////////////////////////////////////////////////////////////
    // tests for content-type using
    /////////////////////////////////////////////////////////////////////////////////

    // should use default (application/json) and complete body - ok
    @PostMapping(path= "/noContentType")
    public String m1(@RequestBody MyPojo pojo){

        return "i've got the pojo: "+ pojo;
    };

    // should ask to select the content type and work for application/json ; ok
    @PostMapping(path= "/multipleConsumes", consumes =  {"text/plain", "application/json"})
    public String m2(@RequestBody MyPojo pojo){

        return "i've got the pojo: "+ pojo;
    };

    // ok; probably some placeholder (like 'request body text') can be created
    @PostMapping(path="/stringTextPlain", consumes = "text/plain")
    public String m3(@RequestBody String str){
        return "got string: " + str;
    }

    //
    @PostMapping(path= "/stringTextJson", consumes = "text/json")
    public String m4(@RequestBody String str){

        return "i've got the string: "+ str;
    };

    // inserts `!application/json` as content-type; probably we can let to select some instead?
    @PostMapping(path="/stringWithNegatedContentType", consumes = {"!application/json"})
    public String m5(@RequestBody String boo){
        return "got string: " + boo;
    }

    // application/json content type is suggested, expected: text/plain
    @PostMapping(path="/stringWithHeader", headers = "content-type=text/plain;charset=UTF-8")
    public String m6(@RequestBody String str){
        return "got string: " + str;
    }

    // shouldn't we show some warning here? Few @RequestBody-annotated parameters
    @RequestMapping(path= "/twoPojos", method = POST, consumes = "application/json")
    public String m7(@RequestBody MyPojo pojo1, @RequestBody MyPojoWithPojoRef pojo2){

        return "i should fail ";
    };

}
