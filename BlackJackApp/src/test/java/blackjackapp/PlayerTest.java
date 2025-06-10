package blackjackapp;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;


import static org.junit.jupiter.api.Assertions.assertEquals;
class PlayerTest {
//    •	Hands (could be more than one, if a player has split his hand)
//    •	Bankroll (the amount of money the player has)

    Deck deck = new Deck();
    ArrayList<Card> cards = new ArrayList<>();
    Player player = new Player(cards, 0,0,false, false,false);

    @Test
    void playerCanHaveTwoHands() {
        deck.generateDeckShuffle();
        player.setDeck(deck.getDeck(), deck.getCard());
        player.dealPlayerHand(2);

        assertEquals(2, player.getHands().size());
    }

    @Test
    void playerCanHaveOneHand() {
        deck.generateDeckShuffle();
        player.setDeck(deck.getDeck(), deck.getCard());
        player.dealPlayerHand(1);

        assertEquals(1, player.getHands().size());
    }

    @Test
    void playerCanHaveThreeHands() {
        deck.generateDeckShuffle();
        player.setDeck(deck.getDeck(), deck.getCard());
        player.dealPlayerHand(3);

        assertEquals(3, player.getHands().size());
    }

    @Test
    void playerCanSplitHandIfCardsDealtAreOfTheSameValue() {
        cards.add(Card.TEN);
        cards.add(Card.TEN);
        player.setDeck(cards, cards.get(0));
        player.dealPlayerHand(1);

        assertEquals(1, player.getHands().size());

        player.split();
        assertEquals(2, player.getHands().size());
    }

    @Test
    void playerCannotSplitHandIfCardsDealtAreOfTheDifferentValues() {
        cards.add(Card.TEN);
        cards.add(Card.FIVE);
        player.setDeck(cards, cards.get(0));
        player.dealPlayerHand(1);

        assertEquals(1, player.getHands().size());
        player.split();
        assertEquals(1, player.getHands().size());
    }

    @Disabled
    @Test
    void playerCanSplitOnlyOneOfTheirHandsIfTwoHandsHaveCardsDealtWithTheSameValue() {
        //TODO this will need to be fixed later on. Add dealer in?
        cards.add(Card.TEN);
        cards.add(Card.TEN);
        cards.add(Card.FACECARD);
        cards.add(Card.FACECARD);
        player.setDeck(cards, cards.get(0));
        player.dealPlayerHand(2);

        assertEquals(2, player.getHands().size());

        assertEquals(3, player.getHands().size());
    }

    @Test
    void playerCanSplitBothOfTheirHandsIfTwoHandsHaveCardsDealtWithTheSameValue() {
        cards.add(Card.TEN);
        cards.add(Card.TEN);
        cards.add(Card.FACECARD);
        cards.add(Card.FACECARD);
        player.setDeck(cards, cards.get(0));
        player.dealPlayerHand(2);

        assertEquals(2, player.getHands().size());

        player.split();
        assertEquals(4, player.getHands().size());
    }


    @Test
    void playerStartsWith1000Chips() {
        assertEquals(1000, player.getChips());

    }

    @Test
    void playerCanPlaceABetOnAHand() {
        deck.generateDeckShuffle();
        player.setDeck(deck.getDeck(), deck.getCard());
        player.dealPlayerHand(1);
        player.getHands().get(0).setBet(100);
        player.calculateChipsRemaining(0);

        assertEquals(900, player.getChips());
    }

    @Test
    void ifSplitOccursBetIsCarriedAcrossToo() {
        cards.add(Card.TEN);
        cards.add(Card.TEN);
        player.setDeck(cards, cards.get(0));
        player.dealPlayerHand(1);
        player.getHands().get(0).setBet(100);

        player.calculateChipsRemaining(0);
        assertEquals(900, player.getChips());

        player.split();

        assertEquals(800, player.getChips());
        assertEquals(100, player.getHands().get(0).getBet());
        assertEquals(100, player.getHands().get(1).getBet());
    }

    @Test
    void playerCanPlaceDifferentBetsOnDifferentHands() {
        deck.generateDeckShuffle();
        player.setDeck(deck.getDeck(), deck.getCard());
        player.dealPlayerHand(2);
        player.getHands().get(0).setBet(100);
        player.getHands().get(1).setBet(200);

        assertEquals(100, player.getHands().get(0).getBet());
        assertEquals(200, player.getHands().get(1).getBet());

    }

    @Test
    void playerCanAddExtraCardToHandUnlessBlackJack() {
        deck.generateDeckShuffle();
        player.setDeck(deck.getDeck(), deck.getCard());
        player.dealPlayerHand(1);
        player.hit();
        if (player.hasBlackJack()) {
            assertEquals(2, player.getCards().size());

        } else {
            assertEquals(3, player.getCards().size());
        }
    }

    @Test
    void aBetIsAssignedToAHand() {
        deck.generateDeckShuffle();
        player.setDeck(deck.getDeck(), deck.getCard());
        player.setBet(100);
        player.dealPlayerHand(1);
        assertEquals(100, player.getBet());
    }

    @Disabled
    @Test
    void playerCanPlaceDifferentBetsAgainstDifferentHands() {

        assertEquals(900, player.getChips());
    }


}
