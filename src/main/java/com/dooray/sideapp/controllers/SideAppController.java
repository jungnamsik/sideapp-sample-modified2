package com.dooray.sideapp.controllers;

import mycompany.App1;
import mycompany.App2;
import mycompany.App3;

import com.dooray.sideapp.app.DooraySideApp;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


/**
 * A sample greetings controller to return greeting text
 */
@RestController
public class SideAppController {
    /**
     * @param body
     * @param sideAppParam
     * @return
     */
    @PostMapping(value = "/app1") // TODO: http://oooo/app1 을 사이드앱 설정에 등록합니다.
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Map<String, Object> app1(@RequestBody String body, @RequestAttribute Map<String, Object> sideAppParam) {
        final DooraySideApp app = new App1();

	    System.out.println(body);

        return app.execute(sideAppParam);
    }

    @PostMapping(value = "/app2") // TODO: http://oooo/app2  사이드앱 설정에 등록합니다.
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Map<String, Object> app2(@RequestBody String body, @RequestAttribute Map<String, Object> sideAppParam) {
        DooraySideApp app = new App2();

        return app.execute(sideAppParam);
    }

    @PostMapping(value = "/app3") // TODO: http://oooo/app3 을 사이드앱 설정에 등록합니다.
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Map<String, Object> app3(@RequestBody String body, @RequestAttribute Map<String, Object> sideAppParam) {
        DooraySideApp app = new App3();

        return app.execute(sideAppParam);
    }
}

