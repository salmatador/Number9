package com.moonstub.instruct.number9.Screens;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.util.NoSuchPropertyException;

import com.moonstub.instruct.number9.Framwork.GameActivity;
import com.moonstub.instruct.number9.Framwork.GameGraphics;
import com.moonstub.instruct.number9.Framwork.GameMenu;
import com.moonstub.instruct.number9.Framwork.GameScreen;
import com.moonstub.instruct.number9.Framwork.GameState;
import com.moonstub.instruct.number9.Framwork.TestGameFragment;
import com.moonstub.instruct.number9.Framwork.UiGameFragment;
import com.moonstub.instruct.number9.GameBoard.MainBoard;
import com.moonstub.instruct.number9.Menus.MainMenu;
import com.moonstub.instruct.number9.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by desktop on 5/28/2016.
 */

//TODO Organize extra Ui elements
public class MainScreen extends GameScreen {

    private static final int GRID_WIDTH = 19;
    private static final int GRID_HEIGHT = 32;

    public static final String MAIN_MENU_SCENE = "mainMenu";
    public static final String OPTIONS_MENU_SCENE = "optionsMenu";
    public static final String HIGH_SCORE_SCENE = "highScore";

    private ArrayList<GameObjects> mPieces;

    private MainMenu mMainMenu;

    private List<UiReference> mUiReferenceList;
    private List<GameMenu> mGameMenus;

    public MainScreen(GameActivity game) {
        super(game);
    }


    public void GameSetup() {
        //noinspection ResourceType
        //TODO Get Resource id from storageClass in GameActivity @Not Implemented

        mGameMenus = new ArrayList<>();

        mGameMenus.add(new GameMenu(getGame(),R.layout.game_main_menu,"mainMenu"));
        GameMenu mainMenu = mGameMenus.get(0);
        mainMenu.setupMenu();

        mGameMenus.add(new GameMenu(getGame(), R.layout.game_options_menu,"optionsMenu"));
        GameMenu optionsMenu = mGameMenus.get(1);
        optionsMenu.setupMenu();


    }

    public void menuSwitch(String tag){
        switch (tag){
            case MAIN_MENU_SCENE:
                //unbind and bind
                break;
            case OPTIONS_MENU_SCENE:
                break;
            case HIGH_SCORE_SCENE:
                break;
            default:
                throw new NoSuchPropertyException("That Scene Does Not Exist");
        }
    }

    @Override
    public void initScreen() {

        GameSetup();

        setGameBoard(new MainBoard(getGraphics().getWidth(),getGraphics().getHeight(),500));
        getGameBoard().setGraphics(getGraphics());

        //setFirstScreen
        mGameMenus.get(0).bind();
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
        if(gameState() != GameState.PAUSED) {
            g.clearScreen(Color.GRAY);
            getGameBoard().draw(g);

            if (mPieces != null) {
                for (GameObjects go : mPieces) {
                    go.draw(g, delta);
                }
            }
        }

    }

    @Override
    public boolean backPressed() {
        return true;
    }

    @Override
    public void resume() {
        setGameState(GameState.PAUSED);
    }

    @Override
    public void pause() {
        setGameState(GameState.PAUSED);
    }
}
