package ru.otus.spring.integration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.channel.MessageChannels;

import java.util.Arrays;
import java.util.concurrent.Executors;

@SpringBootApplication
@IntegrationComponentScan
public class App {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(App.class, args);

        ctx.getBean(UpperService.class).upperStrings(
                Arrays.asList("foo", "bar")
        ).forEach(System.out::println);

        ctx.close();
    }

    @Bean
    public IntegrationFlow upper() {
        return f -> f
                //user.input
                .log()
                // direct channel
                .split()
                .channel(MessageChannels.executor(Executors.newSingleThreadExecutor()))
                .log()
                .transform("myHelloServiceBean", "sayHelloMethod")
                // direct channel
                .log()
                .channel("otherFlow.input")
                .aggregate()
                .log();
                // user.putput@
    }
}
