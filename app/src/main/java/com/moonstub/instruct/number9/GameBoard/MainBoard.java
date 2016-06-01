package com.moonstub.instruct.number9.GameBoard;

import android.graphics.Point;
import android.util.Log;

import com.moonstub.instruct.number9.Framwork.GameBoard;
import com.moonstub.instruct.number9.Framwork.GameGrid;

import java.util.ArrayList;

/**
 * Created by desktop on 5/28/2016.
 */
public class MainBoard extends GameBoard {

    public MainBoard(int width, int height, int size) {
        super(width, height, size);

    }

    protected void setBoardDimensions() {
        Log.d("Height" , getHeight() +"");
        dim = getSize();
        Log.d("Dim Size",dim +"");
        gridX = getWidth() / dim;
        Log.d("Grid X", gridX +"");
        gridY = getHeight() / dim;
        Log.d("Grid Y", gridY + "");

        offX = (getWidth() - (gridX * dim)) / 2;
        offY = (getHeight() - (gridY * dim))/ 2;

        Log.d("Offset " , offX + " , " + offY);
    }

    public void loadAssets(){
        //Load GameBoard Assets
        GameAsset.TypeOne = getGraphics().loadImage("fileName.png");

    }

    @Override
    protected void initBoardItems() {
        int index = 0;
        for(int y = 0; y < gridY; y++){
            for(int x = 0; x < gridX; x++) {
                getBoardGrid().add(new GameGrid(getSize()));
                getBoardGrid().get(index).setLocation(x,y);
                getBoardGrid().get(index).setOffsets(offX,offY);


                index++;

            }
        }
    }

    @Override
    protected ArrayList<GameGrid> initializeBoard() {
        int width = getWidth() / dim;
        int height = getHeight() / dim;
        int arraySize = width * height;

        return new ArrayList<>();

    }
}
