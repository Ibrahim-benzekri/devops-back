package com.iba.Game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/auth/")
@CrossOrigin(origins = "http://localhost:3000")
public class GameController {

    private final GameService gameService;

    @Autowired
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @PostMapping("/addWord")
    public ResponseEntity<?> addWord(@RequestBody GameRequest req){
        try{
            gameService.addParty(req);
            return ResponseEntity.ok("Word saved");
        }catch (Exception e){
            return ResponseEntity.ok(false);
        }
    }

    @PostMapping("/historique")
    public ResponseEntity<?> getHistorique(@RequestBody historyRequest request) {
        try {
            HistoryResponseGlobal resp =  gameService.getHistory(request.email);
            return ResponseEntity.ok(resp);
        } catch (Exception e) {
            return ResponseEntity.ok(false);
        }
    }
}
