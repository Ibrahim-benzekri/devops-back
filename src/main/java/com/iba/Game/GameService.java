package com.iba.Game;

import com.iba.user.User;
import com.iba.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GameService {
    private final UserRepository userRepository;
    private final GameRepository gameRepository;

    GameParty createGameParty(GameRequest request){
        Optional<User> user = userRepository.findByEmail(request.email);
        return new GameParty(null,request.word,request.score,user.get());
    }

    void addParty(GameRequest request){
        GameParty party = createGameParty(request);
        gameRepository.save(party);
    }

    HistoryResponseGlobal getHistory(String email){
        List<HistoryResponse> response = new ArrayList<>();
        Optional<User> user = userRepository.findByEmail(email);
        List<GameParty> parties = gameRepository.findAllByUser(user.get());
        int score = 0;
        for (GameParty p:parties
             ) {
            score+= p.score ;
            response.add(new HistoryResponse(p.word,p.score));
        }
        HistoryResponseGlobal responseGlobal = new HistoryResponseGlobal(response,score);
        return responseGlobal;
    }
}
