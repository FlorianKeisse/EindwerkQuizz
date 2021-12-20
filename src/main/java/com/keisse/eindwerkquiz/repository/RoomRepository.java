package com.keisse.eindwerkquiz.repository;

import com.keisse.eindwerkquiz.models.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Room,Long> {
}
