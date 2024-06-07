package com.waterbird.wbapiinterface.controller;


import com.waterbird.wbapisdk.model.User;
import org.springframework.web.bind.annotation.*;

/**
 * 名称 API
 */
@RestController
@RequestMapping("/name")
public class NameController {
    @PostMapping("/user")
    public String getUserNameByPost(@RequestBody User user) {
        return "你的名字是"+user.getUserName();
    }
}