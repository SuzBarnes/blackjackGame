package main;

import java.util.ArrayList;

public class Hand extends Deck {
    ArrayList<Card> hand = new ArrayList<>();


    public ArrayList<Card> getHand() {
        return hand;
    }


//    public void hand(Deck deck) {
//        Hand hand = new Hand();
//        var removedCard = deck.getDeck().get(0).name();
//        hand.getHand().add(Card.valueOf(removedCard));
//        dealCard();
//    }

    public void createInitialHand() {
        hand.add(dealCardAndRemoveFromDeck());
        System.out.println(getHand());
        System.out.println(hand.get(0));
        hand.add(dealCardAndRemoveFromDeck());

    }

    private int points;

    private int bet;
    private boolean isBust(int points){
        return points > 21;
    };
    private boolean isBlackJack(int points, int numberOfCards){
        return points == 21 && numberOfCards == 2;
    };

//    private int points(Card card){
//        int points = 0;
//        hand.cards
//    };

    public int getBet() {
        return bet;
    }

    public void setBet(int bet) {
        this.bet = bet;
    }

    public void hit(){
//        cards.add();
    }
}
