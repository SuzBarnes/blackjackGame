package blackjackapp;

import java.util.ArrayList;
import java.util.Collections;

public class Hand extends Deck {
    ArrayList<Card> hand = new ArrayList<>();
    private int points;
    private int bet;
    private boolean isBust = false;

    public int getPoints() {
        return points;
    }

    public int getBet() {
        return bet;
    }

    public void setBet(int bet) {
        this.bet = bet;
    }

    public void setHand(ArrayList<Card> hand) {
        this.hand = hand;
    }

    public ArrayList<Card> getHand() {
        return hand;
    }


    public void createInitialHand() {
        hand.add(dealInitialHandAndRemoveCardsFromDeck());
        hand.add(dealInitialHandAndRemoveCardsFromDeck());
        calculatePoints();
        setDeck(getDeck(), getCard());
    }


    public void hit() {
        dealCardAndRemoveFromDeck();
        hand.add(getCard());
        calculatePoints();
    }

    public void calculatePoints() {
        points = 0;
        Collections.sort(hand);
        for (Card card : hand) {

            if (card.isAce()) {
                if (points > 10) {
                    points = points + card.getPoint();
                } else {
                    points = points + card.getPoints();
                }

            }
                else {
                    points = points + card.getPoints();
                }
        }
        isBlackJack(points, hand.size());
        isBust();
    }

    public boolean isBust() {
        if(points > 21){
            isBust = true;
        }
        return isBust;
    }

    public boolean isBlackJack(int points, int numberOfCards) {
        return points == 21 && numberOfCards == 2;
    }


}
