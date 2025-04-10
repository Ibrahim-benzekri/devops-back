package com.iba.Game;

import com.iba.user.User;
import jakarta.persistence.*;

import java.util.Optional;

@Entity
public class GameParty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String word;
    int score;
    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;

    public GameParty(Long id, String word, int score, User user) {
        this.id = id;
        this.user = user;
        this.word = word;
        this.score = score;
    }

    public GameParty() {
    }
}
