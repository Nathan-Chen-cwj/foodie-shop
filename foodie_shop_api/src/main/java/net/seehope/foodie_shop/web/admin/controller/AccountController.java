package net.seehope.foodie_shop.web.admin.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import net.seehope.foodie_shop.bo.AdminBo;
import net.seehope.foodie_shop.common.ImageValidateCodeGenerator;
import net.seehope.foodie_shop.common.JsonResult;
import net.seehope.foodie_shop.service.AdminService;
import net.seehope.foodie_shop.utils.CookieUtils;
import net.seehope.foodie_shop.validate.ImageValidateCode;
import net.seehope.foodie_shop.vo.AdminVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * @Version 1.0
 * @Author NathanChen
 * @Date 2021/2/12 13:44
 *
 * 管理员账户控制器
 */
@RestController
@RequestMapping("/admin")
@Slf4j
public class AccountController {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private AdminService adminService;

    @Autowired
    private HttpServletResponse response;

    @Autowired
    private ObjectMapper objectMapper;

    private String verCodeInSession=null;


    @PostMapping("/login")
    public JsonResult doesUsernameMatchPassword(@RequestBody AdminBo adminBo) throws JsonProcessingException {
            JsonResult jsonResult = adminService.doesUsernameAndPasswordMatch(adminBo, verCodeInSession);
            CookieUtils.setCookie(request,response,"admin",objectMapper.writeValueAsString(jsonResult.getData()),68400,true);
            return jsonResult;
    }


    @GetMapping("/findAdminName")
    public JsonResult doesUserNameIsExist(@RequestParam String adminName){
        return JsonResult.isOk(adminService.queryUserNameIsExist(adminName));
    }
    @PostMapping("/logout")
    public JsonResult logOut(){
        CookieUtils.deleteCookie(request,response,"admin");
        return JsonResult.isOk("logout success");
    }

    @GetMapping("/imageVerCode")
    public void getValidateCode() {
        try {
            ImageValidateCodeGenerator imageValidateCodeGenerator = new ImageValidateCodeGenerator();
            ImageValidateCode validateCode = imageValidateCodeGenerator.generatorValidateCode(100,36);
            verCodeInSession = validateCode.getCode();
            ImageIO.write(validateCode.getImage(),"JPEG",response.getOutputStream());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
