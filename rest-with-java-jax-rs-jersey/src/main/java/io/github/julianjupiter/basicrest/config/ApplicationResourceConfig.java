package io.github.julianjupiter.basicrest.config;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;

import io.github.julianjupiter.basicrest.config.provider.CorsFilter;
import io.github.julianjupiter.basicrest.config.provider.ObjectMapperContextResolver;

public class ApplicationResourceConfig extends ResourceConfig {
    private static final String PACKAGES = "io.github.julianjupiter.basicrest";

    public ApplicationResourceConfig() {
        packages(PACKAGES);
        register(new ApplicationBinder());
        register(JacksonFeature.class);
        register(ObjectMapperContextResolver.class);
        register(CorsFilter.class);
    }
}
