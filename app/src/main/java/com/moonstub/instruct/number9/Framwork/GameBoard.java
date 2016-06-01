package com.moonstub.instruct.number9.Framwork;

import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Rect;

import java.util.ArrayList;

/**
 * Created by desktop on 5/28/2016.
 */
enum BoardType{
    HEX,SQAURE,PERSPECTIVE
}
public abstract class GameBoard {


    protected int offX = 0;
    protected int offY = 0;
    protected int spacer = 5;
    protected int gridX = 0;
    protected int gridY = 0;
    protected int dim = 0;

    /**
     * What Properties to all Game Boards have in Common
     * **/

    private GameGraphics mGraphics;
    private BoardType mBoardType;
    private Rect mRect;
    private int mWidth,mHeight;
    private int mSize;
    private ArrayList<GameGrid> mBoardGrid;

    public GameBoard(int width, int height, int size){
        mWidth = width;
        mHeight = height;
        mSize = size;
        setBoardDimensions();
        mBoardGrid = initializeBoard();

        initBoardItems();
    }

    protected abstract void setBoardDimensions();

    protected abstract void initBoardItems();
    protected abstract ArrayList<GameGrid> initializeBoard();

    public void draw(GameGraphics g){
        g.changeColor(Color.RED);
        g.drawRectangle(2,2,1078,1774);
        if(mBoardGrid != null) {
            for (GameGrid grid : mBoardGrid) {
                grid.draw(g);
            }
        }
    }

    public Rect getBounds(){
        return new Rect(0,0,mWidth,mHeight);
    }

    public BoardType getBoardType() {
        return mBoardType;
    }

    public void setBoardType(BoardType boardType) {
        mBoardType = boardType;
    }

    public Rect getRect() {
        return mRect;
    }

    public void setRect(Rect rect) {
        mRect = rect;
    }

    public int getWidth() {
        return mWidth;
    }

    public void setWidth(int width) {
        mWidth = width;
    }

    public int getHeight() {
        return mHeight;
    }

    public void setHeight(int height) {
        mHeight = height;
    }

    public int getSize() {
        return mSize;
    }

    public void setSize(int size) {
        mSize = size;
    }

    public ArrayList<GameGrid> getBoardGrid() {
        return mBoardGrid;
    }

    public void setBoardGrid(ArrayList<GameGrid> boardGrid) {
        mBoardGrid = boardGrid;
    }

    public GameGraphics getGraphics() {
        return mGraphics;
    }

    public void setGraphics(GameGraphics graphics) {
        mGraphics = graphics;
    }

    public int getOffX() {
        return offX;
    }

    public void setOffX(int offX) {
        this.offX = offX;
    }

    public int getOffY() {
        return offY;
    }

    public void setOffY(int offY) {
        this.offY = offY;
    }

    public int getSpacer() {
        return spacer;
    }

    public void setSpacer(int spacer) {
        this.spacer = spacer;
    }
}
