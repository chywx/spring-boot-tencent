package cn.chendahai.controller.at;/**
 * @author chy
 * @date 2021/2/4 0004 上午 11:10
 * Description：
 */

import java.util.Enumeration;
import javax.servlet.http.HttpServletRequest;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 功能描述
 *
 * @author chy
 * @date 2021/2/4 0004
 */
@RestController
@RequestMapping("/api/bet/service/africastalking/voice")
public class ATController {

    private static final Logger logger = LoggerFactory.getLogger(ATController.class);

    @PostMapping(value = "/registerOtpKSHCallback", produces = "application/xml;charset=utf-8")
    public String registerOtpKSHCallback(AfricastalkingVoice africastalkingVoice, HttpServletRequest request) {
        printLog(request);
        System.out.println(">>>>>>>" + africastalkingVoice.getDtmfDigits());

        if ("1".equals(africastalkingVoice.getDtmfDigits())) {
            return getResponseXml("Registration successful. Welcome to Bangbet.");
        }
        return getDefaultVoiceVerifyXml();
    }


    public String getResponseXml(String text) {
        Document document = DocumentHelper.createDocument();
        Element root = document.addElement("Response");
        root.addElement("Say").addAttribute("voice", "man").addText(text);
        return document.asXML();
    }


    // 默认返回的xml
    public String getDefaultVoiceVerifyXml() {
        Document document = DocumentHelper.createDocument();
        Element root = document.addElement("Response");
        Element getDigits = root.addElement("GetDigits").addAttribute("finishOnKey", "#");
        getDigits.addElement("Say").addAttribute("voice", "man").addText(" Your mobile number is applying for registration to Bangbet. To confirm, please press the # key.");
        // 默认结束语，如果没进行任何操作，则说We did not get your account number. Good bye
        root.addElement("Say").addAttribute("voice", "man").addText("We did not get your account number. Good bye");
        return document.asXML();
    }

    void printLog(HttpServletRequest request) {
        logger.error("voice {}", request.getParameterMap());
        Enumeration<String> parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String s = parameterNames.nextElement();
            String parameter = request.getParameter(s);
            logger.error("{} --- {}", s, parameter);
        }
    }

}
