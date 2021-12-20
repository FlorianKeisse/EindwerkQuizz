package com.keisse.eindwerkquiz.services;

import com.keisse.eindwerkquiz.models.Room;
import com.keisse.eindwerkquiz.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomServiceImpl implements RoomService{


    @Autowired
    private RoomRepository roomRepository;

    @Override
    public List<Room> findAll() {
        return roomRepository.findAll();
    }

    @Override
    public void save(Room room) {
        roomRepository.save(room);
    }

    @Override
    public Optional<Room> findById(Long id) {
        return roomRepository.findById(id);
    }


    @Override
    public void deleteById(Long id) {
        roomRepository.deleteById(id);
    }
}
