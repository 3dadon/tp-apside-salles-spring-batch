package com.jobi_jobatch.jobs.roomJob;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.beans.factory.annotation.Autowired;

public class RoomJobExecutionListener implements JobExecutionListener {

    private JobExecution _jobExecution;

    private String _jobName;

    @Override
    public void beforeJob(JobExecution jobExecution) {
        this._jobExecution = jobExecution;
        this._jobName = this._jobExecution.getJobInstance().getJobName();
        System.out.println("Début du job "+_jobName);
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        if( jobExecution.getStatus() == BatchStatus.COMPLETED ){
            //job success
            System.out.println("Fin du job " + _jobName + "avec succès : ");
        }
        else if(jobExecution.getStatus() == BatchStatus.FAILED){
            //job failure
        }
    }
}
