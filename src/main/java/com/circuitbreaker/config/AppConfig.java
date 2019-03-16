package com.circuitbreaker.config;

import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

//@Configuration
public class AppConfig {


//    @Value("${http.port}")
//    private int httpPort;
//
//    @Value("${https.port}")
//    private int httpsPort=8443;
//
//    private static Logger LOG = LoggerFactory.getLogger(AppConfig.class);
//
//    @Bean
//   public TomcatEmbeddedServletContainerFactory containerFactory () throws Exception {
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
//    private Connector createConnection() throws Exception {
//        verifyPorts();
//        final String protocol = "org.apache.coyote.http11.Http11NioProtocol";
//        final Connector connector = new Connector(protocol);
//        connector.setScheme("http");
//        connector.setPort(httpPort);
//        connector.setRedirectPort(httpsPort);
//        return connector;
//    }
//
//    private void verifyPorts() throws Exception {
//        if (StringUtils.isEmpty(httpPort) || StringUtils.isEmpty(httpsPort))
//            throw new Exception("Inavlid port");
//        else
//            LOG.info("http.port: {}, https.port: {}",httpPort,httpsPort);
//    }


}
