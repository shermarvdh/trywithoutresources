package data;

import domain.Player;

import java.util.List;

public interface PlayerRepo {
    List<Player> getPlayers();
    void addPlayers(Player p);
}
