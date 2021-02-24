package net.seehope.foodie_shop.validate;

import net.seehope.foodie_shop.common.ProjectProperties;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.context.request.ServletWebRequest;

import javax.imageio.ImageIO;
import java.io.IOException;


/**
 * @Version 1.0
 * @Author NathanChen
 * @Date 2021/2/22 21:47
 */
@Component
public class ImageValidateCodeProcessor extends AbstractValidateCodeProcessor<ImageValidateCode>{

    private static final Logger logger = LoggerFactory.getLogger(ImageValidateCodeProcessor.class);

    @Autowired
    private ProjectProperties properties;

    @Override
    public void createValidateCode(ServletWebRequest request) throws IOException, ServletRequestBindingException {
        super.createValidateCode(request);
    }

    @Override
    public void validatePerCheck(ServletWebRequest request) {

    }

    @Override
    public void doValidate(ServletWebRequest request) throws ServletRequestBindingException {
        super.doValidate(request);
    }

    @Override
    public void sendValidateCode(ServletWebRequest request, ImageValidateCode code) throws IOException {
        ImageIO.write(code.getImage(),"JPEG",request.getResponse().getOutputStream());
    }

    @Override
    public String getRealValidateCodeProcessorType() {
        return "image";
    }

    @Override
    public String getProcessingUrl() {
        return properties.getImageValidateCodeProperties().getImageValidateCodeProcessingUrl();
    }
}
