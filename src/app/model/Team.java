package app.model;

public class Team {
    private String name;
    private String country;
    private int matchesPlayed;
    private int matchesWon;
    private int matchesLost;

    private int matchesDraw;

    private int points;
    public Team(String name, String country, int matchesPlayed, int matchesWon, int matchesLost) {
        this.name = name;
        this.country = country;
        this.matchesPlayed = matchesPlayed;
        this.matchesWon = matchesWon;
        this.matchesLost = matchesLost;
        this.matchesDraw = Math.abs(matchesPlayed-(matchesWon+matchesLost));
        this.points = 3*this.matchesWon+this.matchesDraw;

    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getMatchesPlayed() {
        return matchesPlayed;
    }

    public void setMatchesPlayed(int matchesPlayed) {
        this.matchesPlayed = matchesPlayed;
    }

    public int getMatchesWon() {
        return matchesWon;
    }

    public void newMatchWon(){
        this.matchesWon++;
        this.matchesPlayed++;
        this.points+=3;
    }

    public void setMatchesWon(int matchesWon) {
        this.matchesWon = matchesWon;
        this.points=3*matchesWon;

    }

    public int getMatchesLost() {
        return matchesLost;
    }

    public void newMatchLost(){
        this.matchesLost++;
        this.matchesPlayed++;

    }

    public void setMatchesLost(int matchesLost) {
        this.matchesLost = matchesLost;
    }

    public int getMatchesDraw(){
        return this.matchesDraw;

    }
    public void newMatchesDraw(){
        this.matchesPlayed++;
        this.matchesDraw++;
        this.points+=1;
    }

    @Override
    public String toString() {
        return "Team{" +
                "name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", matchesPlayed=" + matchesPlayed +
                ", matchesWon=" + matchesWon +
                ", matchesLost=" + matchesLost +
                ", matchesDraw=" + matchesDraw +
                ", points=" + points +
                '}';
    }
}

