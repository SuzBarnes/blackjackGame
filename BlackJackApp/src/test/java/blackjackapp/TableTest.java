package blackjackapp;

import org.junit.jupiter.api.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class TableTest {

    Deck deck = new Deck();
    Dealer dealer = new Dealer();
    Table table = new Table(dealer, deck);
    Player player = new Player();
    ArrayList<Card> cards = new ArrayList<>();

    @Test
    void tableCanHaveOnePlayer() {
        table.start(1, 1);
        assertEquals(1, table.getPlayers().size());

    }

    @Test
    void tableCanHaveMoreThanOnePlayer() {
        table.start(3, 1);
        assertEquals(3, table.getPlayers().size());
    }

    @Test
    void tableHasADealerHand() {
        table.start(1, 1);
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

    @Test
    void ifDealerBustPlayerWinsAndWinsDoubleBet() {
        cards.add(Card.TEN);
        cards.add(Card.SIX);
        cards.add(Card.SIX);
        cards.add(Card.SEVEN);
        cards.add(Card.FACECARD);

        dealer.setDeck(cards, cards.get(0));
        deck.setDeck(dealer.getDeck(), dealer.getCard());
        player.setBet(100);
        table.setPlayer(player);

        table.start(1, 1);
        assertTrue(table.getDealer().isBust());
        assertFalse(table.getPlayer().isBust());
        assertTrue(table.doesPlayerWin());
        assertEquals(100, player.getBet());
        assertEquals(1200, table.getPlayer().getChips());

    }

    @Test
    void ifDealerHasBlackJackPlayerLosesBet() {
        cards.add(Card.TEN);
        cards.add(Card.ACE);
        cards.add(Card.SIX);
        cards.add(Card.SEVEN);
        cards.add(Card.FACECARD);

        dealer.setDeck(cards, cards.get(0));
        deck.setDeck(dealer.getDeck(), dealer.getCard());
        player.setBet(100);
        table.setPlayer(player);

        table.start(1, 1);
        assertTrue(table.getDealer().hasBlackJack());

        assertFalse(table.doesPlayerWin());
        assertEquals(100, table.getPlayer().getBet());
        assertEquals(900, table.getPlayer().getChips());

    }

    @Test
    void ifPlayerHasBlackJackPlayerWinsTwoAndAHalfTimesBet() {
        cards.add(Card.SIX);
        cards.add(Card.SEVEN);
        cards.add(Card.FACECARD);
        cards.add(Card.TEN);
        cards.add(Card.ACE);

        dealer.setDeck(cards, cards.get(0));
        deck.setDeck(dealer.getDeck(), dealer.getCard());
        player.setBet(100);
        table.setPlayer(player);

        table.start(1, 1);
        assertTrue(table.getPlayer().hasBlackJack());

        assertTrue(table.doesPlayerWin());
        assertEquals(100, table.getPlayer().getBet());
        assertEquals(1250, table.getPlayer().getChips());

    }


    @Test
    void ifPlayerAndDealerHaveSamePointsPushAndGetBackOriginalBet() {
        cards.add(Card.SEVEN);
        cards.add(Card.FACECARD);
        cards.add(Card.TEN);
        cards.add(Card.SEVEN);

        dealer.setDeck(cards, cards.get(0));
        deck.setDeck(dealer.getDeck(), dealer.getCard());
        player.setBet(100);
        table.setPlayer(player);

        table.start(1, 1);

        assertFalse(table.doesPlayerWin());
        assertEquals(100, table.getPlayer().getBet());
        assertEquals(1000, table.getPlayer().getChips());

    }

    @Test
    void ifPlayerAndDealerBothHaveBlackJackReturnOriginalBet() {
        cards.add(Card.ACE);
        cards.add(Card.FACECARD);
        cards.add(Card.TEN);
        cards.add(Card.ACE);

        dealer.setDeck(cards, cards.get(0));
        deck.setDeck(dealer.getDeck(), dealer.getCard());
        player.setBet(100);
        table.setPlayer(player);

        table.start(1, 1);

        assertFalse(table.doesPlayerWin());
        assertEquals(100, table.getPlayer().getBet());
        assertEquals(1000, table.getPlayer().getChips());

    }

    @Test
    void ifDealerWinsWithBlackJackPlayerLosesBet() {
        cards.add(Card.ACE);
        cards.add(Card.FACECARD);
        cards.add(Card.TEN);
        cards.add(Card.NINE);

        dealer.setDeck(cards, cards.get(0));
        deck.setDeck(dealer.getDeck(), dealer.getCard());
        player.setBet(100);
        table.setPlayer(player);

        table.start(1, 1);

        assertFalse(table.doesPlayerWin());
        assertEquals(100, table.getPlayer().getBet());
        assertEquals(900, table.getPlayer().getChips());

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

    // TODO
    @Disabled
    @Test
    void differentPlayerCanPlaceDifferentBetsOnTheirHand() {
        player.setBet(100);
        Player player1 = new Player();
        player1.setBet(200);
        table.setPlayer(player);
        table.setPlayer(player1);
        table.start(2, 1);

        assertEquals(100, table.getPlayers().get(0).getBet());
        assertEquals(200, table.getPlayers().get(1).getBet());

    }

    @Test
    void playerCanSplitOneOfTheirHandsIfCardsDealtAreOfTheSameValue() {

        cards.add(Card.TEN);
        cards.add(Card.SEVEN);

        cards.add(Card.TEN);
        cards.add(Card.TEN);

        cards.add(Card.FACECARD);
        cards.add(Card.FIVE);

        dealer.setDeck(cards, cards.get(0));
        deck.setDeck(dealer.getDeck(), dealer.getCard());
        //separate out deal player hand
        // needs to be dealPlayerHand() then the number of times it is called will depend on the input by player.

        table.start(1, 2);

        assertEquals(2, table.getPlayer().getHands().size());

        table.getPlayer().split();
        assertEquals(3, table.getPlayer().getHands().size());
    }
}
