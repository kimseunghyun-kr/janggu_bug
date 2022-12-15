package janggu_bug.janggu_bug.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import janggu_bug.janggu_bug.repository.JangGuRepository;
import janggu_bug.janggu_bug.service.JangGuService;

@Configuration
public class SpringConfig {

    private final JangGuRepository jangGuRepository;

    public SpringConfig(JangGuRepository jangGuRepository) {
        this.jangGuRepository = jangGuRepository;
    }

    @Bean
    public JangGuService jangGuService(){
        return new JangGuService(jangGuRepository);
    }
}
