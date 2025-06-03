package blackjackapp;

import org.junit.Test;


import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class HandTest {

    @Test
    public void handIsDealtTwoCards() {
        Hand hand = new Hand();
        Deck deck = new Deck();
        deck.generateDeckShuffle();
        hand.createInitialHand();
        assertEquals(hand.getHand().size(), 2);
    }

    @Test
    public void handCanHaveMoreThanTwoCards() {
        Hand hand = new Hand();
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(Card.FIVE);
        cards.add(Card.FOUR);
        cards.add(Card.TWO);
        hand.setHand(cards);
        assertEquals(hand.getHand().size(), 3);
        cards.add(Card.FOUR);
        hand.setHand(cards);
        assertEquals(hand.getHand().size(), 4);

    }

    @Test
    public void handHasTotalNumberOfPoints() {
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

    @Test
    public void aBetCanBeMade(){
        Hand hand = new Hand();
        hand.setBet(10);
        assertEquals(hand.getBet(), 10);
    }

    @Test
    public void ifHandIsOver21ThePlayerIsBust(){
        Hand hand = new Hand();
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(Card.TEN);
        cards.add(Card.EIGHT);
        hand.setHand(cards);
        assertEquals(hand.isBust(), false);
        cards.add(Card.EIGHT);
        hand.setHand(cards);
        hand.calculatePoints();
        assertEquals(hand.isBust(), true);
    }
    @Test
    public void ifPlayerIsBustWithAnAceAcePointValueIsOne(){
        Hand hand = new Hand();
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(Card.ACE);
        cards.add(Card.EIGHT);
        hand.setHand(cards);
        hand.calculatePoints();
        assertFalse(hand.isBust());
        assertEquals(hand.getPoints(), 19);
        cards.add(Card.EIGHT);
        hand.setHand(cards);
        hand.calculatePoints();
        assertFalse(hand.isBust());
        assertEquals(hand.getPoints(), 17);

    }
    @Test
    public void ifHandIsEqualTo21WithTwoCardsThePlayerHasBlackJack(){
        Hand hand = new Hand();
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(Card.TEN);
        cards.add(Card.ACE);
        hand.setHand(cards);
        hand.calculatePoints();
        System.out.println(hand.isBust());
        System.out.println(cards.get(1).getPoints());
        System.out.println(hand.getPoints() + "isBlackjackPoints");
        System.out.println(hand.getHand().size() + "isBlackjackSize");

        assertTrue(hand.isBlackJack(hand.getPoints(), hand.getHand().size()));
    }
    @Test
    public void ifHandIsNot21WithTwoCardsThePlayerHasNotGotBlackJack(){
        Hand hand = new Hand();
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(Card.FIVE);
        cards.add(Card.ACE);
        hand.setHand(cards);
        hand.calculatePoints();
        assertFalse(hand.isBlackJack(hand.getPoints(), cards.size()));
    }

    @Test
    public void ifHandIsEqualTo21WithThreeCardsThePlayerDoesNotHaveBlackJack(){
        Hand hand = new Hand();
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(Card.TEN);
        cards.add(Card.FIVE);
        cards.add(Card.SIX);
        hand.setHand(cards);
        hand.calculatePoints();
        assertFalse(hand.isBlackJack(hand.getPoints(), cards.size()));
    }
    @Test
    public void ifPlayerHitsACardIsDealt(){
        Hand hand = new Hand();
        Deck deck = new Deck();
        deck.generateDeckShuffle();
        hand.createInitialHand();
        assertEquals(hand.getHand().size(), 2);
        hand.hit(hand.getDeck().get(0));
        assertEquals(hand.getHand().size(), 3);
        hand.hit(hand.getDeck().get(0));
        assertEquals(hand.getHand().size(), 4);
    }

    @Test
    public void ifPlayerHas3AcesScoreShouldBe13(){
        Hand hand = new Hand();
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(Card.ACE);
        cards.add(Card.ACE);
        cards.add(Card.ACE);
        hand.setHand(cards);
        hand.calculatePoints();
        assertFalse(hand.isBust());
        assertEquals(hand.getPoints(), 13);
    }

    @Test
    public void ifPlayerHas4AcesScoreShouldBe14(){
        Hand hand = new Hand();
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(Card.ACE);
        cards.add(Card.ACE);
        cards.add(Card.ACE);
        cards.add(Card.ACE);
        hand.setHand(cards);
        hand.calculatePoints();
        assertFalse(hand.isBust());
        assertEquals(hand.getPoints(), 14);
    }

    @Test
    public void ifPlayerWillBeBustAllSubsequentAcesAreWorthOnePoint(){
        Hand hand = new Hand();
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(Card.ACE);
        cards.add(Card.FIVE);
        cards.add(Card.ACE);
        cards.add(Card.ACE);
        cards.add(Card.ACE);
        hand.setHand(cards);
        hand.calculatePoints();
        assertEquals(hand.getPoints(), 19);
    }

    @Test
    public void ifPlayerWillBeBustWithAnAceAllAcesAreWorthOnePoint(){
        Hand hand = new Hand();
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(Card.ACE);
        cards.add(Card.FIVE);
        cards.add(Card.TEN);
        cards.add(Card.ACE);
        cards.add(Card.ACE);
        hand.setHand(cards);
        hand.calculatePoints();
        assertEquals(hand.getPoints(), 18);
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
