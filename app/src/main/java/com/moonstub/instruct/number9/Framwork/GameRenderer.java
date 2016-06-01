package com.moonstub.instruct.number9.Framwork;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.moonstub.instruct.number9.Framwork.GameActivity;
import com.moonstub.instruct.number9.Framwork.GameGraphics;

/**
 * Created by desktop on 5/28/2016.
 */
public class GameRenderer extends SurfaceView implements Runnable {

    private GameActivity mGame;
    private GameGraphics mGraphics;
    private Thread mThread;
    private boolean isRunning;
    private SurfaceHolder mHolder;
    private Canvas c;

    public GameRenderer(GameActivity game){
        super(game);
        mGame = game;
        mGraphics = game.getGameGraphics();
        mHolder = getHolder();
    }

    public void start(){
        Log.d("Starting", "Starting");
        isRunning = true;
        mThread = new Thread(this);
        mThread.start();
    }

    public void stop(){
        isRunning = false;
        if(mThread != null && mThread.isAlive()) {
            try {
                mThread.join();
            } catch (InterruptedException e) {

            }
            finally {
                mThread = null;
            }
        }
    }

    @Override
    public void run() {

        Rect r = new Rect();
        long timer  = System.currentTimeMillis();

        Thread currentThread = Thread.currentThread();
        Log.d("Start Called", "Runn");
        while(isRunning && currentThread == mThread){
            long currentTime = System.currentTimeMillis();
            float delta = currentTime - timer;
            timer = currentTime;

            if (!mHolder.getSurface().isValid()) {
                Log.d("Nothing to draw on","Wee Have a surface Error");
                continue;
            }

            mGame.getScreen().update(delta);
            mGame.getScreen().draw(delta);

            c = mHolder.lockCanvas(r);
            c.getClipBounds(r);
            c.drawBitmap(mGraphics.getBuffer(),null,r,null);

            mHolder.unlockCanvasAndPost(c);
        }
    }
}
