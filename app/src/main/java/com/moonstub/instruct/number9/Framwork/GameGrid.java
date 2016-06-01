package com.moonstub.instruct.number9.Framwork;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.util.Log;

import java.util.Random;

/**
 * Created by desktop on 5/28/2016.
 */
enum GridType {
    //Use Later
}
public class GameGrid {
    //Basic Game Grid Properties and methods

    Random rndColor;

    private Bitmap mBaseImage;
    private GameImage mGameImage;
    private int mColor;
    public int x,y,sq,offX,offY;

    public GameGrid(int sq){
        rndColor = new Random();
        mColor = randomColor();
        this.sq = sq;
    }

    public void setLocation(int x, int y){
        this.x = x;
        this.y = y;
    }

    public void setOffsets(int x, int y){
        offX = x;
        offY = y;
    }
    public int translateX(){
        return x * sq;
    }
    public int translateY(){
        return y * sq;
    }
    public void setGameImage(GameImage image){
        mGameImage = image;
    }
    public void setImage(Bitmap image){
        mBaseImage = image;
    }

    public Bitmap getBaseImage() {
        return mBaseImage;
    }

    public GameImage getGameImage() {
        return mGameImage;
    }

    public void draw(GameGraphics g) {
        if(getBaseImage() != null) {
            g.drawImage(getBaseImage(), x, y);
        } else {
            g.changeColor(randomColor());
            //TODO FIX This
            //if(mColor != Color.BLACK && mColor != Color.WHITE) {
                g.drawRectangle(translateX() + offX, translateY() + offY, sq, sq);
            //}
            //Log.d(" ",offX + " , " + offY);
        }
    }

    public int randomColor(){

        int randomColor = rndColor.nextInt(10);
        switch (randomColor){
            case 0:
              return Color.BLACK;
            case 1:
                return Color.YELLOW;
            case 2:
                return Color.BLUE;
            case 3:
                return Color.GREEN;
            case 4:
                return Color.CYAN;
            case 5:
                return Color.DKGRAY;
            case 6:
                return Color.LTGRAY;
            case 7:
                return Color.WHITE;
            case 8:
                return Color.GRAY;
            case 9:
                return Color.MAGENTA;
            case 10:
                return Color.RED;
            default:
                return Color.argb(50,50,50,50);
        }
    }

    public int getColor() {
        return randomColor();
    }
}
