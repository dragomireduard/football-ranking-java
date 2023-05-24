package app.service;

import app.model.Player;

import java.util.ArrayList;
import java.util.List;

public class PlayerService {
    private final List<Player> players;

    public PlayerService() {
        this.players = new ArrayList<>();
    }

    public void addPlayer(Player player) {
        this.players.add(player);
    }

    public List<Player> getPlayers() {
        return this.players;
    }

    public List<Player> getPlayersByTeamId(String team) {
        return players.stream()
                .filter(player -> player.getTeam().equals(team))
                .toList();
    }
}
