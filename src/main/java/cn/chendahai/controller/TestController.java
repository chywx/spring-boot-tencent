package cn.chendahai.controller;

import cn.chendahai.entity.Region;
import cn.chendahai.service.RegionService;
import io.micrometer.core.instrument.util.StringUtils;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import javax.servlet.http.HttpServletRequest;
import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 功能描述
 *
 * @author chy
 * @date 2020/6/19 0019
 */
@RestController
@RequestMapping("test")
public class TestController {

    @Autowired
    private RegionService regionService;

    @GetMapping("/t1")
    public String t1() throws InterruptedException {
        System.out.println("t1 start");
        System.out.println(new Date());
        Thread.sleep(10000);
        System.out.println("t1 end");
        return "t1->ok!" + new Date();
    }

    @GetMapping("/getLocale")
    public String firebase(HttpServletRequest request) {

        Locale locale = request.getLocale();
        System.out.println(locale.getCountry());
        System.out.println(locale.getLanguage());
        Calendar instance = Calendar.getInstance(locale);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        format.setTimeZone(instance.getTimeZone());
        System.out.println(instance.getTimeZone().getID());
        String result = format.format(new Date());
        System.out.println(result);
        String ip = getIp(request);
        return ip + "-" + locale.getCountry() + "-" + locale.getLanguage() + "-" + instance.getTimeZone().getID() + "---" + result;
    }

    @GetMapping("/getIp")
    public String getIp(HttpServletRequest request) {

        String ip = request.getHeader("X-Forwarded-For");
        if (!StringUtils.isBlank(ip) && !"unKnown".equalsIgnoreCase(ip)) {
            //多次反向代理后会有多个ip值，第一个ip才是真实ip
            int index = ip.indexOf(",");
            if (index != -1) {
                return ip.substring(0, index);
            } else {
                return ip;
            }
        }
        ip = request.getHeader("X-Real-IP");
        if (!StringUtils.isBlank(ip) && !"unKnown".equalsIgnoreCase(ip)) {
            return ip;
        }

        return request.getRemoteAddr();

    }


    @GetMapping("pinyin")
    public String pinyin() {
        List<Region> list = regionService.getAll();
        for (Region region : list) {
            String regionName = region.getRegionName();
            String py = toPinyin(regionName);
            int i = regionService.updatePinYinById(region.getId(), py);
            System.out.println(i + ">>>" + regionName + ">>>" + py);
        }
        return "pinyin";
    }

    /**
     * 汉字转为拼音
     */
    public static String toPinyin(String chinese) {
        String pinyinStr = "";
        char[] newChar = chinese.toCharArray();
        HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();
        defaultFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);
        defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        for (int i = 0; i < newChar.length; i++) {
            if (newChar[i] > 128) {
                try {
                    pinyinStr += PinyinHelper.toHanyuPinyinStringArray(newChar[i], defaultFormat)[0];
                } catch (BadHanyuPinyinOutputFormatCombination e) {
                    e.printStackTrace();
                }
            } else {
                pinyinStr += newChar[i];
            }
        }
        return pinyinStr;
    }
}
