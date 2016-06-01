package com.moonstub.instruct.number9.Framwork;

public abstract class GameScreen {

    private GameActivity mGame;
    private GameGraphics mGraphics;
    private GameState mGameState;
    //TODO add input Handler Code

    private GameBoard mGameBoard;

    public GameScreen(GameActivity game) {
        mGame = game;
        mGraphics = game.getGameGraphics();
        initScreen();
    }

    public abstract void initScreen();

    public abstract void update(float delta);

    public abstract void draw(float delta);

    public abstract boolean backPressed();


    public abstract void resume();

    public abstract void pause();

    public GameBoard getGameBoard() {
        return mGameBoard;
    }

    public void setGameBoard(GameBoard gameBoard) {
        mGameBoard = gameBoard;
    }

    public GameState gameState(){
        return mGameState;
    }

    public void setGameState(GameState gameState){
        mGameState = gameState;
    }

    public GameActivity getGame() {
        return mGame;
    }

    public GameGraphics getGraphics() {
        return mGraphics;
    }

}
