package com.mytests.spring.springUrlsRequestBodyGenerating.controllers;

import com.mytests.spring.springUrlsRequestBodyGenerating.models.*;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping("/pojos")
public class PojosController {

    /////////////////////////////////////////////////////////////////////////////////
    // Pojos, enums, lists, arrays completion. Content-type == application/json
    /////////////////////////////////////////////////////////////////////////////////


    // should use application/json and complete body - ok
    @PostMapping(path= "/applicationJson", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String m1(@RequestBody MyPojo pojo){

        return "i've got the pojo: "+ pojo;
    };

    // should complete array of objects; suggests empty json instead ``{}``
    @PostMapping(path= "/listOfPojos")
    public String m2(@RequestBody List<MyPojo> pojos){
        StringBuilder list = new StringBuilder();
        for (MyPojo myPojo : pojos) {
            list.append(" ").append(myPojo);
        }
        return "i've got the pojo list: "+ list;
    };


    // ok
    @RequestMapping(path= "/nestedPojos", method = POST, consumes = "application/json")
    public String m3(@RequestBody MyPojoWithPojoRef pojo2){

        return "i've got pojo: "+pojo2;
    };

    // should suggest literals or integers, suggests empty json (`{}`)
    @RequestMapping(path= "/enums", method = POST, consumes = "application/json")
    public String m4(@RequestBody MyEnum myEnum){

        return "i've got enum value: "+ myEnum;
    };

    // application/json content-type; should suggest literals or integers, suggests empty json (`{}`)
    @RequestMapping(path= "/enumNoContentType", method = POST)
    public String m5(@RequestBody MyEnum myEnum){

        return "i've got enum value: "+ myEnum;
    };

    // should complete array of enums; suggests empty json  ``{}``
    @RequestMapping(path= "/enumsArray", method = POST, consumes = "application/json")
    public String m6(@RequestBody MyEnum[] myEnums){

        StringBuilder enums = new StringBuilder();
        for (MyEnum myEnum : myEnums) {
            enums.append(" ").append(myEnum);
        }
        return "i've got enum value: "+ enums;
    };

    // ok
    @RequestMapping(path= "/nestedEnum", method = POST, consumes = "application/json")
    public String m7(@RequestBody MyPojoWithEnumRef pojo){

        return "i've got pojo: "+ pojo;
    };

    // ok
    @RequestMapping(path= "/nestedLists", method = POST, consumes = "application/json")
    public String m8(@RequestBody MyPojoWithListProps pojo){

        return "i've got pojo: "+pojo;
    };
}
