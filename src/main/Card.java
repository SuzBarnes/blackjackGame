package main;

public enum Card {
    ACE(11, 1,true),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    TEN(10),
    FACECARD(10);;

    Card(int high, int low, boolean isAce) {
    }

    Card(int i) {
    }

}