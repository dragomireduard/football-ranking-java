package app;


import app.model.Match;
import app.model.Player;
import app.model.PlayerPosition;
import app.model.Team;
import app.service.MatchService;
import app.service.PlayerService;
import app.service.RankingService;
import app.service.TeamService;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        TeamService teamService = new TeamService();
        PlayerService playerService = new PlayerService();
        RankingService rankingService = new RankingService(teamService, playerService);

        Team juventus = new Team("Juventus", "Italy", 0, 0, 0);
        teamService.addTeam(juventus);
        Team roma = new Team("Roma", "Italy", 0, 0, 0);
        teamService.addTeam(roma);
        Team inter = new Team("Inter", "Italy", 0, 0, 0);
        teamService.addTeam(inter);

        Player ronaldo = new Player("Ronaldo", PlayerPosition.FORWARD, 36, 100, juventus.getName());
        Player messi = new Player("Messi", PlayerPosition.FORWARD, 31, 23, "PSG");
        Player neymar = new Player("Neymar", PlayerPosition.FORWARD, 39, 42, "PSG");
        Player mbappe = new Player("Mbappe", PlayerPosition.FORWARD, 21, 32, "Juventus");
        Player pogba = new Player("Pogba", PlayerPosition.MIDFILDER, 28, 12, "Juventus");
        Player kante = new Player("Kante", PlayerPosition.MIDFILDER, 30, 15, "Juventus");
        Player hazard = new Player("Hazard", PlayerPosition.FORWARD, 29, 18, "Juventus");
        Player deBruyne = new Player("De Bruyne", PlayerPosition.FORWARD, 30, 20, "Juventus");
        Player ramos = new Player("Ramos", PlayerPosition.DEFENDER, 35, 5, "Juventus");

        playerService.addPlayer(ronaldo);
        playerService.addPlayer(messi);
        playerService.addPlayer(neymar);
        playerService.addPlayer(mbappe);
        playerService.addPlayer(pogba);
        playerService.addPlayer(kante);
        playerService.addPlayer(hazard);
        playerService.addPlayer(deBruyne);
        playerService.addPlayer(ramos);


        MatchService matchService = new MatchService(teamService);
        Match game = matchService.play(roma , juventus);
        Match game2 = matchService.play(roma , inter);
        Match game3 = matchService.play(inter , juventus);
        Match game4 = matchService.play(inter , roma);
        Match game5 = matchService.play(juventus,inter);
        Match game6 = matchService.play(juventus,roma);
        matchService.saveMatch(game);
        matchService.saveMatch(game2);
        matchService.saveMatch(game3);
        matchService.saveMatch(game4);
        matchService.saveMatch(game5);
        matchService.saveMatch(game6);
        System.out.println(teamService);

        RankingService rankingService1 = new RankingService(teamService , playerService);
        List<Team> ranking = rankingService1.getRankingTeamByPoints();
        for(Team team : ranking){
            System.out.println(team);
        }

        System.out.println(matchService);
//        List<Player> ranking = rankingService.getRankingPlayerByScore();
//        for (int i = 0; i < ranking.size(); i++) {
//            System.out.println(i+1 + ". " + ranking.get(i).getName() + " - Score: " + ranking.get(i).getScore());
//        }getScore


    }
}