package com.iba.Game;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@RequiredArgsConstructor
public class HistoryResponse {
    String word;
    int score;

    public HistoryResponse(String word, int score) {
        this.word = word;
        this.score = score;
    }
}
