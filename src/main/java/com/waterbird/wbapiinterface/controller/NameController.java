package com.waterbird.wbapiinterface.controller;


import com.waterbird.wbapisdk.model.User;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import static com.waterbird.wbapisdk.utils.SignUtils.genSign;


/**
 * 名称 API
 */
@RestController
@RequestMapping("/name")
public class NameController {
    @GetMapping("/")
    public String getNameByGet(String name, HttpServletRequest request){
        System.out.println(request.getHeader("lcc"));
        return "GET 你的名字是" + name;
    }

    @PostMapping("/postName")
    public String getNameByPost(@RequestParam String name) {
        return "POST 你的名字是" + name;
    }

    @PostMapping("/postUser")
    public String getUserNameByPost(@RequestBody User user, HttpServletRequest request) {
        String accessKey = request.getHeader("accessKey");
        String nonce = request.getHeader("nonce");
        String timestamp = request.getHeader("timestamp");
        String sign = request.getHeader("sign");
        String body = request.getHeader("body");
        //todo 数据库校验是否分配过key 以及用户是否合法
        if (Long.parseLong(nonce) > 100000) {
            throw new RuntimeException("无权限");
        }
        if (Long.parseLong(timestamp) > System.currentTimeMillis() - 5 * 60 * 1000) {
            throw new RuntimeException("请求超时");
        }
        String serverSign = genSign(body, "waterbird");
        if (!serverSign.equals(sign)) {
            throw new RuntimeException("无权限");
        }
        String result  = "POST 用户名字是" + user.getUserName();

        return result;
    }
}