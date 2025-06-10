package blackjackapp;

import java.util.ArrayList;

import static java.lang.System.out;

public class Player extends Hand {

    private boolean hasWon = false;

    // every Player starts with 1000 chips
    private double chips = 1000;

    private ArrayList<Hand> hands = new ArrayList<>();

    public Player(ArrayList<Card> cards, int points, int bet, boolean isBust, boolean hasBlackJack, boolean canBeSplit) {
        super(cards, points, bet, isBust, hasBlackJack, canBeSplit);
    }

    public ArrayList<Hand> getHands() {
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

    public void dealPlayerHand(int numberOfHandsForPlayer) {
        hands = new ArrayList<>();

        for (int i = 0; i < numberOfHandsForPlayer; i++) {
            cards = new ArrayList<>();
            hit();
            hit();
            calculatePoints();
            out.println("You have + " + getPoints() + " points.");
            out.println("Player Cards: " + cards);
            doesPlayerHaveBlackJackOrIsBust();
            canBeSplit();
            hands.add(new Hand(cards, getPoints(), getBet(), isBust(), hasBlackJack(), canBeSplit()));
            calculateChipsRemaining(i);
        }
    }

    private void doesPlayerHaveBlackJackOrIsBust() {
        if (hasBlackJack()) {
            out.println("Congratulations. You have BlackJack!");
        }
        if (isBust()) {
            out.println("Player bust.");
            hands.add(new Hand(cards, getPoints(), getBet(), isBust(), hasBlackJack(), canBeSplit()));
        }
    }


public void split() {
    // will  need to have something asking whether to split a hand dealt where the cards are the same. Need the option of saying yes or no.
    // go through each hand in turn to find which cards are matching
    for (int i = 0; i < hands.size(); i++) {
        if (doesHandHave2CardsOfEqualValue(i)) {
            ArrayList<Card> splitCard = new ArrayList<>();
            splitCard.add(hands.get(i).cards.get(0));
            //does the bet double here?
            Hand splitHand = new Hand(splitCard, getPoints(), hands.get(i).getBet(), isBust(), hasBlackJack(), canBeSplit());
            calculateChipsRemaining(i);
            hands.get(i).cards.remove(0);
            hands.add(splitHand);
        }
    }
}

private boolean doesHandHave2CardsOfEqualValue(int i) {
    return hands.get(i).cards.size() == 2 && hands.get(i).cards.get(0) == hands.get(i).cards.get(1);
}

void calculateChipsRemaining(int i){
        chips = chips - getHands().get(i).getBet();
}

}
