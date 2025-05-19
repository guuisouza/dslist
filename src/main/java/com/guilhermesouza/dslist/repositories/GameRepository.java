package com.guilhermesouza.dslist.repositories;

import com.guilhermesouza.dslist.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {

}
