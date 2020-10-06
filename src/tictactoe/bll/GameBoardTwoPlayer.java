package tictactoe.bll;

import javafx.scene.Node;
import tictactoe.gui.controller.TicTacViewController;

import javax.swing.*;

/**
 * The GameBoardTwoPlayer class is the mandatory implementation for the TicTacToe assignment.
 * It is used for games where there are two human players.
 */
public class GameBoardTwoPlayer implements IGameModel {
    private int id;
    private String[] map;
    private int availableSlots;
    private final int COLS = 3;
    private final int ROWS = 3;

    protected GameBoardTwoPlayer() {
        map = new String[COLS * ROWS];
        availableSlots = COLS * ROWS;

    }

    /**
     * Returns 0 for player 0, 1 for player 1.
     *
     * @return int Id of the next player.
     */
    @Override
    public int getNextPlayer() {
        return id;
    }

    /**
     * Attempts to let the current player play at the given coordinates. It the
     * attempt is successful the current player has ended his turn and it is the
     * next players turn.
     *
     * @param col column to place a marker in.
     * @param row row to place a marker in.
     * @return true if the move is accepted, otherwise false. If gameOver ==
     * true this method will always return false.
     */
    @Override
    public boolean play(int col, int row) {
        if (map[col + row * COLS] == null && !isGameOver()) {
            map[col + row * COLS] = (id == 0) ? "X" : "O";
            availableSlots -= 1;
            if (id == 0) {
                id++;
            }
            else {
                id= 0;
            }
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Tells us if the game has ended either by draw or by meeting the winning
     * condition.
     *
     * @return true if the game is over, else it will return false.
     */
    @Override
    public boolean isGameOver() {
        //TODO Implement this method
        return false;
    }

    /**
     * Gets the id of the winner, -1 if its a draw.
     *
     * @return int id of winner, or -1 if draw.
     */
    @Override
    public int getWinner() {
        //TODO Implement this method
        return -1;
    }

    /**
     * Resets the game to a new game state.
     */
    @Override
    public void newGame() {
        //TODO Implement this method
    }

}