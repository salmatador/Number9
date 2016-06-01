package com.moonstub.instruct.number9.Framwork;

import android.graphics.Bitmap;

import com.moonstub.instruct.number9.Framwork.GameActivity;

/**
 * Created by desktop on 5/28/2016.
 */
public class GameImage {

    private GameActivity mGame;
    public GameImage(GameActivity game) {
        mGame = game;
    }

    Bitmap image = null;
    int width = 0;
    int height = 0;

    public void loadImage(String fileName){
        //image = mGame.getGameGraphics().loadImage(fileName);
    }

    public boolean setDimension(){
        if(image != null){
            width = image.getWidth();
            height = image.getHeight();
        } else {
            return false;
        }

        return true;
    }

    // Only needed if all else fails
    public void dispose(){
        image.recycle();
    }
}
