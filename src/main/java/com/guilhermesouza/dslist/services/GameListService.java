package com.guilhermesouza.dslist.services;

import com.guilhermesouza.dslist.dto.GameDTO;
import com.guilhermesouza.dslist.dto.GameListDTO;
import com.guilhermesouza.dslist.dto.GameMinDTO;
import com.guilhermesouza.dslist.entities.Game;
import com.guilhermesouza.dslist.entities.GameList;
import com.guilhermesouza.dslist.repositories.GameListRepository;
import com.guilhermesouza.dslist.repositories.GameRepository;
import com.guilhermesouza.dslist.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {

    @Autowired
    private GameListRepository gameListRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll() {
        List<GameList> result = gameListRepository.findAll();
        return result.stream().map(GameListDTO::new).toList();
    }
}
