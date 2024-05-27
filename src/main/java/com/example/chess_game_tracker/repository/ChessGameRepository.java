package com.example.chess_game_tracker.repository;

import com.example.chess_game_tracker.model.ChessGameModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChessGameRepository extends CrudRepository<ChessGameModel, Long> {
}
