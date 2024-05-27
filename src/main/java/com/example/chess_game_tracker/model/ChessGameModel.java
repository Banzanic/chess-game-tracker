package com.example.chess_game_tracker.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Getter
@Setter
@Entity
public class ChessGameModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String date;
    private String opening;
    private String white;
    private String black;
    @ElementCollection
    @CollectionTable(name="moves", joinColumns = @JoinColumn(name="id"))
    @OrderColumn
    private List<String> moves;
    private String result;

    public void removeEmptyMoves(){
        List<String> nonEmptyMoves = new ArrayList<>();
        for(String move : getMoves()){
            if(move != null && !move.isEmpty()){
                nonEmptyMoves.add(move);
            }
        }
        setMoves(nonEmptyMoves);
    }
}
