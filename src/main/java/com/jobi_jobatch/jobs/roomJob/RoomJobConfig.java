package com.jobi_jobatch.jobs.roomJob;

import com.jobi_jobatch.model.Room;
import com.jobi_jobatch.services.RoomService;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.support.ListItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Arrays;
import java.util.List;

@Configuration
@EnableBatchProcessing
public class RoomJobConfig {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Autowired
    private RoomService roomService;


    @Bean(name = "importRoomsJob")
    public Job importRoomsJob(Step importRoomsStep) {
        return jobBuilderFactory
                .get("importRoomsJob")
                .listener(new RoomJobExecutionListener())
                .start(importRoomsStep)
                .incrementer(new RunIdIncrementer())
                .build();
    }

    @Bean
    public Step importRoomsStep(ItemReader<List<Room>> rooms, ItemWriter<Room> importRoomsWriter) {
        return stepBuilderFactory
                .get("importRoomsStep")
                .<Room, Room>chunk(1)
                .reader(new ListItemReader<>(roomService.getFakeRooms()))
                .writer(importRoomsWriter)
                .build();
    }

}
