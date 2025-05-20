package test;

import main.Deck;
import main.Hand;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HandTest {
    @Test
    void handIsDealtTwoCards(){
       Hand hand = new Hand();
       assertEquals(hand.getHand().size(), 2);
    }
    @Test
    void handHasTotalNumberOfPoints(){}

    @Test
    void aBetCanBeMade(){}

    @Test
    void ifHandIsOver21ThePlayerIsBust(){}

    @Test
    void ifHandIsEqualTo21WithTwoCardsThePlayerHasBlackJack(){
    }
    @Test
    void ifPlayerHitsACardIsDealt(){
    }
    @Test
    void ifPlayerScoreGreaterThanDealerPlayerWins(){}

    @Test
    void ifPlayerWinsDoubleBetMadeIsReturnedToPlayer(){}

    @Test
    void ifPlayerLosesBetIsLost(){}

    @Test
    void ifPlayerScoreIsLessThanDealerDealerWins(){}

    @Test
    void ifPlayerAndDealerScoreIsTheSamePushAndBetPlacedIsReturned(){}

    @Test
    void ifPlayerIsBustWithAnAceAcePointValueIsOne(){}
}
