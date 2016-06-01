package com.moonstub.instruct.number9.Framwork;

import com.moonstub.instruct.number9.Framwork.GameActivity;
import com.moonstub.instruct.number9.Framwork.GameImage;

/**
 * Created by desktop on 5/28/2016.
 */
public class GameIO {

    private GameActivity mGame;

    //Perform Game IO in this class
    public GameIO(GameActivity game) {
        mGame = game;
    }

    public GameImage loadImageFromFile(String fileName){
        return new GameImage(mGame);
    }
}
