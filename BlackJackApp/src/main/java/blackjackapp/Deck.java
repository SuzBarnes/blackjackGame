package blackjackapp;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private ArrayList<Card> deck = new ArrayList<>();
    private Card card;
    public ArrayList<Card> getDeck() {
        return deck;
    }

    public void setDeck(ArrayList<Card> deck, Card card) {
        this.deck = deck;
        this.card = card;
    }
    public void setCard(Card card){
        this.card = card;
    }

    public Card getCard(){
        return card;
    }

    public void generateDeckShuffle() {
        generateDeck();
        shuffle();
        setCard(getDeck().get(0));
    }

    public void generateDeck() {
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
    }

    public void shuffle() {
        Collections.shuffle(deck);
    }

    public Card dealInitialHandAndRemoveCardsFromDeck() {
        ifDeckNeedsToBeCreatedOrReplenished();
        Card cardName = Card.valueOf(card.name());
        deck.remove(card);
        setCard(deck.get(0));
        setDeck(deck, card);
        return cardName;
    }

    public void dealCardAndRemoveFromDeck() {
        setCard(deck.get(0));
        deck.remove(0);
        setDeck(deck, card);
    }


    private void ifDeckNeedsToBeCreatedOrReplenished() {
        if (deck.isEmpty()) {
            generateDeckShuffle();
        }
    }
}
