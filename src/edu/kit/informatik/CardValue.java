package edu.kit.informatik;

/**
 * Enum that stores the value of the card
 *
 * @author unyrg
 * @version 1.0
 */
public enum CardValue {
    /**
     * Models the card value 7
     */
    SEVEN,
    /**
     * Models the card value 8
     */
    EIGHT,
    /**
     * Models the card value 9
     */
    NINE,
    /**
     * Models the card value 10
     */
    TEN,
    /**
     * Models the card value 12
     */
    JACK,
    /**
     * Models the card value 13
     */
    QUEEN,
    /**
     * Models the card value 14
     */
    KING,
    /**
     * Models the card value 11
     */
    ACE;


    /**
     * returns the value as a string
     *
     * @return value as string
     */
    @Override
    public String toString() {
        switch (this) {
            case SEVEN:
                return "7";
            case EIGHT:
                return "8";
            case NINE:
                return "9";
            case TEN:
                return "10";
            case JACK:
                return "B";
            case QUEEN:
                return "D";
            case KING:
                return "K";
            case ACE:
                return "A";
            default:
                return "";
        }
    }
}
