package blackjackapp;

import java.util.ArrayList;

public class Player extends Hand {

    private boolean hasWon = false;

    // every Player starts with 1000 chips
    private double chips = 1000;

    private ArrayList<ArrayList<Card>> hands = new ArrayList<>();

    public ArrayList<ArrayList<Card>> getHands() {
        return hands;
    }

    public void setHasWon(boolean hasWon) {
        this.hasWon = hasWon;
    }

    public boolean isHasWon() {
        return hasWon;
    }
    public double getChips() {
        return chips;
    }
    public void setChips(double chips) {
        this.chips = chips;
    }

    public void dealPlayerHand(int numberOfHandsToDeal) {
            hands = new ArrayList<>();
        for (int i = 0; i < numberOfHandsToDeal; i++) {
            cards = new ArrayList<>();
            hit();
            hit();
            calculatePoints();
            hands.add(getCards());
        }
    }

    public void split() {
        // will  need to have something asking whether to split a hand dealt where the cards are the same. Need the option of saying yes or no.
        // go through each hand in turn to find which cards are matching
        for (int i = 0; i < hands.size(); i++) {
            if (doesHandHave2CardsOfEqualValue(i)) {
                ArrayList<Card> splitHand = new ArrayList<>();
                splitHand.add(hands.get(i).get(0));
                hands.get(i).remove(0);
                hands.add(splitHand);
            }
        }
    }

    private boolean doesHandHave2CardsOfEqualValue(int i) {
        return hands.get(i).size() == 2 && hands.get(i).get(0) == hands.get(i).get(1);
    }

    public void bet(int value) {
        chips = chips - value;
    }


}
