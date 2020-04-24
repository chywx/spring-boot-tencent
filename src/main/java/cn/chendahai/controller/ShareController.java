package cn.chendahai.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 功能描述
 *
 * @author chy
 * @date 2020/4/22 0022
 */
@RestController
public class ShareController {

    @GetMapping("/share")
    public String share(String meta) {

        return "<!DOCTYPE html>\n"
            + "<html lang=\"en\">\n"
            + "<head>\n"
            + meta
//            + "  <meta property=\"og:title\" content=\"This is my plan,let's play together\"/>\n"
//            + "  <meta property=\"og:description\" content=\"This is my plan,let's play together\"/>\n"
//            + "  <meta property=\"og:image\" content=\"https://www.bangbet.com/images/activity/bet-share.jpeg\"/>\n"
//            + "  <meta property=\"og:type\" content=\"website\"/>"
            + "</head>\n"
            + "<body>\n"
            + "  \n"
            + "<script type=\"text/javascript\">\n"
            + "\twindow.location.href=\"https://www.cnblogs.com/chywx/\";\n"
            + "</script>"
            + "</body>\n"
            + "</html>";

    }
}
