package edu.kit.informatik;

/**
 * Models the cards
 *
 * @author unyrg
 * @version 1.0
 */
public class Card {
    private static final int MIN_ASCII_DIGIT = 48;
    private static final int MAX_ASCII_DIGIT = 57;
    private final CardType type;
    private final CardValue value;


    /**
     * constructor to create a new card
     *
     * @param value value of the card
     * @param type  card type
     */
    public Card(CardValue value, CardType type) {
        this.value = value;
        this.type = type;

    }

    /**
     * converts the card to a String
     *
     * @return returns card as a string
     */
    public String toString() {
        return value.toString() + "" + type.toString();
    }

    /**
     * gets the type of the Card
     *
     * @return returns type of card
     */
    public CardType getType() {
        return type;
    }

    /**
     * gets the value of the Card
     *
     * @return returns value of card
     */
    public CardValue getValue() {
        return value;
    }

    /**
     * compare the values of two card objects
     *
     * @param o next Card object
     * @return 0 if equal 1, if next is higher and -1, if this is higher
     */
    public int compareToVal(Card o) {
        String nextVal = o.value.toString();
        String val = this.value.toString();

        if (this.value.toString().compareTo(o.value.toString()) == 0) {
            return compareToType(o);
        }
        if (isDigit(val.toCharArray()) && isDigit(nextVal.toCharArray())) {
            return Integer.parseInt(val) - Integer.parseInt(nextVal);
        }
        return val.compareTo(nextVal);
    }

    /**
     * helper methode to check if value is digit
     *
     * @param chars set of chars you want to check
     * @return true if just digits false if not
     */
    private boolean isDigit(char[] chars) {
        boolean isDigit = false;
        for (char idk : chars) {
            if (idk >= MIN_ASCII_DIGIT && idk <= MAX_ASCII_DIGIT) {
                isDigit = true;
            } else {
                return false;
            }
        }
        return isDigit;
    }

    /**
     * Compares the types of two card objects
     *
     * @param o next card object
     * @return 0 if equal 1, if next is higher and -1, if this is higher
     */
    public int compareToType(Card o) {
        return this.type.toString().compareTo(o.type.toString());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Card card = (Card) o;

        if (type != card.type) return false;
        return value == card.value;
    }

    @Override
    public int hashCode() {
        int result = type.hashCode();
        result = 31 * result + value.hashCode();
        return result;
    }


}
