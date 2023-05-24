package app.service;

import app.model.Team;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TeamService {
    public final List<Team> teams;

    public TeamService() {
        this.teams = new ArrayList<>();
    }

    public void addTeam(Team team) {
        this.teams.add(team);
    }

    public List<Team> getTeams() {
        return this.teams;
    }

    public Team getTeamByName(String name) {
        return this.teams.stream()
                .filter(team -> team.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    @Override
    public String toString() {
        return "TeamService{" +
                "teams=" + teams +
                '}';
    }
}
