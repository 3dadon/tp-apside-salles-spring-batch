package com.jobi_jobatch.jobs.roomJob;

import com.jobi_jobatch.model.Room;
import com.jobi_jobatch.repository.RoomRepository;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
@Configuration
public class RoomJobWriter {
    @Autowired
    private RoomRepository roomRepository;
    @Bean
    public ItemWriter<Room> importRoomsWriter() {
        return new ItemWriter<Room>() {
            @Override
            public void write(List<? extends Room> rooms) throws Exception {
                List<Room> roomsToSave = ((List<Room>)rooms.get(0));
                for(Room room : roomsToSave) {
                    System.err.println("Data to WRITE : "+room.toString());
                }
                roomRepository.saveAll(roomsToSave);
            }
        };
    }
}
