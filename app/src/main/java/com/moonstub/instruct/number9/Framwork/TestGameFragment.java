package com.moonstub.instruct.number9.Framwork;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.moonstub.instruct.number9.R;

/**
 * Created by desktop on 5/30/2016.
 */

//TODO make this abstract
public class TestGameFragment extends Fragment {

    private OnResumeRender mCallback;
    private GameActivity mGame;
    private Button mButton;
    private int mLayout;

    public interface OnResumeRender {
        public void onRenderResume();
    }

    public void setLayout(int layout){
        mLayout = layout;
    }

    @Override
    public void onAttach(Context activity) {
        super.onAttach(activity);
        mGame = (GameActivity) activity;
        try { mCallback = (OnResumeRender) activity;}
        catch (ClassCastException e){
            //throw new ClassCastException(activity.toString() + " must implement OnRenderResume");
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(mLayout, container, false);
        mButton = (Button)rootView.findViewById(R.id.button);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCallback.onRenderResume();
            }
        });

        Toast.makeText(getContext(),"Fragment",Toast.LENGTH_LONG).show();
        return rootView;
    }

    public void setGame(GameActivity game){
        mGame = game;
    }

    public void renderScreen(){
        mGame.reRender();
    }
}
