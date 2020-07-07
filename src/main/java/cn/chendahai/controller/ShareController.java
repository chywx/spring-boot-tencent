package cn.chendahai.controller;

import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
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

    private Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping(value = "/share/new", produces = "text/html;charset=utf-8")
    public String shareWin(String meta) {
        System.out.println("share number is " + meta);
        String[] split = meta.split(",");
        String metaHtml = "";
        for (int i = 0; i < split.length; i++) {
            metaHtml += "<meta property=\"" + split[i] + "\" name=\"" + split[i] + "\" content=\"" + split[i + 1] + "\"/>\n";
            i++;
        }
        String retHtml = "<!DOCTYPE html>\n"
            + "<html lang=\"en\">\n"
            + "<head>\n"
            + metaHtml
            + "</head>\n"
            + "<body>\n"
            + "<script type=\"text/javascript\">\n"
            + "\twindow.location.href=\"https://www.bangbet.com/\";\n"
            + "</script>"
            + "</body>\n"
            + "</html>";
        System.out.println(retHtml);
        return retHtml;

    }


    @RequestMapping(value = "/share/{number}", produces = "text/html;charset=utf-8")
    public String shareWin(String[] property, String[] content, @PathVariable("number") String number) {
        System.out.println("share number is " + number);
        String metaHtml = "";
        for (int i = 0; i < property.length; i++) {
            metaHtml += "<meta property=\"" + property[i] + "\" name=\"" + property[i] + "\" content=\"" + content[i] + "\"/>\n";
        }
        String retHtml = "<!DOCTYPE html>\n"
            + "<html lang=\"en\">\n"
            + "<head>\n"
            + "<meta property=\"og:title\" name=\"og:title\" content=\"title666\"/>\n"
            + metaHtml
            + "</head>\n"
            + "<body>\n"
            + "<script type=\"text/javascript\">\n"
            + "\twindow.location.href=\"https://www.bangbet.com/\";\n"
            + "</script>"
            + "</body>\n"
            + "</html>";
        System.out.println(retHtml);
        return retHtml;

    }


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
