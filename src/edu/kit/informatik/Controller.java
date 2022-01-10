package edu.kit.informatik;

import java.util.Scanner;

/**
 * Controller class that perform all user inputs
 *
 * @author unyrg
 * @version 1.0
 */
public class Controller {
    private static final int MAX_PLAYER = 4;
    private static final String INVALID = "Invalid arguments or no game instance";
    private Game currentGame;
    private Player[] players;
    private Player currentPLayer;


    /**
     * Constructor of Controller
     * <p>
     * here all the user input is getting processed
     * </p>
     */
    public Controller() {
        boolean running = true;
        while (running) {
            Scanner scan = new Scanner(System.in);
            String[] input = scan.nextLine().split(" ");
            try {
                switch (input[0]) {
                    case "quit":
                        running = false;
                        break;
                    case "start":
                        if (input.length >= 2) {
                            players = new Player[MAX_PLAYER];
                            this.currentGame = new Game(players, input);
                            currentPLayer = players[0];
                        }
                        break;
                    case "show":
                        if (!checkInputAndGame(input, 2)) {
                            break;
                        }
                        if (input[1].equals("game")) {
                            currentGame.show();
                        } else if (checkIndex(Integer.parseInt(input[1]))) {
                            players[Integer.parseInt(input[1]) - 1].show();
                        }

                        break;
                    case "discard":
                        if (checkInputAndGame(input, 3) && checkCurrentPlayer(Integer.parseInt(input[1]))) {
                            int check = currentGame.discard(currentPLayer, input[2]);

                            gameOver(check);
                        }
                        break;
                    case "pick":
                        if (checkInputAndGame(input, 2) && checkCurrentPlayer(Integer.parseInt(input[1]))) {
                            int check = currentGame.pick(currentPLayer);
                            gameOver(check);
                        }
                        break;
                    default:
                        System.err.println("Command doesn't exist");
                }
            } catch (NumberFormatException e) {
                System.err.println(INVALID);
            }
        }

    }

    /**
     * Checks whether it is the correct player's turn
     *
     * @param playerID user input, with the referring id
     * @return  boolean, if it is the referenced player's turn
     */
    private boolean checkCurrentPlayer(int playerID) {
        return checkIndex(playerID) && currentPLayer.getID() == playerID;
    }

    /**
     * Checks that a correct player is called
     *
     * @param playerID user input which player he is referring to
     * @return true if player exists, false if not
     */
    private boolean checkIndex(int playerID) {
        return playerID <= MAX_PLAYER && playerID >= 1;
    }

    /**
     * Checks if input is valid and game not null
     *
     * @param input  command with args
     * @param length how many arguments the command should have
     * @return true if everything is correct false if an issue appears
     */
    private boolean checkInputAndGame(String[] input, int length) {
        if (input.length >= length && currentGame != null) {
            return true;
        } else {
            System.err.println(INVALID);
            return false;
        }
    }

    /**
     * Checks if game is over
     * <p>
     * also sets currentPlayer to the next player if
     * current player has finished his turn
     * </p>
     *
     * @param check -1 if game is over
     *              1 if player finished his turn
     *              0 if turn isn't finished yet
     */
    private void gameOver(int check) {
        if (check == -1) currentGame = null;
        else if (check == 1) {
            if (currentPLayer.getID() != MAX_PLAYER) {
                currentPLayer = players[currentPLayer.getID()];
            } else {
                currentPLayer = players[0];
            }
        }
    }
}
