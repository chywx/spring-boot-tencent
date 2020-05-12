package cn.chendahai.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * 功能描述
 *
 * @author chy
 * @date 2020/4/22 0022
 */
@RestController
@Api(tags = "分享第三方")
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

    @GetMapping("/shareTwitter")
    public String shareTwitter() {

        return "<!DOCTYPE html>\n"
            + "<html lang=\"en\">\n"
            + "<head>\n"
            + "</head>\n"
            + "  <meta property=\"twitter:url\" content=\"https://www.bangbet.com/\"/>\n"
            + "  <meta property=\"og:url\" content=\"https://www.bangbet.com/\"/>\n"
            + "  <meta name=\"twitter:site\" content=\"https://www.bangbet.com/\">\n"
            + "  <meta name=\"twitter:title\" content=\"This is my plan,let's play together\"/>\n"
            + "  <meta name=\"twitter:description\" content=\"This is my plan,let's play together\"/>\n"
            + "  <meta name=\"twitter:card\" content=\"summary_large_image\"/>\n"
            + "  <meta name=\"twitter:image\" content=\"https://www.bangbet.com/images/activity/bet-share.jpeg\"/>"
            + "<body>\n"
            + "  \n"
            + "<script type=\"text/javascript\">\n"
            + "\twindow.location.href=\"https://www.cnblogs.com/chywx/\";\n"
            + "</script>"
            + "</body>\n"
            + "</html>";

    }

//    @GetMapping("/shareTwitter")
//    public String shareTwitterMeta(String title, String description, String image) {
//
//        return "<!DOCTYPE html>\n"
//            + "<html lang=\"en\">\n"
//            + "<head>\n"
//            + "  <meta property=\"twitter:url\" content=\"https://www.bangbet.com/\"/>\n"
//            + "  <meta property=\"og:url\" content=\"https://www.bangbet.com/\"/>\n"
//            + "  <meta name=\"twitter:site\" content=\"https://www.bangbet.com/\">\n"
//            + "  <meta name=\"twitter:title\" content=\"" + title + "\"/>\n"
//            + "  <meta name=\"twitter:description\" content=\"" + description + "\"/>\n"
//            + "  <meta name=\"twitter:card\" content=\"summary_large_image\"/>\n"
//            + "  <meta name=\"twitter:image\" content=\"" + image + "\"/>"
//            + "</head>\n"
//            + "<body>\n"
//            + "  \n"
//            + "<script type=\"text/javascript\">\n"
//            + "\twindow.location.href=\"https://www.cnblogs.com/chywx/\";\n"
//            + "</script>"
//            + "</body>\n"
//            + "</html>";
//
//    }
}
