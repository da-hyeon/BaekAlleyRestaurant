package com.hdh.baekalleyrestaurant.ui.main;

import android.app.Activity;
import android.content.Context;

public class MainPresenter implements MainContract.Presenter {
    private MainContract.View mView;
    private Context mContext;
    private Activity mActivity;

    public MainPresenter(MainContract.View mView, Context mContext, Activity mActivity) {
        this.mView = mView;
        this.mContext = mContext;
        this.mActivity = mActivity;
    }

    @Override
    public void loadIngUserLocation() {
    }
}
