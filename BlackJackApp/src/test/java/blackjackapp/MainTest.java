package blackjackapp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class MainTest {

    Main main = new Main();
    Console console = new Console();

    @Test
    void gameCanRunWithOnePlayerAndOneHand() {

        console.setAskUser("1");
        main.onePlayer();
        Assertions.assertEquals(1, main.table.getPlayers().size());
        Assertions.assertEquals(1, main.table.getPlayers().get(0).getHands().size());

    }

    @Test
    void gameEndsIfZeroPlayersArePlaying() {
        console.setAskUser("0");
        main.run();
        Assertions.assertTrue(main.gameEnded);
    }

    @Test
    void gameEndsIfZeroHandsAreSet() {
        console.setAskUser("0");
        main.moreThanOnePlayer(2);
        Assertions.assertTrue(main.gameEnded);
    }


//    //TODO
//    @Disabled
//    @Test
//    void twoPlayersCanHaveDifferentSizedHands() {
//        main.moreThanOnePlayer(2);
//        main.howManyHandsDoesPlayerWant(0, 1);
//        main.howManyHandsDoesPlayerWant(1, 2);
//        assertEquals(1, main.table.getPlayers().get(0).getHands().size());
//        assertEquals(2, main.table.getPlayers().get(1).getHands().size());
//
//    }

    @Test
    void playerCanSetBetOnHands() {
        console.setAskUser("1");
        main.onePlayer();
        console.setAskUser("100");
        main.howMuchDoesPlayerBet(1, 1);
        Assertions.assertEquals(100, main.table.getPlayers().get(0).getHands().get(0).getBet());
    }

    //TODO create test that will check everything is assigned correctly
    @Disabled
    @Test
    void ifPlayerSplitsHandTheConsoleWillAllowHitOrStandOnBothHands() {
        Deck deck = new Deck();
        ArrayList<Card> cards = new ArrayList<>();
        Player player = new Player(cards, 0, 0, false, false, false);
        int noOfHands = 1;
        cards.add(Card.TEN);
        cards.add(Card.TEN);
        player.setDeck(cards, cards.get(0));
        player.dealPlayerHand(1);
        main.getInteractivePlay();

    }


}
