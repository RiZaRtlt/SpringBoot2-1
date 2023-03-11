package com.example.springboot21.Comp;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaConfig {

    @Bean
    @ConditionalOnMissingBean
    public AuthorizationController postController(AuthorizationService service) {
        return new AuthorizationController(service);
    }

    @Bean
    @ConditionalOnMissingBean
    public AuthorizationService authorizationService(UserRepositoryImpl userRepository) {
        return new AuthorizationService(userRepository);
    }

    @Bean
    public UserRepositoryImpl userRepository() {
        return new UserRepositoryImpl();
    }
}
