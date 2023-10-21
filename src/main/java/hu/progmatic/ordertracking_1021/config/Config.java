package hu.progmatic.ordertracking_1021.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Configuration
public class Config {
    @Bean
    public List<Objects> newArrayList() {
        return new ArrayList<>();
    }
}
