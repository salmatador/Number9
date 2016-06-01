package com.moonstub.instruct.number9.Screens;

import android.graphics.Color;
import android.graphics.Point;
import android.util.Log;

import com.moonstub.instruct.number9.Framwork.GameActivity;
import com.moonstub.instruct.number9.Framwork.GameGraphics;
import com.moonstub.instruct.number9.Framwork.GameScreen;
import com.moonstub.instruct.number9.Framwork.GameState;
import com.moonstub.instruct.number9.GameBoard.MainBoard;

import java.util.ArrayList;

/**
 * Created by desktop on 5/28/2016.
 */
public class MainScreen extends GameScreen {

    private static final int GRID_WIDTH = 19;
    private static final int GRID_HEIGHT = 32;

    private ArrayList<GameObjects> mPieces;

    public MainScreen(GameActivity game) {
        super(game);
    }

    @Override
    public void initScreen() {
        //TODO FIX
        setGameBoard(new MainBoard(getGraphics().getWidth(),getGraphics().getHeight(),500));
        getGameBoard().setGraphics(getGraphics());

    }


    private void updateStarted(float delta){
        if(mPieces != null) {
            for (GameObjects go : mPieces) {
                go.update(delta);
            }
        }
    }

    @Override
    public void update(float delta) {

        switch (gameState()){

            case INIT:
                break;
            case LOADING:
                break;
            case STARTING:
                break;
            case STOPPING:
                break;
            case PAUSED:
                break;
            case STARTED:
                updateStarted(delta);
                break;
            case DEMO:
                break;
            default:

        }
    }

    @Override
    public void draw(float delta) {
        GameGraphics g = getGraphics();
        g.clearScreen(Color.GRAY);
        getGameBoard().draw(g);

        if(mPieces != null) {
            for (GameObjects go : mPieces) {
                go.draw(g, delta);
            }
        }


    }

    @Override
    public boolean backPressed() {
        return true;
    }

    @Override
    public void resume() {
        setGameState(GameState.STARTING);
    }

    @Override
    public void pause() {
        setGameState(GameState.PAUSED);
    }
}
