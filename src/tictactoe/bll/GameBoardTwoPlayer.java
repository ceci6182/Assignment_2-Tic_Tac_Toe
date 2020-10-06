package tictactoe.bll;

import javafx.scene.Node;
import tictactoe.gui.controller.TicTacViewController;

import javax.swing.*;

/**
 * The GameBoardTwoPlayer class is the mandatory implementation for the TicTacToe assignment.
 * It is used for games where there are two human players.
 */
public class GameBoardTwoPlayer implements IGameModel {
    private int id=0;
    private int winner;
    private String[] map;
    private int availableSlots;
    private final int COLS = 3;
    private final int ROWS = 3;
    private boolean isADraw = false;
    private boolean winnerFound =false;

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
            System.out.println("col: "+ col);
            System.out.println("row: "+ row);
            System.out.println(map[col + row * COLS]);
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
        if (checkWinner()) {
            return true;
        }
        else if (availableSlots == 0) {
            isADraw = true;
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Searches coordinates to check if three matching "X"'s and "O"'s has been placed.
     * it checks (vertically || horizontally ||diagonally L to R ||diagonally R to L)
     * @return the method return true if a winner is found, if not it returns false
     */
    private boolean checkWinner() {
        for (int i=0; i<3; i++) {
            if ("X" == map[i * COLS] && "X" == map[1 + i * COLS] && "X" == map[2 + i * COLS] || "X" == map[i] && "X" == map[COLS +i] && "X" == map[2 * COLS +i] || "X"== map[0] && "X"== map[1 + COLS] && "X"== map[2 + 2* COLS] || "X"== map[2] && "X"== map[1 + COLS] && "X"== map[2 * COLS]  ) {
                winner = 0;
                isADraw = false;
                winnerFound = true;
            }
            if ( "O" == map[i] && "O" == map[COLS +i] && "O" == map[2 * COLS +i] || "O" == map[i * COLS] && "O" == map[1 + i * COLS] && "O" == map[2 + i * COLS] || "O"== map[0] && "O"== map[1 + COLS] && "O"== map[2 + 2* COLS] || "O"== map[2] && "O"== map[1 + COLS] && "O"== map[2 * COLS] ) {
                winner = 1;
                isADraw = false;
                winnerFound = true;
            }
        }
        return winnerFound;
    }

    /**
     * Gets the id of the winner, -1 if its a draw.
     *
     * @return int id of winner, or -1 if draw.
     */
    @Override
    public int getWinner() {
        if (!isADraw) {
            return winner;
        }
        else {
            return -1;
        }
    }

    /**
     * Resets the game to a new game state.
     */
    @Override
    public void newGame() {
        //TODO Implement this method
    }

}