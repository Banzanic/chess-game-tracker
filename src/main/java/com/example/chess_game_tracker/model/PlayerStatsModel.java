package com.example.chess_game_tracker.model;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class PlayerStatsModel {
    private String name;
    private int gamesPlayed;
    private int wins;
    private int ties;
    private int losses;
    private double winRate;
    private String mostPopularOpening;
    private Map<String, Integer> openingCounter;

    public PlayerStatsModel(String name) {
        this.name = name;
        this.openingCounter = new HashMap<>();
    }

    public void addChessGame(ChessGameModel chessGame) {
        gamesPlayed++;
        String result = chessGame.getResult();
        String opening = chessGame.getOpening();
        if (chessGame.getWhite().equals(name)) {
            if (result.equals("white won")) {
                wins++;
            } else if (result.equals("black won")) {
                losses++;
            } else if (result.equals("tie")) {
                ties++;
            }
        } else if (chessGame.getBlack().equals(name)) {
            if (result.equals("white won")) {
                losses++;
            } else if (result.equals("black won")) {
                wins++;
            } else if (result.equals("tie")) {
                ties++;
            }
        }
        double tempWinRate = ((double) wins / (wins + losses)) * 100;
        winRate = Math.round(tempWinRate * 100.0) / 100.0;
        openingCounter.put(opening, openingCounter.getOrDefault(opening, 0) + 1);
        updateMostPopularOpening(openingCounter, opening);
    }

    private void updateMostPopularOpening(Map<String, Integer> openingCounter, String opening){
        if(getMostPopularOpening() == null || openingCounter.get(opening)>openingCounter.get(getMostPopularOpening())){
            setMostPopularOpening(opening);
        }
    }
}
