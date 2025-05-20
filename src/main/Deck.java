package main;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {

    private ArrayList<Card> deck = new ArrayList<>();

    public ArrayList<Card> getDeck() {
        return deck;
    }

    public void generateDeckShuffle(){
        generateDeck();
        shuffle();
    }

    public ArrayList<Card> generateDeck() {
        while (deck.size() < 52) {
            while (deck.size() < 12) {
                deck.add(Card.FACECARD);
            }
            deck.add(Card.ACE);
            deck.add(Card.TWO);
            deck.add(Card.THREE);
            deck.add(Card.FOUR);
            deck.add(Card.FIVE);
            deck.add(Card.SIX);
            deck.add(Card.SEVEN);
            deck.add(Card.EIGHT);
            deck.add(Card.NINE);
            deck.add(Card.TEN);
        }
        return deck;
    }

    public void shuffle(){
       Collections.shuffle(deck);
    }
    public void dealCard(){
        deck.remove(0);
        //need to assign card to a hand will need to be updated.
    }

}
