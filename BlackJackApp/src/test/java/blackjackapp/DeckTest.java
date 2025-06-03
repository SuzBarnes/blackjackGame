package blackjackapp;

import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;


class DeckTest {
    Deck deck = new Deck();

    @Test
    void testDeckIsCreatedWith52Cards() {
        deck.generateDeck();
        assertEquals(52, deck.getDeck().size());

    }

    @Test
    void testDeckHasTheRightValueCardsAtStartOfGame() {
        deck.generateDeck();

        assertEquals(4, Collections.frequency(deck.getDeck(), Card.ACE));
        assertEquals(4, Collections.frequency(deck.getDeck(), Card.TWO));
        assertEquals(4, Collections.frequency(deck.getDeck(), Card.THREE));
        assertEquals(4, Collections.frequency(deck.getDeck(), Card.FOUR));
        assertEquals(4, Collections.frequency(deck.getDeck(), Card.FIVE));
        assertEquals(4, Collections.frequency(deck.getDeck(), Card.SIX));
        assertEquals(4, Collections.frequency(deck.getDeck(), Card.SEVEN));
        assertEquals(4, Collections.frequency(deck.getDeck(), Card.EIGHT));
        assertEquals(4, Collections.frequency(deck.getDeck(), Card.NINE));
        assertEquals(4, Collections.frequency(deck.getDeck(), Card.TEN));
        assertEquals(12, Collections.frequency(deck.getDeck(), Card.FACECARD));
    }

    @Test
    void aDeckIsShuffled() {
        deck.generateDeck();
        Deck shuffledDeck = new Deck();

        shuffledDeck.generateDeck();
        shuffledDeck.shuffle();

        assertThat(deck.getDeck(), not(equalTo(shuffledDeck.getDeck())));
    }

    @Test
    void aCardIsDealtWhenDealCardMethodUsed(){
        deck.generateDeckShuffle();

        deck.dealInitialHandAndRemoveCardsFromDeck();
        assertEquals(51, deck.getDeck().size());
        deck.dealInitialHandAndRemoveCardsFromDeck();
        assertEquals(50, deck.getDeck().size());
    }

}
