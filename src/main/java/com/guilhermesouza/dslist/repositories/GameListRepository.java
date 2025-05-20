package com.guilhermesouza.dslist.repositories;

import com.guilhermesouza.dslist.entities.GameList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameListRepository extends JpaRepository<GameList, Long> {
}
