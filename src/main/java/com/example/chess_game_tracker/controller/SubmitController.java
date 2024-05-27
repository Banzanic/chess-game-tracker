package com.example.chess_game_tracker.controller;

import com.example.chess_game_tracker.model.ChessGameModel;
import com.example.chess_game_tracker.service.ChessGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SubmitController {

    @Autowired
    private ChessGameService chessGameService;

    @PostMapping("/submitChessGame")
    public String submitChessGame(@ModelAttribute("chessGameModel") ChessGameModel chessGameModel, Model model) {
        chessGameModel.removeEmptyMoves();
        model.addAttribute("chessGameModel", new ChessGameModel());
        System.out.println("Date: " + chessGameModel.getDate() + ", Opening: " + chessGameModel.getOpening() + ", White: "  + chessGameModel.getWhite() + ", Black: " + chessGameModel.getBlack() + ", moves: " + chessGameModel.getMoves() + ", Result: " + chessGameModel.getResult());
        chessGameService.putChessGame(chessGameModel);
        return "record";
    }
}