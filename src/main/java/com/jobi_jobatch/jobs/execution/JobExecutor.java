package com.jobi_jobatch.jobs.execution;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class JobExecutor
{
    @Autowired
    JobLauncher jobLauncher;

    @Autowired
    @Qualifier("importRoomsJob")
    Job impotRoomsJob;

    @Scheduled(cron = "${insertRoomJobCronExpression}")
    public void perform() throws Exception
    {
        JobParameters params = new JobParametersBuilder()
                .addString("JobID", String.valueOf(System.currentTimeMillis()))
                .toJobParameters();
        System.err.println("Lancement job executor");
        jobLauncher.run(impotRoomsJob, params);
    }
}