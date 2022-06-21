package ru.tandemservice.test.model;

public record Player(
        String name,
        int score
) implements Comparable<Player>{

    @Override
    public int compareTo(Player o) {
        return Integer.compare(score, o.score);
    }
}
