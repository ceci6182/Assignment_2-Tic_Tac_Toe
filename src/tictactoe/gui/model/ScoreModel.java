package tictactoe.gui.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import tictactoe.bll.GameBoardTwoPlayer;
import tictactoe.bll.IGameModel;

public class ScoreModel {

    int j = 1;

    private ObservableList<String> winners;

    public ScoreModel() {
        winners = FXCollections.observableArrayList();
    }

    public ObservableList<String> getWinners() {
        return winners;
    }

    public void setNextWinner(String winner) {
        if (GameBoardTwoPlayer.isADraw)
        {
            getWinners().add("Round " + j + ": tie");
        }
        else {
            getWinners().add("Round " + j + ": " + winner);
        }
        j++;
    }

}