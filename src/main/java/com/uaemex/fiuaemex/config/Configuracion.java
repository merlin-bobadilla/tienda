package com.uaemex.fiuaemex.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
@PropertySources(value = {
    @PropertySource(value = {"classpath:messages.properties", "classpath:application.properties"})
})
public class Configuracion {
    
}
