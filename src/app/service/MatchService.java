package app.service;

import app.model.Match;
import app.model.Stadium;
import app.model.Team;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class MatchService {
    private List<Match> listOfMatches;
    private TeamService teamService;

    public MatchService(TeamService teamService){
        this.listOfMatches = new ArrayList<>();
        this.teamService = teamService;
    }

    public Match play(Team firstTeam, Team secondTeam){
        Random random = new Random();
        Match match = new Match();
        match.setFirstTeam(firstTeam);
        match.setSecondTeam(secondTeam);
        Stadium[] stadiums = Stadium.values();
        int randomIndex = random.nextInt(stadiums.length);
        match.setStadium(stadiums[randomIndex]);
        match.setDate(new Date());
        int min=0;
        int max=10;
        int randomNumber1 = random.nextInt(max - min + 1) + min;
        int randomNumber2 = random.nextInt(max - min + 1) + min;

        match.setFirstTeamScored(randomNumber1);
        match.setSecondTeamScored(randomNumber2);
        applyChangesAfterMatch(match);
        return match;
    }
    public void applyChangesAfterMatch(Match match){
        if(match.getFirstTeamScored() == match.getSecondTeamScored()){
            match.getFirstTeam().newMatchesDraw();
            match.getSecondTeam().newMatchesDraw();
            System.out.println("Draw");
        }else if(match.getFirstTeamScored() > match.getSecondTeamScored()){
            match.getFirstTeam().newMatchWon();
            match.getSecondTeam().newMatchLost();
            System.out.println("Win first");
        }else{
            match.getFirstTeam().newMatchLost();
            match.getSecondTeam().newMatchWon();
            System.out.println("Win second");
        }
    }


    public void saveMatch(Match match){
        this.listOfMatches.add(match);
    }

    public void generateFriendlyMatch(){
        List<Team> teamList = this.teamService.getTeams();
        int randomGoalsfirst;
        int randomGoalsSecond;
        Random goalGenerater = new Random();
        if(teamList.size()<2){
            System.out.println("Not enough teams for the start!Add teams.");
        }
        if(teamList.size()==2){
            int min1 = 0;
            int max1=10;

            randomGoalsfirst = goalGenerater.nextInt(max1 - min1 + 1) + min1;
            randomGoalsSecond = goalGenerater.nextInt(max1 - min1 + 1) + min1;
            System.out.println(teamList.get(0).getName() + " - " + teamList.get(1).getName()+" Result: "+randomGoalsfirst+" - "+ randomGoalsSecond);
        }else{
            int minGoals=0;
            int maxGoals=10;
            int minIndex=0;
            int maxIndex = teamList.size()-1;
            randomGoalsfirst = goalGenerater.nextInt(maxGoals - minGoals + 1) + minGoals;
            randomGoalsSecond = goalGenerater.nextInt(maxGoals - minGoals + 1) + minGoals;
            int randomIndexFirst =  goalGenerater.nextInt(maxIndex - minIndex + 1) + minIndex;
            int randomIndexSecond =  goalGenerater.nextInt(maxIndex - minIndex + 1) + minIndex;
            while (randomIndexFirst == randomIndexSecond){
                randomIndexSecond =  goalGenerater.nextInt(maxIndex - minIndex + 1) + minIndex;
            }
            System.out.println(teamList.get(randomIndexFirst).getName() + " - " + teamList.get(randomIndexSecond).getName()+" Result: "+randomGoalsfirst+" - "+ randomGoalsSecond);
        }
    }

    @Override
    public String toString() {
        return "MatchService{" +
                "listOfMatches=" + listOfMatches +
                '}';
    }
}
