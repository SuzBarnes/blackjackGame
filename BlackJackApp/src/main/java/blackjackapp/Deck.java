package blackjackapp;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private ArrayList<Card> deck = new ArrayList<>();

    public ArrayList<Card> getDeck() {
        return deck;
    }
    public void setDeck(ArrayList<Card> deck) {
        this.deck = deck;
    }


    public void generateDeckShuffle() {
        generateDeck();
        shuffle();
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
        Card card = getDeck().get(0);
        Card cardName = Card.valueOf(card.name());
        deck.remove(card);
        return cardName;
    }

    public Card dealCardAndRemoveFromDeck(Card card) {
        deck.remove(0);
        setDeck(deck);
        return card;
    }


    private void ifDeckNeedsToBeCreatedOrReplenished() {
        if (deck.isEmpty()) {
            generateDeckShuffle();
        }
    }
}
