package com.example.mock.api;

import com.example.mock.biz.service.IntfMockDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller("mockApi")
@RequestMapping("/mock")
public class MockApi {
    @Autowired
    private IntfMockDataService intfMockDataService;

    @ResponseBody
    @RequestMapping(value = "data", method = {RequestMethod.POST,RequestMethod.GET}, produces = MediaType.APPLICATION_JSON_VALUE)
    public String data(@RequestParam String intfCode){
        return intfMockDataService.findByIntfCode(intfCode);
    }
}
