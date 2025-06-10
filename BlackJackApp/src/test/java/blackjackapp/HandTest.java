package blackjackapp;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;


import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class HandTest {

    Deck deck = new Deck();
    ArrayList<Card> cards = new ArrayList<>();
    Hand hand = new Hand( cards, 0, 0, false, false,false);

    @Test
    public void handIsDealtTwoCards() {
        deck.generateDeckShuffle();
        hand.createInitialHand();
        assertEquals(2, hand.getCards().size());
    }

    @Test
    public void handCanHaveMoreThanTwoCards() {
        cards.add(Card.FIVE);
        cards.add(Card.FOUR);
        cards.add(Card.TWO);
        hand.setCards(cards);

        assertEquals(3, hand.getCards().size());

        cards.add(Card.FOUR);
        hand.setCards(cards);

        assertEquals(4, hand.getCards().size());

    }

    @Test
    public void handHasTotalNumberOfPoints() {
        cards.add(Card.ACE);
        cards.add(Card.EIGHT);
        hand.setCards(cards);
        hand.calculatePoints();
        assertEquals(19, hand.getPoints());

        Hand hand2 = new Hand( cards, 0, 0, false, false,false);
        ArrayList<Card> cards2 = new ArrayList<>();
        cards2.add(Card.ACE);
        cards2.add(Card.SIX);
        cards2.add(Card.TWO);
        hand2.setCards(cards2);
        hand2.calculatePoints();
        assertEquals(19, hand2.getPoints());
    }

    @Test
    public void aBetCanBeMade(){
        hand.setBet(10);
        assertEquals(10, hand.getBet());
    }

    @Test
    public void ifHandIsOver21ThePlayerIsBust(){
        cards.add(Card.TEN);
        cards.add(Card.EIGHT);
        hand.setCards(cards);

        assertFalse(hand.isBust());

        cards.add(Card.EIGHT);
        hand.setCards(cards);
        hand.calculatePoints();

        assertTrue(hand.isBust());
    }
    @Test
    public void ifPlayerIsBustWithAnAceAcePointValueIsOne(){
        cards.add(Card.ACE);
        cards.add(Card.EIGHT);
        hand.setCards(cards);
        hand.calculatePoints();

        assertFalse(hand.isBust());
        assertEquals(19, hand.getPoints());

        cards.add(Card.EIGHT);
        hand.setCards(cards);
        hand.calculatePoints();

        assertFalse(hand.isBust());
        assertEquals(17, hand.getPoints());

    }
    @Test
    public void ifHandIsEqualTo21WithTwoCardsThePlayerHasBlackJack(){
        cards.add(Card.TEN);
        cards.add(Card.ACE);
        hand.setCards(cards);
        hand.calculatePoints();

        assertTrue(hand.hasBlackJack());
    }
    @Test
    public void ifHandIsNot21WithTwoCardsThePlayerHasNotGotBlackJack(){
        cards.add(Card.FIVE);
        cards.add(Card.ACE);
        hand.setCards(cards);
        hand.calculatePoints();

        assertFalse(hand.hasBlackJack());
    }

    @Test
    public void ifHandIsEqualTo21WithThreeCardsThePlayerDoesNotHaveBlackJack(){
        cards.add(Card.TEN);
        cards.add(Card.FIVE);
        cards.add(Card.SIX);
        hand.setCards(cards);
        hand.calculatePoints();

        assertFalse(hand.hasBlackJack());
    }
    @Test
    public void ifPlayerHitsACardIsDealt(){
        deck.generateDeckShuffle();
        hand.createInitialHand();

        assertEquals(2, hand.getCards().size());

        hand.hit();
        assertEquals(3, hand.getCards().size());

        hand.hit();
        assertEquals(4, hand.getCards().size());
    }

    @Test
    public void ifPlayerHas3AcesScoreShouldBe13(){
        cards.add(Card.ACE);
        cards.add(Card.ACE);
        cards.add(Card.ACE);
        hand.setCards(cards);
        hand.calculatePoints();

        assertFalse(hand.isBust());
        assertEquals(13, hand.getPoints());
    }

    @Test
    public void ifPlayerHas4AcesScoreShouldBe14(){
        cards.add(Card.ACE);
        cards.add(Card.ACE);
        cards.add(Card.ACE);
        cards.add(Card.ACE);
        hand.setCards(cards);
        hand.calculatePoints();

        assertFalse(hand.isBust());
        assertEquals(14, hand.getPoints());
    }

    @Test
    public void ifPlayerWillBeBustAllSubsequentAcesAreWorthOnePoint(){
        cards.add(Card.ACE);
        cards.add(Card.FIVE);
        cards.add(Card.ACE);
        cards.add(Card.ACE);
        cards.add(Card.ACE);
        hand.setCards(cards);
        hand.calculatePoints();

        assertEquals(19, hand.getPoints());
    }

    @Test
    public void ifPlayerWillBeBustWithAnAceAllAcesAreWorthOnePoint(){
        cards.add(Card.ACE);
        cards.add(Card.FIVE);
        cards.add(Card.TEN);
        cards.add(Card.ACE);
        cards.add(Card.ACE);
        hand.setCards(cards);
        hand.calculatePoints();

        assertEquals(18, hand.getPoints());
    }

//    @Test
//    void ifPlayerWinsWithBlackJackReturnDoubleTheBet(){
//
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
}
