package blackjackapp;

import java.util.ArrayList;
import java.util.Collections;

public class Hand extends Deck {

    ArrayList<Card> cards = new ArrayList<>();
    private int points;
    private int bet;
    private boolean isBust = false;
    private boolean hasBlackJack = false;

    public void setPoints(int points) {
        this.points = points;
    }

    public int getPoints() {
        return points;
    }

    public int getBet() {
        return bet;
    }

    public void setBet(int bet) {
        this.bet = bet;
    }

    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void createInitialHand() {
        setBet(bet);
        cards.add(dealInitialHandAndRemoveCardsFromDeck());
        cards.add(dealInitialHandAndRemoveCardsFromDeck());
        calculatePoints();
        setDeck(getDeck(), getCard());
    }


    public void hit() {
        dealCardAndRemoveFromDeck();
        cards.add(getCard());
        calculatePoints();
    }

    public void calculatePoints() {
        points = 0;
        Collections.sort(cards);
        for (Card card : cards) {

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
        hasBlackJack();
        isBust();
    }

    public boolean isBust() {
        if(points > 21){
            isBust = true;
            points = 0;
        }
        return isBust;
    }

    public boolean hasBlackJack() {
        if(points == 21 && cards.size() == 2){
            hasBlackJack = true;
        }
        return hasBlackJack;
    }


}
