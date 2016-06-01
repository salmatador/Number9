package com.moonstub.instruct.number9.Framwork;

import android.support.v4.app.Fragment;

import com.moonstub.instruct.number9.Game;

/**
 * Created by desktop on 5/31/2016.
 */
public abstract class GameMenu {


    public UiGameFragment mGameMenu;
    public GameActivity mGame;

    int mId;
    String mTag;

    public GameMenu(GameActivity game, int id, String tag){
        mGame = game;
        mId = id;
        mTag = tag;
    }

    public abstract void setupMenu();
    public abstract void bind();
    public abstract void unBind();

    public UiGameFragment getFragment(){
        return mGameMenu;
    }
    public int getId() {
        return mId;
    }

    public String getTag() {
        return mTag;
    }

}
