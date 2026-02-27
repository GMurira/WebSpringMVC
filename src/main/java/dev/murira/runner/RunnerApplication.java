package dev.murira.runner;

import dev.murira.runner.user.User;
import dev.murira.runner.user.UserHttpClient;
import dev.murira.runner.user.UserRestClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@SpringBootApplication
public class RunnerApplication {

    private static final Logger log = LoggerFactory.getLogger(RunnerApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(RunnerApplication.class, args);
    }

    // ✅ HTTP Interface Client Bean
    @Bean
    UserHttpClient userHttpClient() {

        RestClient restClient = RestClient.create("https://jsonplaceholder.typicode.com/");

        HttpServiceProxyFactory factory = HttpServiceProxyFactory.builderFor(RestClientAdapter.create(restClient)).build();

        return factory.createClient(UserHttpClient.class);
    }

    // ✅ Runs on application startup
    @Bean
    CommandLineRunner runner(UserRestClient client) {
        return args -> {
            User user = client.findById(1);
            log.info("User: {}", user);
        };
    }
}