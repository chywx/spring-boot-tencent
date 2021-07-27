package cn.chendahai.util;

import io.micrometer.core.instrument.util.StringUtils;
import javax.servlet.http.HttpServletRequest;

/**
 * @author chy
 * @date 2021年07月26日 下午 18:20
 */
public class HttpUtil {

    public static String getIp(HttpServletRequest request) {
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
        String remoteAddr = request.getRemoteAddr();
        return remoteAddr;
    }

}
