package test;

import main.*;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerTest {
//    •	Hands (could be more than one, if a player has split his hand)
//    •	Bankroll (the amount of money the player has)

    @Test
    void playerCanHaveTwoHands() {
        Deck deck = new Deck();
        Player player = new Player();
        deck.generateDeckShuffle();
        player.setDeck(deck.getDeck());
        player.dealPlayerHand(2);
        assertEquals(player.getHands().size(), 2);
    }

    @Test
    void playerCanHaveOneHand() {
        Deck deck = new Deck();
        Player player = new Player();
        deck.generateDeckShuffle();
        player.setDeck(deck.getDeck());
        player.dealPlayerHand(1);
        assertEquals(player.getHands().size(), 1);
    }

    @Test
    void playerCanHaveThreeHands() {
        Deck deck = new Deck();
        Player player = new Player();
        deck.generateDeckShuffle();
        player.setDeck(deck.getDeck());
        player.dealPlayerHand(3);
        assertEquals(player.getHands().size(), 3);
    }

    @Test
    void playerCanSplitHandIfCardsDealtAreOfTheSameValue() {
        ArrayList<Card> cards = new ArrayList<>();
        Player player = new Player();
        cards.add(Card.TEN);
        cards.add(Card.TEN);
        player.setDeck(cards);
        player.dealPlayerHand(1);
        assertEquals(player.getHands().size(), 1);
        player.split();
        assertEquals(player.getHands().size(), 2);
    }

    @Test
    void playerCannotSplitHandIfCardsDealtAreOfTheDifferentValues() {
        ArrayList<Card> cards = new ArrayList<>();
        Player player = new Player();
        cards.add(Card.TEN);
        cards.add(Card.FIVE);
        player.setDeck(cards);
        player.dealPlayerHand(1);
        assertEquals(player.getHands().size(), 1);
        player.split();
        assertEquals(player.getHands().size(), 1);
    }

    //check this test later when possible to give options as opposed to automatically splitting. What if they want to split one hand and not the other?
    @Test
    void playerCanSplitOneOfTheirHandsIfCardsDealtAreOfTheSameValue() {
        ArrayList<Card> cards = new ArrayList<>();
        Player player = new Player();
        cards.add(Card.TEN);
        cards.add(Card.TEN);
        cards.add(Card.FACECARD);
        cards.add(Card.FIVE);
        player.setDeck(cards);
        player.dealPlayerHand(2);
        assertEquals(player.getHands().size(), 2);
        player.split();
        assertEquals(player.getHands().size(), 3);
    }

    @Disabled
    @Test
    void playerCanSplitOnlyOneOfTheirHandsIfTwoHandsHaveCardsDealtWithTheSameValue() {
        //this will need to be fixed later on
        ArrayList<Card> cards = new ArrayList<>();
        Player player = new Player();
        cards.add(Card.TEN);
        cards.add(Card.TEN);
        cards.add(Card.FACECARD);
        cards.add(Card.FACECARD);
        player.setDeck(cards);
        player.dealPlayerHand(2);
        assertEquals(player.getHands().size(), 2);
        player.split();
        assertEquals(player.getHands().size(), 3);
    }

    @Test
    void playerCanSplitBothOfTheirHandsIfTwoHandsHaveCardsDealtWithTheSameValue() {
        ArrayList<Card> cards = new ArrayList<>();
        Player player = new Player();
        cards.add(Card.TEN);
        cards.add(Card.TEN);
        cards.add(Card.FACECARD);
        cards.add(Card.FACECARD);
        player.setDeck(cards);
        player.dealPlayerHand(2);
        System.out.println(player.getHands() + " :player.getHands()");
        assertEquals(player.getHands().size(), 2);
        player.split();
        System.out.println(player.getHands() + " :player.getHands()");

        assertEquals(player.getHands().size(), 4);
    }


    @Test
    void playerStartsWith1000Chips() {
        Player player = new Player();
        assertEquals(player.getChips(), 1000);

    }

    @Test
    void playerCanPlaceABet() {
        Player player = new Player();
        player.bet(100);
        assertEquals(player.getChips(), 900);
    }

    //to be on the Table class?
//    @Test
//    void playerCanPlaceDifferentBetsAgainstDifferentHands() {
//        Player player = new Player();
//        player.bet(100);
//        assertEquals(player.getChips(), 900);
//    }


}
