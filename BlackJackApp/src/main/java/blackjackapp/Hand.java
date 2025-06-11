package blackjackapp;

import java.util.ArrayList;
import java.util.Collections;

public class Hand extends Deck {
    public Hand(ArrayList<Card> cards, int points, int bet, boolean hasBlackJack, boolean isBust, boolean canBeSplit) {
        this.cards = cards;
        this.points = points;
        this.bet = bet;
        this.hasBlackJack = hasBlackJack;
        this.isBust = isBust;
        this.canBeSplit = canBeSplit;
    }

    ArrayList<Card> cards = new ArrayList<>();
    private int points;
    private int bet;
    private boolean isBust = false;
    private boolean hasBlackJack = false;
    private boolean canBeSplit = false;
    private boolean hasWon = false;

    public void setPoints(int points) {
        this.points = points;
    }

    public void setBust(boolean bust) {
        isBust = bust;
    }

    public void setHasBlackJack(boolean hasBlackJack) {
        this.hasBlackJack = hasBlackJack;
    }

    public void setCanBeSplit(boolean canBeSplit) {
        this.canBeSplit = canBeSplit;
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
        setBet(bet);

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
        setPoints(points);
        canBeSplit();
        hasBlackJack();
        isBust();
    }

    public boolean isBust() {
        if(points > 21){
            setBust(true);
            setHasWon(false);
        }
        return isBust;
    }

    public boolean hasBlackJack() {
        if(points == 21 && cards.size() == 2){
            setHasBlackJack(true);
        }
        return hasBlackJack;
    }

    public boolean canBeSplit(){
       if(cards.size() == 2 && cards.get(0) == cards.get(1)){
           setCanBeSplit(true);
       }
       return canBeSplit;
    }

    public void setHasWon(boolean hasWon) {
        this.hasWon = hasWon;
    }

    public boolean isHasWon() {
        return hasWon;
    }

}
