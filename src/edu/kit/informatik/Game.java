package edu.kit.informatik;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Logic behind the game
 *
 * @author unyrg
 * @version 1.0
 */
public class Game {

    private Card discardPile;
    private final List<Card> remainingDeck;

    /**
     * Constructor which sets the cards
     *
     * @param players list of all players
     * @param input   params of the command
     */
    public Game(Player[] players, String[] input) {
        remainingDeck = new ArrayList<>();
        for (CardType type : CardType.values()) {
            for (CardValue value : CardValue.values()) {
                remainingDeck.add(new Card(value, type));
            }
        }

        Collections.shuffle(remainingDeck, new Random(Integer.parseInt(input[1])));

        for (int i = 0; i < players.length; i++) {
            ArrayList<Card> temp = new ArrayList<>();
            for (int j = 0; j < 5; j++) {
                temp.add(remainingDeck.get(0));
                remainingDeck.remove(0);
            }
            players[i] = new Player(temp, i + 1);
        }
        discardPile = remainingDeck.get(0);
        remainingDeck.remove(0);
        System.out.println("Player 1 takes the turn.");

    }

    /**
     * shows the last discarded card
     */
    public void show() {
        System.out.printf("%s / %s%n", discardPile.toString(), remainingDeck.size());
    }

    /**
     * discard a card from the players deck
     *
     * @param player player on the move
     * @param card   card the player wants to discard
     * @return returns boolean if game is over or not
     */
    public int discard(Player player, String card) {
        Card currentCard = null;
        for (Card cards : player.getHand()) {
            if (cards.toString().equals(card)) {
                currentCard = cards;

            }
        }
        if (currentCard != null) {
            if (currentCard.getType() == discardPile.getType() || currentCard.getValue() == discardPile.getValue()) {
                player.discard(currentCard);
                discardPile = currentCard;
                if (player.emptyHand()) {
                    System.out.printf("Game over: Player %s has won.%n", player.getID());
                    return -1;
                }
                return 1;
            } else {
                System.err.printf("Error, %s cannot be stacked on %s.%n", currentCard, discardPile);
                return 0;
            }
        } else {
            System.err.println("You don't have this card");
            return 0;
        }
    }

    /**
     * picks a card from the remaining cards
     *
     * @param player player on the move
     * @return false if game is over true if not
     */
    public int pick(Player player) {
        if (remainingDeck.size() - 1 == 0) {
            System.out.println("Game over: Draw.");
            return -1;
        } else {
            for (Card card : player.getHand()) {
                if (card.getValue() == discardPile.getValue() || card.getType() == discardPile.getType()) {
                    System.err.println("You are able to discard a card");
                    return 0;
                }
            }
            player.addCard(remainingDeck.get(0));
            remainingDeck.remove(0);
            return 1;
        }
    }
}
