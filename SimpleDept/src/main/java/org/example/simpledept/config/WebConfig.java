package org.example.simpledept.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @fileName : WebConfig
 * @author : GGG
 * @since : 2024-04-02
 * description : CORS 보안 설정
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Value("${simpleDms.app.front-url}")
    private String frontUrl;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")              // spring 모든 경로(접근)
                .allowedOrigins(frontUrl)                 // vue 의 주소
                .allowedMethods(                          // 허용 방식 : get/post/put/delete
                        HttpMethod.GET.name(),
                        HttpMethod.POST.name(),
                        HttpMethod.PUT.name(),
                        HttpMethod.DELETE.name()
                );
    }
}