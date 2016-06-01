package com.moonstub.instruct.number9;

import com.moonstub.instruct.number9.Framwork.GameActivity;
import com.moonstub.instruct.number9.Framwork.GameBoard;
import com.moonstub.instruct.number9.Framwork.GameScreen;
import com.moonstub.instruct.number9.Screens.MainScreen;

/**
 * Created by desktop on 5/28/2016.
 */
public class Game extends GameActivity {

    @Override
    protected GameScreen initializeScreen() {
        return (new MainScreen(this));
    }

    private class LoadingScreen extends GameScreen {

        /******
         * Initialize GameObject Here
        *******/

        GameBoard test;

        public LoadingScreen(Game game) {
            super(game);
        }

        @Override
        public void initScreen() {

        }

        @Override
        public void update(float delta) {

        }

        @Override
        public void draw(float delta) {

        }

        @Override
        public boolean backPressed() {
            return false;
        }

        @Override
        public void resume() {

        }

        @Override
        public void pause() {

        }
    }
}
