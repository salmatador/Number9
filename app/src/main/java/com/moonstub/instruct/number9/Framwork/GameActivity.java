package com.moonstub.instruct.number9.Framwork;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.SurfaceView;
import android.view.WindowManager;
import android.widget.LinearLayout;

import com.moonstub.instruct.number9.GameView;
import com.moonstub.instruct.number9.R;

public abstract class GameActivity extends AppCompatActivity implements TestGameFragment.OnResumeRender{


    //Property Objects
    WindowManager mManager;
    Point p;

    //Engine Objects
    Bitmap mBuffer;
    GameView mGameView;
    GameGraphics mGraphics;
    GameRenderer mRenderer;
    GameScreen mScreen;
    GameIO mIO;
    GameAudio mAudio;

    //Test Fragments
    TestGameFragment testFragment;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initGame();
        setupGame();

        mScreen = initializeScreen();
        setContentView(R.layout.activity_abstract);

        //LinearLayout surfaceView = (LinearLayout) findViewById(R.id.renderSurface);
        //surfaceView.addView();


        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.test);

        if(fragment == null) {
            fragment = mGameView;
            fm.beginTransaction().add(R.id.renderSurface, fragment).commit();
        }
    }

    private void initGame() {
        p = new Point();
        mManager = this.getWindowManager();
        mManager.getDefaultDisplay().getSize(p);
        mBuffer = Bitmap.createBitmap(p.x,p.y, Bitmap.Config.ARGB_4444);
        mGameView = new GameView();
        mGraphics = new GameGraphics(this, mBuffer);
        mRenderer = new GameRenderer(this);
        mIO = new GameIO(this);
        mAudio = new GameAudio(this);

    }

    private void setupGame(){
        mGraphics.setDimensions(p.x, p.y);
        //TODO on demand Class Loading...
    }

    public void changeScreen(GameScreen screen){
        if(screen == null){
            throw new NullPointerException("Screen cannot be null");
        }

        mScreen.pause();
        mRenderer.stop();
        mScreen = screen;

        mScreen.resume();
        mRenderer.start();
    }

    protected abstract GameScreen initializeScreen();

    @Override
    protected void onResume() {
        super.onResume();
        mScreen.resume();
        mRenderer.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mScreen.pause();
        mRenderer.stop();
    }

    @Override
    public void onBackPressed() {
        //override back pressed functionality
        if(mScreen.backPressed()) {
            mRenderer.stop();
            testFragment = new TestGameFragment();
            testFragment.setGame(this);
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.detach(mGameView);
            ft.replace(R.id.renderSurface, testFragment).commit();
            //super.onBackPressed();
        }
    }

    public GameGraphics getGameGraphics() {
        return mGraphics;
    }

    public GameScreen getScreen() {
        return mScreen;
    }

    public GameRenderer getGameRenderer() {
        return mRenderer;
    }

    public void reRender() {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.detach(testFragment);
        mGameView = new GameView();
        ft.replace(R.id.renderSurface, mGameView).commit();
        Log.d("reRender","REEEEEEEENNNNNDEDR");
        mRenderer = new GameRenderer(this);
        mRenderer.start();
    }

    public void onRenderResume(){
        reRender();
    }
}
