package main;

import java.util.ArrayList;
import java.util.Collections;

public class Hand extends Deck {
    ArrayList<Card> hand = new ArrayList<>();

    public int getPoints() {
        return points;
    }

    private int points;

    public int getBet() {
        return bet;
    }

    public void setBet(int bet) {
        this.bet = bet;
    }

    private int bet;

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
        System.out.println(
                "createInitialHand() points: " + points
        );
    }

    public void hit(ArrayList<Card> deck) {
        hand.add(dealCardAndRemoveFromDeck(deck));
        calculatePoints();
        System.out.println(
                "Hit points: " + points
        );
    }

    public void calculatePoints() {
        points = 0;
        //sorting the Cards enum into order so Ace is last:
        Collections.sort(hand);
        for (Card card : hand) {
//
            if (card.isAce() && hand.size() >= 3 && points >10) {
                points = points + card.getPoint();
            } else {
                points = points + card.getPoints();
            }
        }
        isBlackJack(points, hand.size());
        isBust();
    }

    public boolean isBust() {
        return points > 21;
    }

    ;

    public boolean isBlackJack(int points, int numberOfCards) {
        return points == 21 && numberOfCards == 2;
    }



}
