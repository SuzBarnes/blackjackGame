package blackjackapp;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DealerTest {
    @Test
    void aDealerIsDealtIn() {
        Deck deck = new Deck();
        Dealer dealer = new Dealer();
        deck.generateDeckShuffle();
        dealer.setDeck(deck.getDeck(), deck.getCard());
        dealer.dealInDealer();
        assertTrue(!dealer.getHand().isEmpty());
    }

    @Test
    void ifTheDealersScoreIsLessThanOrEqualTo16DrawAnotherCard() {
        ArrayList<Card> cards = new ArrayList<>();
        Dealer dealer = new Dealer();
        cards.add(Card.TEN);
        cards.add(Card.SIX);
        cards.add(Card.ACE);
        dealer.setDeck(cards, cards.get(0));
        dealer.dealInDealer();
        dealer.ifDealerScoreLessThanOrEqualTo16Hit();
        assertEquals(dealer.getHand().size(), 3);
    }

    @Test
    void ifTheDealersScoreIsGreaterThanOrEqualTo17Stand() {
        ArrayList<Card> cards = new ArrayList<>();
        Dealer dealer = new Dealer();
        cards.add(Card.TEN);
        cards.add(Card.TEN);
        cards.add(Card.ACE);
        dealer.setDeck(cards, cards.get(0));
        System.out.println(dealer.getDeck());
        dealer.dealInDealer();
        dealer.ifDealerScoreLessThanOrEqualTo16Hit();
        assertEquals(dealer.getHand().size(), 2);
    }

    @Test
    void ifTheDealerScoreIsGreaterThan21HeIsBust() {
        ArrayList<Card> cards = new ArrayList<>();
        Dealer dealer = new Dealer();
        cards.add(Card.TEN);
        cards.add(Card.SIX);
        cards.add(Card.TEN);
        dealer.setDeck(cards, cards.get(0));
        dealer.dealInDealer();
        dealer.ifDealerScoreLessThanOrEqualTo16Hit();
        assertEquals(dealer.getHand().size(), 3);
        assertEquals(dealer.isBust(), true);

    }

    @Test
    void ifTheDealerScoreIs21WithTwoCardsHeHasBlackJack() {
        ArrayList<Card> cards = new ArrayList<>();
        Dealer dealer = new Dealer();
        cards.add(Card.TEN);
        cards.add(Card.ACE);
        cards.add(Card.TEN);
        dealer.setDeck(cards, cards.get(0));
        dealer.dealInDealer();
        dealer.ifDealerScoreLessThanOrEqualTo16Hit();
        assertEquals(dealer.getHand().size(), 2);
        assertEquals(dealer.isBlackJack(dealer.getPoints(), dealer.getHand().size()), true);

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
