package main;

import java.util.ArrayList;

public class Hand extends Deck {
    ArrayList<Card> hand = new ArrayList<>();

    public int getPoints() {
        return points;
    }

    private int points;

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

    public void calculatePoints(){
        points = 0;
        for (Card card : hand) {
            points = points + card.getPoints();
        }
    }
    private boolean isBust(int points){
        return points > 21;
    };
    private boolean isBlackJack(int points, int numberOfCards){
        return points == 21 && numberOfCards == 2;
    };


}
