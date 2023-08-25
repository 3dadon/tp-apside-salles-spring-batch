package com.jobi_jobatch.jobs.jobi_gg;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class JobiGgItemReaderConf {
    @Bean
    public ItemReader<String> jobiGgReader() {
        return new ItemReader<String>() {
            @Override
            public String read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
                System.err.println("READ Gg");
                return "Reader job Gg";
            }
        };
    }
}
