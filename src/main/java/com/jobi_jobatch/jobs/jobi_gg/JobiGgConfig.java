package com.jobi_jobatch.jobs.jobi_gg;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JobiGgConfig {
    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Bean
    public Job jobiGgJob(Step jobiGgStep) {
        return jobBuilderFactory
                .get("jobiGgJob")
                .start(jobiGgStep)
                .incrementer(new RunIdIncrementer())
                .build();
    }

    @Bean
    public Step jobiGgStep(ItemReader<String> jobiGgReader, ItemWriter<String> jobiGgWriter) {
        return stepBuilderFactory
                .get("jobiGgStep")
                .tasklet(new JobiGgTasklet())
                .build();
    }
}
