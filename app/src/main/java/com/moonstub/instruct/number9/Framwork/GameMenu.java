package com.moonstub.instruct.number9.Framwork;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;

import com.moonstub.instruct.number9.Game;
import com.moonstub.instruct.number9.R;

/**
 * Created by desktop on 5/31/2016.
 */
public class GameMenu {


    public UiGameFragment mGameMenu;
    public GameActivity mGame;

    int mLayout;
    String mTag;

    public GameMenu(GameActivity game, int layout, String tag){
        mGame = game;
        mLayout = layout;
        mTag = tag;
    }

    public void setupMenu() {
        mGameMenu = new UiGameFragment();
        mGameMenu.setGame(mGame);
        mGameMenu.setLayout(getLayout());
    }

    public void bind(){
        FragmentTransaction ft = mGame.getSupportFragmentManager().beginTransaction();
        ft.add(R.id.ui_fragment,getFragment(),getTag()).commit();
    }

    public void unBind(){
        FragmentTransaction ft = mGame.getSupportFragmentManager().beginTransaction();
        ft.remove(getFragment()).commit();
    }
    public UiGameFragment getFragment(){
        return mGameMenu;
    }
    public int getLayout() {
        return mLayout;
    }

    public String getTag() {
        return mTag;
    }

}
