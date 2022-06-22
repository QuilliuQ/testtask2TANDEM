package ru.tandemservice.test.model;

public class Player implements Comparable<Player>{

    String name;
    int score;

    public Player(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public void setScore(int score) {
        this.score += score;
    }

    public Player(String name) {
        this.name = name;
        this.score = 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Player other = (Player) obj;
        return name.equals(other.name);
    }

    public boolean containsWithScore(Player player){
        if(!name.equals(player.name)) return false;
        return score == player.score;
    }

    @Override
    public int compareTo(Player o) {
        return Integer.compare(score, o.score);
    }
}
