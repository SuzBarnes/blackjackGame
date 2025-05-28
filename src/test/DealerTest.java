package test;

import main.Card;
import main.Dealer;
import main.Deck;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DealerTest {
    @Test
    void aDealerIsDealt2CardsAtStartOfHand(){
        Deck deck = new Deck();
        Dealer dealer = new Dealer();
        deck.generateDeckShuffle();
        dealer.dealInDealer();
        assertEquals(dealer.getHand().size(), 2);
    }

    @Test
    void ifTheDealersScoreIsLessThanOrEqualTo16DrawAnotherCard(){
        ArrayList<Card> cards = new ArrayList<>();
        Dealer dealer = new Dealer();
        cards.add(Card.TEN);
        cards.add(Card.SIX);
        cards.add(Card.ACE);
        dealer.setDeck(cards);
        dealer.dealInDealer();
        dealer.ifDealerScoreLessThanOrEqualTo16Hit();
        assertEquals(dealer.getHand().size(), 3);
    }

    @Test
    void ifTheDealersScoreIsGreaterThanOrEqualTo17Stand(){
        ArrayList<Card> cards = new ArrayList<>();
        Dealer dealer = new Dealer();
        cards.add(Card.TEN);
        cards.add(Card.TEN);
        cards.add(Card.ACE);
        dealer.setDeck(cards);
        dealer.dealInDealer();
        dealer.ifDealerScoreLessThanOrEqualTo16Hit();
        assertEquals(dealer.getHand().size(), 2);
    }

    @Test
    void ifTheDealerScoreIsGreaterThan21HeIsBust(){
        ArrayList<Card> cards = new ArrayList<>();
        Dealer dealer = new Dealer();
        cards.add(Card.TEN);
        cards.add(Card.SIX);
        cards.add(Card.TEN);
        dealer.setDeck(cards);
        dealer.dealInDealer();
        dealer.ifDealerScoreLessThanOrEqualTo16Hit();
        assertEquals(dealer.getHand().size(), 3);
        assertEquals(dealer.isBust(), true);

    }

    @Test
    void ifTheDealerScoreIs21WithTwoCardsHeHasBlackJack(){
        ArrayList<Card> cards = new ArrayList<>();
        Dealer dealer = new Dealer();
        cards.add(Card.TEN);
        cards.add(Card.ACE);
        cards.add(Card.TEN);
        dealer.setDeck(cards);
        dealer.dealInDealer();
        dealer.ifDealerScoreLessThanOrEqualTo16Hit();
        assertEquals(dealer.getHand().size(), 2);
        assertEquals(dealer.isBlackJack(dealer.getPoints(), dealer.getHand().size()), true);

    }

    @Test
    void ifTheDealerScoreIsEqualTo21AndPlayerIsLessDealerWins(){}

    @Test
    void ifTheDealerScoreIsEqualToPlayerScoreItIsPush(){}

}
