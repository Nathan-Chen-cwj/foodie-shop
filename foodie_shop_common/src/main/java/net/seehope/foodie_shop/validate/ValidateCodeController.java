package net.seehope.foodie_shop.validate;

import net.seehope.foodie_shop.common.ProjectConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.ServletWebRequest;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

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
public class ValidateCodeController {

    @Autowired
    private HttpServletRequest request;
    @Autowired
    private HttpServletResponse response;

    /**
     * 使用该方法注入，在注入的时候spring会自动寻找ValidateCodeProcessor的子实现，把其注入到容器中
     * 通过该方法来自动匹配需要使用的具体的验证码处理器是 图片 还是 短信 还是 邮件
     */
    @Autowired
    private Map<String, ValidateCodeProcessor> validateCodeProcessor;


    @GetMapping(ProjectConstant.VALIDATE_CODE_URL_PREFIX+"{type}")
    public void getImageValidateCode(@PathVariable String type) throws IOException {
        // 获取具体验证码处理器 type+"ValidateCodeProcessor"
        validateCodeProcessor.get(type+"ValidateCodeProcessor").createValidateCode(new ServletWebRequest(request,response));
//        ImageValidateCode imageValidateCode = null;
//        try {
//            imageValidateCode = (ImageValidateCode) imageValidateCodeGenerator.generatorValidateCode();
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        //设置session 存储
//        sessionStrategy.setAttribute(new ServletWebRequest(request,response),(type+ProjectConstant.VALIDATE_CODE_IN_SESSION_SUFFIX).toUpperCase(), imageValidateCode);
//        //输出到前端 格式，往哪儿输出 发送
//
//        ImageIO.write(imageValidateCode.getImage(),"JPEG",response.getOutputStream());
    }

}
