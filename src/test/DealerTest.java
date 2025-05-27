package test;

import main.Dealer;
import main.Deck;
import main.Hand;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DealerTest {
    @Test
    void aDealerIsDealt2CardsAtStartOfHand(){
        Dealer dealer = new Dealer();
        dealer.dealInDealer();
        assertEquals(dealer.getHand().size(), 2);
    }

    @Test
    void ifTheDealersScoreIsLessThanOrEqualTo16DrawAnotherCard(){}

    @Test
    void ifTheDealersScoreIsGreaterThanOrEqualTo17Stand(){}

    @Test
    void ifTheDealerScoreIsGreaterThan21HeIsBust(){}

    @Test
    void ifTheDealerScoreIs21WithTwoCardsHeHasBlackJack(){}

    @Test
    void ifTheDealerScoreIsEqualTo21AndPlayerIsLessDealerWins(){}

    @Test
    void ifTheDealerScoreIsEqualToPlayerScoreItIsPush(){}

}
