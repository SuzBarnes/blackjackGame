package test;

import org.junit.jupiter.api.Test;

public class DealerTest {
    @Test
    void aDealerIsDealt2CardsAtStartOfHand(){}

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
