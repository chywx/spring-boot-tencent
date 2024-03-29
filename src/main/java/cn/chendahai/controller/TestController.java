package cn.chendahai.controller;

import cn.chendahai.entity.Person;
import cn.chendahai.entity.Region;
import cn.chendahai.entity.Sport;
import cn.chendahai.service.RegionService;
import cn.chendahai.util.HttpUtil;
import com.alibaba.fastjson.JSONObject;
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
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    public static void main(String[] args) throws InterruptedException {

//        System.setProperty("http.proxyHost", "127.0.0.1");
//        System.setProperty("https.proxyHost", "127.0.0.1");
//        System.setProperty("http.proxyPort", "8888");
//        System.setProperty("https.proxyPort", "8888");

        // 设置代理，hostname参数是本机的IP地址，port端口号是Fiddler设置的端口号
        HttpHost proxy = new HttpHost("127.0.0.1", 8888, "http");
        RequestConfig config = RequestConfig.custom().setProxy(proxy).build();
        CloseableHttpClient client = HttpClientBuilder.create().setDefaultRequestConfig(config).build();

//        CloseableHttpClient client = HttpClientBuilder.create().build();

        String url = "http://java.chendahai.cn/test/getIp";
        HttpGet get = new HttpGet(url);
        try {
            HttpResponse response = client.execute(get);
            HttpEntity entity = response.getEntity();
            String result = EntityUtils.toString(entity, "UTF-8");
            System.out.println("url: " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Thread.sleep(1000000000000L);
    }

    @Autowired
    private RegionService regionService;

    @PostMapping("/objInObj")
    public String objInObj(Person person) {
        System.out.println(JSONObject.toJSONString(person));
        return JSONObject.toJSONString(person);
    }

    @PostMapping("/objInObjJson")
    public String objInObjJson(@RequestBody Person person) {
        System.out.println(JSONObject.toJSONString(person));
        return JSONObject.toJSONString(person);
    }

    @PostMapping("/requestUrl")
    public String objInObjJson() {

        return "success:" + new Date();
    }


    @GetMapping("/t1")
    public String t1() throws InterruptedException {
        System.out.println("t1 start");
        System.out.println(new Date());
        Thread.sleep(10000);
        System.out.println("t1 end");
        return "t1->ok!" + new Date();
    }

    @Autowired
    private ApplicationContext context;

    @PostMapping("/getSport")
    public Sport getSport() {
        Sport testSport = context.getBean("testSport", Sport.class);
        System.out.println(JSONObject.toJSONString(testSport));
        return testSport;
    }

    /**
     * key:aaa
     * getRequestURI:/tencent/test/req
     * getRequestURL:http://localhost:5005/tencent/test/req
     * getContextPath:/tencent
     * getServletPath:/test/req
     * getServletContext().getContextPath:/tencent
     * getQueryString:key=aaa
     */
    @GetMapping("/req")
    public String req(HttpServletRequest request, String key) throws InterruptedException {
        System.out.println("key:" + key);
        System.out.println("getRequestURI:" + request.getRequestURI());
        System.out.println("getRequestURL:" + request.getRequestURL());
        System.out.println("getContextPath:" + request.getContextPath());
        System.out.println("getServletPath:" + request.getServletPath());
        System.out.println("getServletContext().getContextPath:" + request.getServletContext().getContextPath());
        System.out.println("getQueryString:" + request.getQueryString());
        return "req->ok!" + new Date() + " key: " + key;
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

        String ip = HttpUtil.getIp(request);

        return ip;

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
