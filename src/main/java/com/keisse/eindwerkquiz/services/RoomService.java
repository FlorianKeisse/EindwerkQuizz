package com.keisse.eindwerkquiz.services;

import com.keisse.eindwerkquiz.models.Room;

import java.util.List;
import java.util.Optional;

public interface RoomService {

    List<Room> findAll();

    void save(Room room);

    Optional<Room> findById(Long id);

    void deleteById(Long id);
}
