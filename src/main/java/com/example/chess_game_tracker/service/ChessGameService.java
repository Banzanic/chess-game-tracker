package com.example.chess_game_tracker.service;

import com.example.chess_game_tracker.model.ChessGameModel;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.chess_game_tracker.repository.ChessGameRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChessGameService {

    @Autowired
    private ChessGameRepository chessGameRepository;

    public ChessGameModel putChessGame(ChessGameModel chessGameModel){
        return chessGameRepository.save(chessGameModel);
    }

    public List<ChessGameModel> getChessGame() {
        return (List<ChessGameModel>) chessGameRepository.findAll();
    }

    public ChessGameModel updateChessGame(ChessGameModel chessGameModel, Long chessGameId) {
        ChessGameModel depDB = chessGameRepository.findById(chessGameId).get();
        return chessGameRepository.save(depDB);
    }

    public void deleteChessGame(Long chessGameId) {
        chessGameRepository.deleteById(chessGameId);
    }

}
