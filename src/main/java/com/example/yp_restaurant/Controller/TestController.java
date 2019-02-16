package com.example.yp_restaurant.Controller;

import com.example.yp_restaurant.Entity.ResponseMessage;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @ApiOperation(value="welcome", notes="welcome by url id")
    @ApiImplicitParam(name = "id", value = "ID", required = true, dataType = "Long",paramType = "path")
    @RequestMapping(value="/{id}", method= RequestMethod.GET)
    public ResponseMessage welcome(@PathVariable Long id) {
        ResponseMessage<String> rm = new ResponseMessage<>();
        rm.setHttpCode("200");
        rm.setResponseBody("welcome " + id + "to restaurant test");
        return rm;
    }
}
