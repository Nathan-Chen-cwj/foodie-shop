package net.seehope.foodie_shop.validate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.ServletWebRequest;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Version 1.0
 * @Author NathanChen
 * @Date 2021/2/20 15:54
 *
 * 所有的验证码实现都是三个步骤
 * 1、创建
 * 2、存储
 * 3、发送
 */
@Controller
@RequestMapping("/validate")
public class ValidateCodeController {

    /**
     * 获取session创建工具类
     */
    private SessionStrategy sessionStrategy = new HttpSessionSessionStrategy();

    public static final String IMAGE_VALIDATE_CODE_IN_SESSION = "IMAGE_VALIDATE_CODE_IN_SESSION";

    @Autowired
    private HttpServletRequest request;
    @Autowired
    private HttpServletResponse response;

    @Autowired
    private ImageValidateCodeGenerator imageValidateCodeGenerator;


    private static final Logger logger = LoggerFactory.getLogger(ValidateCodeController.class);

    @GetMapping("/image")
    public void getImageValidateCode() throws IOException {
        ImageValidateCode imageValidateCode = null;
        try {
            imageValidateCode = (ImageValidateCode) imageValidateCodeGenerator.generatorValidateCode();
        }catch (Exception e){
            e.printStackTrace();
        }
        //设置session 存储
        sessionStrategy.setAttribute(new ServletWebRequest(request,response),IMAGE_VALIDATE_CODE_IN_SESSION, imageValidateCode);
        //输出到前端 格式，往哪儿输出 发送

        ImageIO.write(imageValidateCode.getImage(),"JPEG",response.getOutputStream());
    }

}
