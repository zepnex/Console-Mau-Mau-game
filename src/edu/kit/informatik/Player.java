package edu.kit.informatik;


import java.util.List;

/**
 * Models the player
 *
 * @author unyrg
 * @version 1.0
 */
public class Player {
    private final List<Card> playerHand;
    private final int id;

    /**
     * Constructor of the player model
     *
     * @param cards dealt cards
     * @param id    id of player starting from 1
     */
    public Player(List<Card> cards, int id) {
        this.playerHand = cards;
        this.id = id;
    }

    /**
     * adds a new card to the players deck
     *
     * @param card current card added to the deck of the player
     */
    public void addCard(Card card) {
        playerHand.add(card);
    }

    /**
     * shows the sorted hand of the player
     */
    public void show() {
        playerHand.sort(Card::compareToVal);
        StringBuilder str1 = new StringBuilder();
        for (Card card : playerHand) {
            str1.append(card.toString()).append(",");
        }
        System.out.println(str1.substring(0, str1.length() - 1));
    }


    /**
     * removes a card from the players hand
     *
     * @param card card that's going to be removed
     */
    public void discard(Card card) {
        playerHand.remove(card);
    }

    /**
     * checks if player hand is empty
     *
     * @return boolean if hand is empty
     */
    public boolean emptyHand() {
        return playerHand.isEmpty();
    }

    /**
     * getter for the players hand
     *
     * @return returns List of cards
     */
    public List<Card> getHand() {
        return playerHand;
    }

    /**
     * getter for the id of the player
     *
     * @return returns id of the player
     */
    public int getID() {
        return this.id;
    }

}
