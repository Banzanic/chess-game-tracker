package com.example.chess_game_tracker.controller;

import com.example.chess_game_tracker.model.ChessGameModel;
import com.example.chess_game_tracker.model.PlayerStatsModel;
import com.example.chess_game_tracker.service.ChessGameService;
import com.example.chess_game_tracker.service.ChessGameStatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Map;

@Controller
public class MenuController {

    @Autowired
    private ChessGameService chessGameService;

    @Autowired
    private ChessGameStatsService chessGameStatsService;

    @GetMapping({"/", "/home"})
    public String getHome(){
        return "home";
    }

    @GetMapping("/record")
    public String getRecord(Model model){
        model.addAttribute("chessGameModel", new ChessGameModel());
        System.out.println(model.getAttribute("chessGameModel"));
        return "record";
    }

    @GetMapping("/archive")
    public String getArchive(Model model){
        List<ChessGameModel> archivedGames =  chessGameService.getChessGame();
        model.addAttribute("games", archivedGames);
        return "archive";
    }

    @GetMapping("/stats")
    public String getStats(Model model){
        List<ChessGameModel> archivedGames = chessGameService.getChessGame();
        Map<String, PlayerStatsModel> playerStats = chessGameStatsService.calculatePlayerStats(archivedGames);
        model.addAttribute("playerStats", playerStats);
        return "stats";
    }
}
