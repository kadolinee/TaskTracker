package com.codexsoft.tasktracking.initializer;

import com.codexsoft.tasktracking.config.DaoConfig;
import com.codexsoft.tasktracking.config.WebConfig;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class WebApplicationInitializerImpl implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext configWebApplicationContext = new AnnotationConfigWebApplicationContext();
        configWebApplicationContext.register(WebConfig.class, DaoConfig.class);
        configWebApplicationContext.setServletContext(servletContext);

        ServletRegistration.Dynamic servlet = servletContext.addServlet("dispatcherServlet",
                new DispatcherServlet(configWebApplicationContext));

        servlet.setLoadOnStartup(1);
        servlet.addMapping("/");
    }

}
