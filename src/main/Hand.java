package main;

import java.util.ArrayList;

public class Hand extends Deck {

    ArrayList<Card> cards = new ArrayList<>();
    Hand hand = new Hand();

    public Hand getHand() {
        return hand;
    }

    private int points;

    private int bet;
    private boolean isBust(int points){
        return points > 21;
    };
    private boolean isBlackJack(int points, int numberOfCards){
        return points == 21 && numberOfCards == 2;
    };

    private int points(Card card){
        int points = 0;
        hand.cards
    }

    public int getBet() {
        return bet;
    }

    public void setBet(int bet) {
        this.bet = bet;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }

    public Hand() {
        Deck deck = new Deck();
        deck.generateDeckShuffle();
        deck.dealCard();
        deck.dealCard();
    }

    public void hit(){
        cards.add();
    }
}
