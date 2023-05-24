package app.model;

import java.util.Date;

public class Match {
    private Team firstTeam;
    private Team secondTeam;
    private Stadium stadium;
    private Date date;
    private int firstTeamScored;
    private int secondTeamScored;

    public Match(){

    }

    public Match(Team firstTeam, Team secondTeam, Stadium stadium, Date date) {
        this.firstTeam = firstTeam;
        this.secondTeam = secondTeam;
        this.stadium = stadium;
        this.date = date;
    }

    public Team getFirstTeam() {
        return firstTeam;
    }

    public void setFirstTeam(Team firstTeam) {
        this.firstTeam = firstTeam;
    }

    public Team getSecondTeam() {
        return secondTeam;
    }

    public void setSecondTeam(Team secondTeam) {
        this.secondTeam = secondTeam;
    }

    public Stadium getStadium() {
        return stadium;
    }

    public void setStadium(Stadium stadium) {
        this.stadium = stadium;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getFirstTeamScored() {
        return firstTeamScored;
    }

    public void setFirstTeamScored(int firstTeamScored) {
        this.firstTeamScored = firstTeamScored;
    }

    public int getSecondTeamScored() {
        return secondTeamScored;
    }

    public void setSecondTeamScored(int secondTeamScored) {
        this.secondTeamScored = secondTeamScored;
    }

    @Override
    public String toString() {
        return "Match{" +
                "firstTeam=" + firstTeam.getName() +
                ", secondTeam=" + secondTeam.getName() +
                ", stadium='" + stadium + '\'' +
                ", date=" + date +
                ", firstTeamScored=" + firstTeamScored +
                ", secondTeamScored=" + secondTeamScored +
                '}';
    }
}
