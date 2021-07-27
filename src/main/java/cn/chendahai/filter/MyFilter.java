package cn.chendahai.filter;

import cn.chendahai.util.HttpUtil;
import java.io.IOException;
import java.util.Date;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 功能描述
 *
 * @author chy
 * @date 2020/7/7 0007
 */
@Component
public class MyFilter implements Filter {

    private Logger logger = LoggerFactory.getLogger(MyFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;

        logger.info("date:{}, IP:{}, URI:{}", new Date(), HttpUtil.getIp(request), request.getRequestURI());
        //执行
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
