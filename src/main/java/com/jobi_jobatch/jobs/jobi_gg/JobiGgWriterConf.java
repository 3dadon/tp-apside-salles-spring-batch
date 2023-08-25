package com.jobi_jobatch.jobs.jobi_gg;

import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class JobiGgWriterConf {
    @Bean
    public ItemWriter<String> jobiGgwriter() {
        return new ItemWriter<String>() {
            @Override
            public void write(List<? extends String> list) throws Exception {
                System.err.println("Data got from reader : "+list);
                System.err.println("WRITE Gg");
            }
        };
    }
}
