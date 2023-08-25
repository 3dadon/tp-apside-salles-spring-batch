package com.jobi_jobatch.services;

import com.github.javafaker.Faker;
import com.jobi_jobatch.model.Room;
import com.jobi_jobatch.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoomService {
    @Autowired
    private RoomRepository roomRepo;

    public void saveAll(List<Room> rooms) {
        roomRepo.saveAll(rooms);
    }

    public List<Room> getFakeRooms() {
        List<Room> rooms = new ArrayList<Room>();
        Faker faker = new Faker();
        for(int ct=0; ct<2 ;ct++) {
            Room room = new Room();
            room.setCapacity(faker.number().numberBetween(1, 200));
            room.setAccessibility(faker.random().nextBoolean());
            room.setAddress(faker.address().cityName());
            room.setTelephone("0606060606");
            rooms.add(room);
        }
        return rooms;
    }

}
