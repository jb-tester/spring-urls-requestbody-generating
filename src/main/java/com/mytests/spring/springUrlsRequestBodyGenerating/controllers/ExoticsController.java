package com.mytests.spring.springUrlsRequestBodyGenerating.controllers;

import com.mytests.spring.springUrlsRequestBodyGenerating.models.MyPojo;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/other")
public class ExoticsController {

    // Doesn't help with the body creating, but we have the live templates for these kinds of requests
    /**
     <p> Expected HTTP Request: </p>

     ###
     POST http://localhost:8080/other/multipart
     Content-Type: multipart/form-data; boundary=XXX

     --XXX
     Content-Disposition: form-data; name="id"
     Content-Type: application/json

     100

     --XXX
     Content-Disposition: form-data; name="name"
     Content-Type: text/plain

     foobar


     */
    @PostMapping(path = "/multipart", consumes = "multipart/form-data; boundary=XXX")
    public String m0(@RequestPart("name") String name, @RequestPart("id") int id) {
        return "i've got" + " " + name + ", " + id;
    }

    // no completion for the body here

    /**
     * Expected request:

     ###
     POST http://localhost:8080/other/formUrlEncoded
     Content-Type: application/x-www-form-urlencoded

     id=100&name='foo'

     */
    @PostMapping(
            path = "/formUrlEncoded",
            consumes = {MediaType.APPLICATION_JSON_VALUE})
    public String modelForM1(@RequestBody MyPojo pojo) throws Exception {

        return pojo.toString();
    }
    @PostMapping(
            path = "/formUrlEncoded",
            consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public String m1(MyPojo pojo) throws Exception {

        return pojo.toString();
    }
}
