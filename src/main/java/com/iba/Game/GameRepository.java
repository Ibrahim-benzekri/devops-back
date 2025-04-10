package com.iba.Game;

import com.iba.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GameRepository extends JpaRepository<GameParty,Long> {
    List<GameParty> findAllByUser(User user);
}
