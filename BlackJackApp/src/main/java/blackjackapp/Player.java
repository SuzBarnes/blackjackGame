package blackjackapp;

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;

public class Player extends Hand {

    // every Player starts with 1000 chips
    private double chips = 1000;

    private ArrayList<Hand> hands = new ArrayList<>();

    public Player(ArrayList<Card> cards, int points, int bet, boolean hasBlackJack, boolean isBust, boolean canBeSplit) {
        super(cards, points, bet, hasBlackJack, isBust, canBeSplit);
    }

    public List<Hand> getHands() {
        return hands;
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
            hands.add(new Hand(cards, getPoints(), getBet(), hasBlackJack(), isBust(), canBeSplit()));
            calculateChipsRemaining(i);
        }
    }

    public void split() {

        for (int i = 0; i < hands.size(); i++) {
            if (doesHandHave2CardsOfEqualValue(i) && chips >= hands.get(i).getBet()) {
                ArrayList<Card> splitCard = new ArrayList<>();

                splitCard.add(hands.get(i).cards.get(0));

                Hand splitHand = new Hand(splitCard, splitCard.get(0).getPoints(), hands.get(i).getBet(), hasBlackJack(), isBust(), canBeSplit());

                calculateChipsRemaining(i);

                hands.get(i).cards.remove(0);
                hands.add(splitHand);

            } else if (doesHandHave2CardsOfEqualValue(i) && chips < hands.get(i).getBet()) {
                throw new RuntimeException("Sorry, you don't have enough chips to split this time.");
            }
        }
    }

    private boolean doesHandHave2CardsOfEqualValue(int i) {
        return hands.get(i).cards.size() == 2 && hands.get(i).cards.get(0) == hands.get(i).cards.get(1);
    }

    void calculateChipsRemaining(int i) {
        chips = chips - getHands().get(i).getBet();
    }

}
