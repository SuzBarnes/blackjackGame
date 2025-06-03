package blackjackapp;

public enum Card {

    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    TEN(10),
    FACECARD(10),
    ACE(11, 1,true);


    private int points;
    private int point;
    private boolean ace;


    Card(int points, int point, boolean isAce) {
        this.points = points;
        this.point = point;
        this.ace = isAce;
    }

    Card(int points) {
        this.points = points;
    }
    public boolean isAce(){
        return ace;
    }
    public int getPoints(){
        return points;
    }
    public int getPoint(){
        return point;
    }

}