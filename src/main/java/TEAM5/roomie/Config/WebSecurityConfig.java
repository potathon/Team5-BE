package TEAM5.roomie.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class WebSecurityConfig implements WebMvcConfigurer {
    private final String frontendUrl;

    public WebSecurityConfig() {
        this.frontendUrl = System.getenv("FRONTEND_URL");
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowCredentials(true)
                        .allowedOrigins(frontendUrl)
                        .allowedMethods("*");
            }
        };
    }
}
