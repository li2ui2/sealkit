package cn.yubai.controller;

import cn.yubai.service.SealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * @author liwei
 * @date 2020/10/12 22:29
 * @description 签章
 */
@Controller
public class SealController {

    @Autowired
    SealService sealService;

    @RequestMapping(path="/seal")
    public String doSeal(){
        sealService.seal();
        System.out.println("签章成功");
        return "success";
    }


}
