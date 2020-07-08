package cn.chendahai.controller;

import io.swagger.annotations.Api;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
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

    public static void main(String[] args) throws UnsupportedEncodingException {
        String decode = URLDecoder.decode(
            "http%3A%2F%2Fjava.chendahai.cn%3A5005%2Fshare%2Fnew%3Fmeta%3Dtwitter%3Aurl%2Chttp%3A%2F%2Fgg.chendahai.cn%2Fstatic%2Fshare%2Ft1.html%2Ctwitter%3Atitle%2Cthis%20is%20new%20title%2Ctwitter%3Adescription%2Cthis%20is%20new%20desc%2Ctwitter%3Asite%2Chttp%3A%2F%2Fgg.chendahai.cn%2Fstatic%2Fshare%2Ft1.html%2Ctwitter%3Acard%2Csummary_large_image%2Ctwitter%3Aimage%2Chttp%3A%2F%2Fgg.chendahai.cn%2Fstatic%2Fimage%2Fapple.jpg",
            "UTF-8");
        System.out.println(decode);
    }

    /**
     * facebook和twitter通用的动态分享接口
     *
     * @param meta k,v,k,v 类型的字符串
     * @return html页面
     */
    @RequestMapping(value = "/share/new", produces = "text/html;charset=utf-8")
    public String shareWin(String meta) throws UnsupportedEncodingException {
        // twitter的url需要进行url解码处理
        meta = URLDecoder.decode(meta, "UTF-8");
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
            + "\twindow.location.href=\"http://java.chendahai.cn/\";\n"
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
            + "<meta property=\"twitter:url\" content=\"http://gg.chendahai.cn/static/share/t1.html\"/>\n"
            + "<meta name=\"twitter:title\" content=\"This aaa title\"/>\n"
            + "<meta name=\"twitter:description\" content=\"This aaa desc\"/>\n"
            + "<meta name=\"twitter:site\" content=\"http://gg.chendahai.cn/static/share/t1.html\">\n"
            + "<meta name=\"twitter:card\" content=\"summary_large_image\"/>\n"
            + "<meta name=\"twitter:image\" content=\"http://gg.chendahai.cn/static/image/lbxx.jpg\"/>\n"
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
