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

public abstract class GameActivity extends AppCompatActivity implements UiGameFragment.OnResumeRender{


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
    UiGameFragment mainMenuView;
    TestGameFragment testFragment;
    TestGameFragment testFragment_2;
    Fragment gameFragment;
    Fragment UiFragment;
    boolean testSwitch = false;
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
            gameFragment = mGameView;
            UiFragment = testFragment;
            FragmentTransaction ft = fm.beginTransaction();
                ft.add(R.id.game_fragment, gameFragment,"game");
                            ft.commit();
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

        testFragment = new TestGameFragment();
        testFragment.setGame(this);
        testFragment.setLayout(R.layout.test);
        testFragment_2 = new TestGameFragment();
        testFragment.setGame(this);
        testFragment_2.setLayout(R.layout.test_2);

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
            mScreen.pause();
            Log.d("reRender","Back Pressed");
            if(testSwitch) {
                switchUiFragment(R.id.ui_fragment, testFragment);
            } else {
                switchUiFragment(R.id.ui_fragment, testFragment_2);
            }

            testSwitch = !testSwitch;

        }
    }

    public void switchUiFragment(int id, Fragment fragment){
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(id, fragment, "ui").commit();
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
        if(testSwitch) {
            ft.remove(testFragment_2).commit();
        } else {
            ft.remove(testFragment).commit();
        }
        mScreen.resume();
    }

    public void onRenderResume(){
        reRender();
    }
}
