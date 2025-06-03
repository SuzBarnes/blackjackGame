package blackjackapp;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    void ifPlayerHandIsNotBustAndHigherThanDealersPlayerWins() {
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(Card.TEN);
        cards.add(Card.EIGHT);
        cards.add(Card.ACE);
        cards.add(Card.NINE);
        Deck deck = new Deck();
        Dealer dealer = new Dealer();
        dealer.setDeck(cards);
        deck.setDeck(dealer.getDeck());
        Table table = new Table(dealer, deck);
        table.start(1, 1);
        assertEquals(table.getPlayers().size(), 1);
        assertEquals(table.getPlayers().get(0).getHands().size(), 1);
        assertEquals(table.getDealer().getHand().size(), 2);
        assertFalse(table.getPlayer().isBust());
        assertTrue(table.doesPlayerWin());
    }

    @Test
    void ifPlayerHandIsNotBustTheSamePointsAsDealerDoesPlayerWinReturnsFalse() {
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(Card.TEN);
        cards.add(Card.TEN);
        cards.add(Card.ACE);
        cards.add(Card.NINE);
        Deck deck = new Deck();
        Dealer dealer = new Dealer();
        dealer.setDeck(cards);
        deck.setDeck(dealer.getDeck());
        Table table = new Table(dealer, deck);
        table.start(1, 1);
        assertEquals(table.getPlayers().size(), 1);
        assertEquals(table.getPlayers().get(0).getHands().size(), 1);
        assertEquals(table.getDealer().getHand().size(), 2);
        assertFalse(table.getPlayer().isBust());
        assertFalse(table.doesPlayerWin());
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
