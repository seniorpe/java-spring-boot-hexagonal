package senior.pe.post.config;


import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;
import java.util.List;

@RequiredArgsConstructor
@Configuration
public class CorsFilterConfig {

    @Bean
    public CorsFilter corsFilter() {

        UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowCredentials(true);
        List<String> hosts =
                Arrays.asList("https://127.0.0.1:4200", "http://localhost:4200");
        corsConfiguration.setAllowedOrigins(hosts);
        corsConfiguration.setAllowedHeaders(
                Arrays.asList("Origin", "Access-Control-Allow-Origin", "Content-Type", "Accept", "JWT-Token", "Authorization",
                        "Origin, Accept", "X-Requested-With", "Access-Control-Request-Method", "Access-Control-Request-Headers",
                        "Content-Disposition"));
        corsConfiguration.setExposedHeaders(Arrays.asList(
                "Origin", "Content-Type", "Accept", "JWT-Token", "Authorization", "Access-Control-Allow-Origin",
                "Access-Control-Allow-Credentials", "Content-Disposition")
        );
        corsConfiguration.setAllowedMethods(Arrays.asList("OPTIONS", "GET", "POST", "PUT", "PATCH", "DELETE"));
        urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
        return new CorsFilter(urlBasedCorsConfigurationSource);
    }

}