package com.keisse.eindwerkquiz.repository;

import com.keisse.eindwerkquiz.models.Punishment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserScoreRepository extends JpaRepository<Punishment,Long> {
}
