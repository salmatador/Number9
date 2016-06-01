package com.moonstub.instruct.number9;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.moonstub.instruct.number9.Framwork.GameActivity;
import com.moonstub.instruct.number9.Framwork.GameRenderer;

/**
 * Created by desktop on 5/28/2016.
 */
public class GameView extends Fragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.activity_abstract, container, false);
        LinearLayout layout = (LinearLayout)root.findViewById(R.id.renderSurface);
        GameActivity game = (GameActivity) getActivity();
        //layout.removeAllViews();
        //layout.removeAllViewsInLayout();
        layout.addView(game.getGameRenderer());

        return root;
    }
}
