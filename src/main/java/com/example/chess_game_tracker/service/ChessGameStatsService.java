package com.example.chess_game_tracker.service;

import com.example.chess_game_tracker.model.ChessGameModel;
import com.example.chess_game_tracker.model.PlayerStatsModel;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ChessGameStatsService {
    public Map<String, PlayerStatsModel> calculatePlayerStats(List<ChessGameModel> chessGames){
        Map<String, PlayerStatsModel> playerStatsMap = new HashMap<>();

        for(ChessGameModel chessGame : chessGames){
            updatePlayerStats(playerStatsMap, chessGame.getWhite(), chessGame);
            updatePlayerStats(playerStatsMap, chessGame.getBlack(), chessGame);
        }
        return playerStatsMap;
    }

    private void updatePlayerStats(Map<String, PlayerStatsModel> playerStatsMap, String name, ChessGameModel chessGame){
        PlayerStatsModel playerStats = playerStatsMap.getOrDefault(name, new PlayerStatsModel(name));
        playerStats.addChessGame(chessGame);
        playerStatsMap.put(name, playerStats);
    }
}
