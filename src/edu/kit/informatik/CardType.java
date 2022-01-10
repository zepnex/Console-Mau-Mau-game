package edu.kit.informatik;

/**
 * Enum that stores the type of the card
 *
 * @author unyrg
 * @version 1.0
 */
public enum CardType {
    /**
     * Models the card type acorn
     */
    ACORN,
    /**
     * Models the card type leaves
     */
    LEAVES,
    /**
     *Models the card type leaves heart
     */
    HEART,
    /**
     * Models the card type leaves bells
     */
    BELLS;

    /**
     * Gets the indices of the card type
     *
     * @return induce of the card type
     */
    @Override
    public String toString() {
        switch (this) {
            case ACORN:
                return "E";
            case LEAVES:
                return "L";
            case HEART:
                return "H";
            case BELLS:
                return "S";
            default:
                return "";
        }
    }
}
