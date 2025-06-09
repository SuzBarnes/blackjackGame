package blackjackapp;

import java.util.ArrayList;
import java.util.Collections;

import static java.lang.System.out;

public class Hand extends Deck {

    ArrayList<Card> cards = new ArrayList<>();
    private int points;
    private int bet;
    private boolean isBust = false;
    private boolean hasBlackJack = false;
    private boolean canBeSplit = false;

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
        out.println("Dealer's cards: " + cards.get(0) + " + X");
        if(hasBlackJack()){
            out.println("Dealer has blackjack.");
        }
    }


    public void hit() {
        dealCardAndRemoveFromDeck();
        cards.add(getCard());
        calculatePoints();
        out.println("Cards: " + cards + "\nPoints: " + points);
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
        hasBlackJack();
        isBust();
    }

    public boolean isBust() {
        if(points > 21){
            isBust = true;
        }
        return isBust;
    }

    public boolean hasBlackJack() {
        if(points == 21 && cards.size() == 2){
            hasBlackJack = true;
        }
        return hasBlackJack;
    }

    public void canBeSplit(){
       if(cards.get(0) == cards.get(1)){
           canBeSplit = true;
       }
    }


}
