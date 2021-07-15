package com.example.scai_yd_server.controller;

import com.example.scai_yd_server.util.ConstantPropertiesUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.net.URLEncoder;

@Controller
@RequestMapping("/wx")
public class WxLoginController {
    @GetMapping("/login")
    public String getWxCode() {

        String baseUrl = "https://open.weixin.qq.com/connect/qrconnect" +
                "?appid=%s"+
                "&redirect_uri=%s" +
                "&response_type=code" +
                "&scope=snsapi_login" +
                "&state=%s" +
                "#wechat_redirect";

        String redirectUrl = ConstantPropertiesUtil.WX_OPEN_REDIRECT_URL;
        try {
            redirectUrl = URLEncoder.encode(redirectUrl,"utf-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        String url = String.format(
                baseUrl,
                ConstantPropertiesUtil.WX_OPEN_APP_ID,
                ConstantPropertiesUtil.WX_OPEN_REDIRECT_URL,
                "chenhang"
        );
        return "redirect:"+url;
    }
}