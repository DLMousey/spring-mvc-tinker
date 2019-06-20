package com.enderstudy.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

@Slf4j
public class WebAppInitializer implements WebApplicationInitializer {

    private static final String DISPATCHER_SERVLET_NAME = "dispatcher";

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        // "log" wasn't resolved before installing Lombok plugin, methinks Lombok magics
        log.info("WebAppInitializer.onStartup");

        // Create the spring application context & register the WebConfig class
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.register(WebConfig.class);

        // Create the dispatcher servlet which handles requests
        DispatcherServlet dispatcherServlet = new DispatcherServlet(context);

        // Register and configure the dispatcher servlet with the application
        ServletRegistration.Dynamic registration = servletContext.addServlet(DISPATCHER_SERVLET_NAME, dispatcherServlet);

        // Ensure our servlets are booted on startup, set the application's URLs to begin from root,
        // This will stop Tomcat from showing it's homepage
        registration.setLoadOnStartup(1);
        registration.addMapping("/");
    }
}
