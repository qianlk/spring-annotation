package config;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractDispatcherServletInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

/**
 * 初始化spring和spring mvc ioc容器的配置类
 *
 * @author Qianlk
 */
public class Config extends AbstractDispatcherServletInitializer {

    /**
     * 注册字符集过滤器
     */
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        super.onStartup(servletContext);
        // 创建字符集过滤器对象
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        servletContext.addFilter("characterEncodingFilter", characterEncodingFilter);
    }

    /**
     * 用于创建springmvc 容器
     */
    @Override
    protected WebApplicationContext createServletApplicationContext() {
        AnnotationConfigWebApplicationContext acw = new AnnotationConfigWebApplicationContext();
        acw.register(SpringMvcConfig.class);
        return acw;
    }

    /**
     * 指定 DispatcherServlet 的请求映射
     */
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    /**
     * 用于创建spring 容器
     */
    @Override
    protected WebApplicationContext createRootApplicationContext() {
        AnnotationConfigWebApplicationContext acw = new AnnotationConfigWebApplicationContext();
        acw.register(SpringConfig.class);
        return acw;
    }
}
