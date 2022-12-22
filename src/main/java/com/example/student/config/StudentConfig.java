package com.example.student.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@Configuration
@EnableWs
public class StudentConfig {
  @Bean
  public ServletRegistrationBean<MessageDispatcherServlet> servletRegistrationBean(ApplicationContext context) {
    MessageDispatcherServlet messageDispatcherServlet = new MessageDispatcherServlet();
    messageDispatcherServlet.setApplicationContext(context);
    messageDispatcherServlet.setTransformWsdlLocations(true);
    return new ServletRegistrationBean<MessageDispatcherServlet>(messageDispatcherServlet, "/api/ws/*");
  }

  @Bean(name = "StudentService")
  public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema schema) {
    DefaultWsdl11Definition defaultWsdl11Definition = new DefaultWsdl11Definition();
    defaultWsdl11Definition.setPortTypeName("StudentEvaluation");
    defaultWsdl11Definition.setLocationUri("/api/ws");
    defaultWsdl11Definition.setTargetNamespace("http://student.example.com/api/soap/studentevaluation");
    defaultWsdl11Definition.setSchema(schema);
    return defaultWsdl11Definition;
  }

  @Bean
  public XsdSchema xsdSchema() {
    return new SimpleXsdSchema(new ClassPathResource("student.xsd"));
  }
}
