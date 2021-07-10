package config;

import client.RainbirdInteractor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;


@Configuration
public class ClientConfiguration {

    @Bean(destroyMethod = "closeBrowser")
    @Scope("cucumber-glue")
    RainbirdInteractor rainbirdInteractor(@Value("${rainbird.url}") String url, @Value("${rainbird.username}") String username,
                                          @Value("${rainbird.password}") String password) {
        return new RainbirdInteractor(url, username, password);
    }
}
