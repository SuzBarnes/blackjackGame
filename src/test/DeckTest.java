package test;

import main.Card;
import main.Deck;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;


class DeckTest {

    @Test
    void testDeckIsCreatedWith52Cards() {
        var deck = new Deck();
        System.out.println("Before generateDeck(): " + deck);
        deck.generateDeck();
        System.out.println("After generateDeck(): " + deck);
        assertEquals(deck.getDeck().size(), 52);

    }

    @Test
    void testDeckHasTheRightValueCardsAtStartOfGame() {
        var deck = new Deck();
        deck.generateDeck();


        assertEquals(Collections.frequency(deck.getDeck(), Card.ACE), 4);
        assertEquals(Collections.frequency(deck.getDeck(), Card.TWO), 4);
        assertEquals(Collections.frequency(deck.getDeck(), Card.THREE), 4);
        assertEquals(Collections.frequency(deck.getDeck(), Card.FOUR), 4);
        assertEquals(Collections.frequency(deck.getDeck(), Card.FIVE), 4);
        assertEquals(Collections.frequency(deck.getDeck(), Card.SIX), 4);
        assertEquals(Collections.frequency(deck.getDeck(), Card.SEVEN), 4);
        assertEquals(Collections.frequency(deck.getDeck(), Card.EIGHT), 4);
        assertEquals(Collections.frequency(deck.getDeck(), Card.NINE), 4);
        assertEquals(Collections.frequency(deck.getDeck(), Card.TEN), 4);
        assertEquals(Collections.frequency(deck.getDeck(), Card.FACECARD), 12);


    }

    @Test
    void aDeckIsShuffled() {
        Deck deck = new Deck();
        deck.generateDeck();
        Deck shuffledDeck = new Deck();
        shuffledDeck.generateDeck();
        shuffledDeck.shuffle();

        assertThat(deck.getDeck(), not(equalTo(shuffledDeck.getDeck())));
    }

    @Test
    void aCardIsDealtWhenDealCardMethodUsed(){
        Deck deck = new Deck();
        deck.generateDeck();
        deck.shuffle();

        deck.dealCardAndRemoveFromDeck();
        assertEquals(deck.getDeck().size(), 51);
        deck.dealCardAndRemoveFromDeck();
        assertEquals(deck.getDeck().size(), 50);

    }



}
