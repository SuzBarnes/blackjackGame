package blackjackapp;

import org.junit.jupiter.api.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class TableTest {

        Deck deck = new Deck();
        Dealer dealer = new Dealer();
        Table table = new Table(dealer, deck);

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
        table.start(1,1);
        assertFalse(table.getDealer().getCards().isEmpty());

    }

    @Test
    void gameCanBePlayed() {
        table.start(2, 2);
        assertEquals(2, table.getPlayers().size());
        assertEquals(2, table.getPlayers().get(0).getHands().size());
        assertFalse(table.getDealer().getCards().isEmpty());
    }

    @Test
    void ifPlayerHandIsNotBustAndHigherThanDealersPlayerWins() {
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(Card.TEN);
        cards.add(Card.EIGHT);
        cards.add(Card.ACE);
        cards.add(Card.NINE);

        dealer.setDeck(cards, cards.get(0));
        deck.setDeck(dealer.getDeck(), dealer.getCard());

        table.start(1, 1);
        assertEquals(1, table.getPlayers().size());
        assertEquals(1, table.getPlayers().get(0).getHands().size());
        assertEquals(2, table.getDealer().getCards().size());
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
        dealer.setDeck(cards, cards.get(0));
        deck.setDeck(dealer.getDeck(), dealer.getCard());

        table.start(1, 1);
        assertEquals(1, table.getPlayers().size());
        assertEquals(1, table.getPlayers().get(0).getHands().size());
        assertEquals(2, table.getDealer().getCards().size());
        assertFalse(table.getPlayer().isBust());
        assertFalse(table.doesPlayerWin());
    }

    @Test
    void ifPlayerHandIsBustDealerWins() {
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(Card.TEN);
        cards.add(Card.TEN);
        cards.add(Card.SEVEN);
        cards.add(Card.FIVE);
        cards.add(Card.FACECARD);

        dealer.setDeck(cards, cards.get(0));
        deck.setDeck(dealer.getDeck(), dealer.getCard());

        table.start(1, 1);
        table.getPlayer().hit();
        assertTrue(table.getPlayer().isBust());
        assertFalse(table.doesPlayerWin());
    }


    @Test
    void ifDealerBustAndPlayerIsNotPlayerWins() {
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(Card.TEN);
        cards.add(Card.SIX);
        cards.add(Card.SIX);
        cards.add(Card.SEVEN);
        cards.add(Card.FACECARD);

        dealer.setDeck(cards, cards.get(0));
        deck.setDeck(dealer.getDeck(), dealer.getCard());

        table.start(1, 1);

        assertTrue(table.getDealer().isBust());
        assertTrue(table.doesPlayerWin());
    }

    @Test
    void ifDealerBustAndPlayerIsBustPlayerDoesNotWin() {
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(Card.TEN);
        cards.add(Card.SIX);
        cards.add(Card.SIX);
        cards.add(Card.SEVEN);
        cards.add(Card.FACECARD);
        cards.add(Card.FACECARD);

        dealer.setDeck(cards, cards.get(0));
        deck.setDeck(dealer.getDeck(), dealer.getCard());

        table.start(1, 1);
        table.getPlayer().hit();

        assertTrue(table.getDealer().isBust());
        assertTrue(table.getPlayer().isBust());
        assertFalse(table.doesPlayerWin());
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
        table.start(2, 1);

        assertEquals(2, table.getPlayers().size());
    }


    @Test
    void moreThanOnePlayerCanHaveMoreThanOneHandsAtATable() {
        table.start(2, 2);

        assertEquals(2, table.getPlayers().size());
        assertEquals(2, table.getPlayers().get(0).getHands().size());
        assertEquals(2, table.getPlayers().get(1).getHands().size());

    }

}
