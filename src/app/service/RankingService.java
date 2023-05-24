package app.service;

import app.model.Player;
import app.model.Team;


import java.util.Comparator;
import java.util.List;

public class RankingService {
    private final TeamService teamService;
    private final PlayerService playerService;

    public RankingService(TeamService teamService, PlayerService playerService) {
        this.teamService = teamService;
        this.playerService = playerService;
    }


    public List<Team> getRankingTeamByMatchesWon() {
        List<Team> ranking = this.teamService.getTeams();
        ranking.sort(Comparator.comparingInt(Team::getMatchesWon).reversed());
        return ranking;
    }
    public List<Team> getRankingTeamByPoints() {
        List<Team> ranking = this.teamService.getTeams();
        ranking.sort(Comparator.comparingInt(Team::getPoints).reversed());
        return ranking;
    }

    public List<Player> getRankingPlayerByScore() {
        List<Player> ranking = this.playerService.getPlayers();
        ranking.sort(Comparator.comparingInt(Player::getScore).reversed());
        return ranking;
    }

    public List<Player> getRankingPlayerByScoreAndTeamId(String team) {
        List<Player> ranking = this.playerService.getPlayersByTeamId(team);
        ranking.sort(Comparator.comparingInt(Player::getScore).reversed());
        return ranking;
    }
}
