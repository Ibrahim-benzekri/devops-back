package com.iba.Game;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class GameRequest {
    String word;
    int score;
    String email;
}
