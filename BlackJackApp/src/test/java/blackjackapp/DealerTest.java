package blackjackapp;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class DealerTest {
    Deck deck = new Deck();

    Dealer dealer = new Dealer(new ArrayList<>(), 0, 0, false, false, false);
    ArrayList<Card> cards = new ArrayList<>();

    @Test
    void aDealerIsDealtIn() {
        deck.generateDeckShuffle();
        dealer.setDeck(deck.getDeck(), deck.getCard());
        dealer.dealInDealer();

        assertFalse(dealer.getCards().isEmpty());
    }

    @Test
    void ifTheDealersScoreIsLessThanOrEqualTo16DrawAnotherCard() {
        cards.add(Card.TEN);
        cards.add(Card.SIX);
        cards.add(Card.ACE);
        dealer.setDeck(cards, cards.get(0));

        dealer.dealInDealer();

        assertEquals(3, dealer.getCards().size());
    }

    @Test
    void ifTheDealersScoreIsGreaterThanOrEqualTo17Stand() {
        cards.add(Card.TEN);
        cards.add(Card.TEN);
        cards.add(Card.ACE);
        dealer.setDeck(cards, cards.get(0));

        dealer.dealInDealer();

        assertEquals(2, dealer.getCards().size());
    }

    @Test
    void ifTheDealerScoreIsGreaterThan21HeIsBust() {
        cards.add(Card.TEN);
        cards.add(Card.SIX);
        cards.add(Card.TEN);
        dealer.setDeck(cards, cards.get(0));

        dealer.dealInDealer();

        assertEquals(3, dealer.getCards().size());
        assertTrue(dealer.isBust());

    }

    @Test
    void ifTheDealerScoreIs21WithTwoCardsHeHasBlackJack() {
        cards.add(Card.TEN);
        cards.add(Card.ACE);
        cards.add(Card.TEN);
        dealer.setDeck(cards, cards.get(0));

        dealer.dealInDealer();

        dealer.ifDealerScoreLessThanOrEqualTo16Hit();
        assertEquals(2, dealer.getCards().size());
        assertEquals(true, dealer.hasBlackJack());

    }

    @Disabled
    @Test
    void ifTheDealerScoreIsEqualTo21AndPlayerIsLessDealerWins() {
    }

    @Disabled
    @Test
    void ifTheDealerScoreIsEqualToPlayerScoreItIsPush() {
    }

}
