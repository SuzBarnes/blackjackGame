package test;

import main.Card;
import main.Deck;
import main.Hand;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HandTest {
    @Test
    void handIsDealtTwoCards() {
        Hand hand = new Hand();
        Deck deck = new Deck();
        deck.generateDeckShuffle();
        hand.createInitialHand();
        assertEquals(hand.getHand().size(), 2);
    }

    @Test
    void handCanHaveMoreThanTwoCards() {
        Hand hand = new Hand();
        hand.createInitialHand();
        hand.hit(hand.getDeck());
        assertEquals(hand.getHand().size(), 3);
        hand.hit(hand.getDeck());
        assertEquals(hand.getHand().size(), 4);

    }

    @Test
    void handHasTotalNumberOfPoints() {
        Hand hand1 = new Hand();
        ArrayList<Card> cards1 = new ArrayList<>();
        cards1.add(Card.ACE);
        cards1.add(Card.EIGHT);
        hand1.setHand(cards1);
        hand1.calculatePoints();
        assertEquals(hand1.getPoints(), 19);

        Hand hand2 = new Hand();
        ArrayList<Card> cards2 = new ArrayList<>();
        cards2.add(Card.ACE);
        cards2.add(Card.SIX);
        cards2.add(Card.TWO);
        hand2.setHand(cards2);
        hand2.calculatePoints();
        assertEquals(hand2.getPoints(), 19);
    }
//
//    @Test
//    void aBetCanBeMade(){}
//
//    @Test
//    void ifHandIsOver21ThePlayerIsBust(){}
//
//    @Test
//    void ifHandIsEqualTo21WithTwoCardsThePlayerHasBlackJack(){
//    }
//    @Test
//    void ifPlayerHitsACardIsDealt(){
//    }
//    @Test
//    void ifPlayerScoreGreaterThanDealerPlayerWins(){}
//
//    @Test
//    void ifPlayerWinsDoubleBetMadeIsReturnedToPlayer(){}
//
//    @Test
//    void ifPlayerLosesBetIsLost(){}
//
//    @Test
//    void ifPlayerScoreIsLessThanDealerDealerWins(){}
//
//    @Test
//    void ifPlayerAndDealerScoreIsTheSamePushAndBetPlacedIsReturned(){}
//
//    @Test
//    void ifPlayerIsBustWithAnAceAcePointValueIsOne(){}
}
