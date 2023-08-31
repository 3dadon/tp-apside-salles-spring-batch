package com.jobi_jobatch.jobs.roomJob;

import com.jobi_jobatch.model.Room;
import com.jobi_jobatch.services.RoomService;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.item.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class RoomJobReader implements ItemReader<List<Room>>, StepExecutionListener {

    @Autowired
    private RoomService roomService;

    private StepExecution stepExecution;

    @Autowired
    private ApplicationContext applicationContext;

    @Override
    public List<Room> read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        String jobId = stepExecution.getJobParameters().getString("JobID");

        if(stepExecution.getWriteCount() < 1) {
            return roomService.getFakeRooms();
        }
        return null;
    }

    @Override
    public void beforeStep(StepExecution _stepExecution) {
        this.stepExecution = _stepExecution;
    }

    @Override
    public ExitStatus afterStep(StepExecution _stepExecution) {
        return null;
    }
}