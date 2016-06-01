package com.moonstub.instruct.number9.Framwork;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import android.graphics.Rect;
import android.util.Log;

import com.moonstub.instruct.number9.Framwork.GameActivity;

/**
 * Created by desktop on 5/28/2016.
 */

public class GameGraphics {

    private Bitmap mBuffer;
    private GameActivity mGame;

    private int width;
    private int height;

    Canvas mCanvas;
    Paint mPaint = new Paint();
    int mColor;
    Rect mRect;
    Rect mDstRect;

    public void drawRectangle(int x, int y, int w, int h){
        Rect temp = new Rect(x,y,w+x,h+y);
        mCanvas.drawRect(temp, mPaint);
        Paint p = new Paint();
        p.setStyle(Paint.Style.STROKE);
        p.setStrokeWidth(5.0f);
        p.setColor(Color.GREEN);
        mCanvas.drawRect(temp, p);

    }

    public void drawCircle(){}

    public void drawEllipse(){}

    public void drawImage(){}

    public GameImage loadImage(String fileName){
        return new GameImage(mGame);
    }
    //public Bitmap loadImage(String fileName){}

    public void changeColor(int color){
        mColor = color;
        mPaint.setColor(mColor);
    }
    public void replacePaint(Paint paint){
        mPaint = paint;
    }
    public void clearScreen(int color){
        mPaint.setColor(color);
        mCanvas.drawRect(mRect,mPaint);
    }

    public GameGraphics(GameActivity game, Bitmap buffer) {
        mGame = game;
        mBuffer = buffer;
        mCanvas = new Canvas(buffer);
        width = mBuffer.getWidth();
        height = mBuffer.getHeight();
        Log.d("WIDTH & HEIGHT ",mBuffer.getWidth()  + " , " + mBuffer.getHeight());
        mRect = new Rect(0,0,getWidth(),getHeight());

    }

    public void setDimensions(int x, int y) {
        width = x;
        height = y;
    }

    public int getWidth(){
        return width;
    }

    public int getHeight() {

        return height;
    }

    public Bitmap getBuffer() {
        return mBuffer;
    }

    public void drawImage(Bitmap baseImage, int x, int y) {
        mCanvas.drawBitmap(baseImage,x,y,mPaint);
    }
}
