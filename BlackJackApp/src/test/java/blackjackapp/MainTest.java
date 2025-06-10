package blackjackapp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static java.lang.System.out;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

public class MainTest {

    Main main = new Main();
    Console console = new Console();

    @Test
    public void gameCanRunWithOnePlayerAndOneHand() {

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

    @Test
    void onePlayerCanHaveTwoHands() {
        console.setAskUser("2");
        main.onePlayer();
        Assertions.assertEquals(2, main.table.getPlayer().getHands().size());
        Assertions.assertEquals(1, main.table.getPlayers().size());
    }

    @Test
    void twoPlayersCanHaveOneHand() {
        console.setAskUser("2");
        main.onePlayer();
        Assertions.assertEquals(2, main.table.getPlayer().getHands().size());
        Assertions.assertEquals(1, main.table.getPlayers().size());
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
    void whenHandCanBeSplitThePlayerCanSplitHandAndBetDoubles() {
    }

    @Test
    void whenHandCanBeSplitThePlayerCanOptNotToSplitHandRemainsTheSame() {
    }

    @Test
    void playerCanSetBetOnHands() {
        console.setAskUser("1");
        main.onePlayer();
        console.setAskUser("100");
        main.howMuchDoesPlayerBet(1 ,1);
        Assertions.assertEquals(100, main.table.getPlayers().get(0).getHands().get(0).getBet());
    }

//    @Test
//    void playerCanSetDifferentBetsOnDifferentHands() {
//        console.setAskUser("1");
//        main.onePlayer();
//        console.setAskUser("100", "50");
//        main.howMuchDoesPlayerBet(2);
//        assertEquals(100, main.table.getPlayers().get(0).getHands().get(0).getBet());
//        assertEquals(50, main.table.getPlayers().get(0).getHands().get(1).getBet());
//
//    }

}
