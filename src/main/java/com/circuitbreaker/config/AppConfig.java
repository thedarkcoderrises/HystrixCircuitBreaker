package com.circuitbreaker.config;

import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class AppConfig {
//
//
//    @Value("${http.port}")
//    private int httpPort;
//
//    @Value("${server.port}")
//    private int httpsPort;
//
//
//
//    @Bean
//   public TomcatEmbeddedServletContainerFactory containerFactory (){
//        TomcatEmbeddedServletContainerFactory containerFactory = new TomcatEmbeddedServletContainerFactory(){
//            @Override
//            protected void postProcessContext(Context context) {
//                SecurityConstraint securityConstraint = new SecurityConstraint();
//                securityConstraint.setUserConstraint("CONFIDENTIAL");
//                SecurityCollection collection = new SecurityCollection();
//                collection.addPattern("/*");
//                securityConstraint.addCollection(collection);
//                context.addConstraint(securityConstraint);
//            }
//        };
//        containerFactory.addAdditionalTomcatConnectors(createConnection());
//
//        return containerFactory;
//    }
//
//    private Connector createConnection() {
//        final String protocol = "org.apache.coyote.http11.Http11NioProtocol";
//        final Connector connector = new Connector(protocol);
//        connector.setScheme("http");
//        connector.setPort(httpPort);
//        connector.setRedirectPort(httpsPort);
//        return connector;
//    }


}
