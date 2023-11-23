package web;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Myconfig extends ResourceConfig {
    public Myconfig() {

        register(CompteRestJaxRSAPI.class);
    }
}

