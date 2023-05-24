package app.model;

import java.util.Comparator;

public class Player {
    private String name;
    private PlayerPosition position;
    private int age;
    private int score;
    private String team;

    public Player(String name, PlayerPosition position, int age, int score, String team) {
        this.name = name;
        this.position = position;
        this.age = age;
        this.score = score;
        this.team = team;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PlayerPosition getPosition() {
        return position;
    }

    public void setPosition(PlayerPosition position) {
        this.position = position;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }
}
