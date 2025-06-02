package com.guilhermesouza.dslist.services;

import com.guilhermesouza.dslist.dto.GameDTO;
import com.guilhermesouza.dslist.dto.GameListDTO;
import com.guilhermesouza.dslist.dto.GameMinDTO;
import com.guilhermesouza.dslist.entities.Game;
import com.guilhermesouza.dslist.entities.GameList;
import com.guilhermesouza.dslist.projections.GameMinProjection;
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

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll() {
        List<GameList> result = gameListRepository.findAll();
        return result.stream().map(GameListDTO::new).toList();
    }

    @Transactional
    public void move(Long listId, int sourceIndex, int destinationIndex) {
        List<GameMinProjection> list = gameRepository.searchByList(listId);

        GameMinProjection obj = list.remove(sourceIndex);
        list.add(destinationIndex, obj);

        int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
        int max = sourceIndex < destinationIndex ? destinationIndex : sourceIndex;
        
        for (int i = min; i <= max; i++) {
            gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
        }
    }
 }
