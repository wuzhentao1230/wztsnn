package com.tao.wztsnn.wx.Controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.tao.wztsnn.Entity.ResultBean;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.net.HttpURLConnection;
import java.net.URL;

@Controller
@RequestMapping("/wx")
public class GetOpenIdController {

    @Value("${wx.appid}")
    private String appid;
    @Value("${wx.secret}")
    private String secret;


    @RequestMapping("/getId")
    @ResponseBody
    public ResultBean getOpenId(String code){
        ResultBean bean = new ResultBean();
        try {
            URL url = new URL("https://api.weixin.qq.com/sns/jscode2session?appid="+appid+"&secret="+secret+"&js_code="+code+"&grant_type=authorization_code");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            if (conn.getResponseCode() == 200){
                String str = IOUtils.toString(conn.getInputStream(), "utf-8");
                JSONObject jsonObject = JSON.parseObject(str.trim());
                if (jsonObject.containsKey("openid")){
                    bean.makeSuccess(jsonObject);
                }else {
                    bean.makeSuccess(jsonObject);
                }
            }
            else{
                bean.makeFail("请求失败:"+conn.getResponseCode());
            }
        } catch (Exception e) {
            bean.makeFail(e.getMessage());
        }
        return bean;
    }
}
