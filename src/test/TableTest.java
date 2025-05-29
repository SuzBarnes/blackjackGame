package test;

import main.Dealer;
import main.Deck;
import main.Table;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TableTest {
    @Disabled
    @Test
    void tableCanHaveOnePlayer() {

    }
    @Disabled
    @Test
    void tableCanHaveMoreThanOnePlayer() {

    }

    @Test
    void tableHasADealerHand() {
        Table table = new Table(new Dealer(), new Deck());
        table.start(1,1);
        assertEquals(table.getDealer().getHand().size(), 2);

    }

    @Test
    void gameCanBePlayed() {
        Table table = new Table(new Dealer(), new Deck());
        table.start(2, 2);
        assertEquals(table.getPlayers().size(), 2);
        assertEquals(table.getPlayers().get(0).getHands().size(), 2);
        assertEquals(table.getDealer().getHand().size(), 2);
    }

    @Disabled
    @Test
    void ifPlayerHandIsNotBustAndHigherThanDealersPlayerWins() {

    }

    @Disabled
    @Test
    void ifPlayerHandIsNotBustAndHigherThanDealersBetIsDoubledAndReturnedToPlayerChips() {

    }

    @Disabled
    @Test
    void ifPlayerHandIsBustDealerWins() {

    }

    @Disabled
    @Test
    void ifDealerBustPlayerWins() {

    }

    @Disabled
    @Test
    void ifDealerBustPlayerWinsAndWinsDoubleBet() {

    }

    @Disabled
    @Test
    void ifDealerHasBlackJackPlayerLosesBet() {

    }

    @Disabled
    @Test
    void ifPlayerHasBlackJackPlayerWinsOnePointFiveBet() {

    }

    @Disabled
    @Test
    void ifPlayerAndDealerHaveSamePointsPushAndGetBackOriginalBet() {

    }

    @Disabled
    @Test
    void playerCanPlaceDifferentBetsOnDifferentHands() {

    }


    @Test
    void moreThanOnePlayerCanHaveAHandAtATable() {
        Table table = new Table(new Dealer(), new Deck());
        table.start(2, 1);
        assertEquals(table.getPlayers().size(), 2);
    }


    @Test
    void moreThanOnePlayerCanHaveMoreThanOneHandsAtATable() {
        Table table = new Table(new Dealer(), new Deck());
        table.start(2, 2);
        assertEquals(table.getPlayers().size(), 2);
        assertEquals(table.getPlayers().get(0).getHands().size(), 2);
        assertEquals(table.getPlayers().get(1).getHands().size(), 2);

    }

}
