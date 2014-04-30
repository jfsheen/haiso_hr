package com.haiso.hr.configuration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.util.Log4jConfigListener;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import java.util.HashMap;

/**
 * Created by ff on 4/30/14.
 */

public class ApplicationInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        //Load application context
        AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext();
        appContext.register(AppConfig.class);
        appContext.setDisplayName("haiso HMS");

        //Context loader listener
        servletContext.addListener(new ContextLoaderListener(appContext));

        //log4j listener

        servletContext.addListener(new Log4jConfigListener());
        //Context UTF8 Encoding filter
        FilterRegistration.Dynamic encodingFilter =
                servletContext.addFilter("encodingFilter", new CharacterEncodingFilter());
        encodingFilter.setInitParameters(new HashMap<String, String>() {
            {
                put("Encoding", "UTF-8");
                put("ForceEncoding", "true");
            }
        });
        encodingFilter.addMappingForUrlPatterns(null, false, "/*");

//        CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
//        encodingFilter.setEncoding("UTF-8");
//        encodingFilter.setForceEncoding(true);
//        servletContext.addFilter("encodingFilter",encodingFilter);
//        servletContext.getFilterRegistration("encodingFilter").addMappingForUrlPatterns(null,false,"/*");

        //Dispatcher servlet
        ServletRegistration.Dynamic dispatcher =
                servletContext.addServlet("dispatcher", new DispatcherServlet(appContext));
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");
    }

}
