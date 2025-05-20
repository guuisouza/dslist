package com.guilhermesouza.dslist.services;

import com.guilhermesouza.dslist.dto.GameDTO;
import com.guilhermesouza.dslist.dto.GameMinDTO;
import com.guilhermesouza.dslist.entities.Game;
import com.guilhermesouza.dslist.repositories.GameRepository;
import com.guilhermesouza.dslist.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.module.ResolutionException;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public GameDTO findById(Long id) {
        Game result = gameRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Game ID " + id + " not found"));
        return new GameDTO(result);
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll() {
        List<Game> result = gameRepository.findAll();
        return result.stream().map(GameMinDTO::new).toList();
    }
}
