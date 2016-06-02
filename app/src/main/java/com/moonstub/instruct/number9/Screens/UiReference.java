package com.moonstub.instruct.number9.Screens;

/**
 * Created by desktop on 6/1/2016.
 */
public class UiReference {

    private int mLayout;
    private int mId;
    private String mTag;

    public UiReference(int layout, int id, String tag) {
        mLayout = layout;
        mId = id;
        mTag = tag;
    }

    public int getLayout() {
        return mLayout;
    }

    public void setLayout(int layout) {
        mLayout = layout;
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public String getTag() {
        return mTag;
    }

    public void setTag(String tag) {
        mTag = tag;
    }
}
