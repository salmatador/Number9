package com.moonstub.instruct.number9.Menus;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;

import com.moonstub.instruct.number9.Framwork.GameActivity;
import com.moonstub.instruct.number9.Framwork.GameMenu;
import com.moonstub.instruct.number9.Framwork.UiGameFragment;
import com.moonstub.instruct.number9.Game;

/**
 * Created by desktop on 5/31/2016.
 */
public class MainMenu extends GameMenu {

    public MainMenu(GameActivity game, int id, String tag) {
        super(game, id, tag);
    }

    @Override
    public void setupMenu() {
        mGameMenu = new UiGameFragment();
        mGameMenu.setGame(mGame);
        mGameMenu.setLayout(getId());
    }

    @Override
    public void bind(){
        FragmentTransaction ft = mGame.getSupportFragmentManager().beginTransaction();
        ft.add(getId(),getFragment(),getTag()).commit();
    }

    @Override
    public void unBind(){
        FragmentTransaction ft = mGame.getSupportFragmentManager().beginTransaction();
        ft.remove(getFragment()).commit();
    }



}
