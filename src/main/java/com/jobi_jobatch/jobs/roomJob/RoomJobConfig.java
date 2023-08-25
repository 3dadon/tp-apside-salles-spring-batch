package com.jobi_jobatch.jobs.roomJob;

import com.jobi_jobatch.model.Room;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@EnableBatchProcessing
public class RoomJobConfig {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Bean(name = "importRoomsJob")
    public Job importRoomsJob(Step importRoomsStep) {
        return jobBuilderFactory
                .get("importRoomsJob")
                .start(importRoomsStep)
                .incrementer(new RunIdIncrementer())
                .build();
    }

    @Bean
    public Step importRoomsStep(ItemReader<List<Room>> rooms, ItemWriter<Room> importRoomsWriter) {
        return stepBuilderFactory
                .get("importRoomsStep")
                .<List<Room>, Room>chunk(1)
                .reader(rooms)
                .writer(importRoomsWriter)
                .build();
    }
}
