package com.hdh.baekalleyrestaurant.ui.map;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.hdh.baekalleyrestaurant.R;
import com.hdh.baekalleyrestaurant.databinding.ActivityMapBinding;
import com.hdh.baekalleyrestaurant.ui.base.activity.BaseActivity;

import net.daum.mf.map.api.MapPOIItem;
import net.daum.mf.map.api.MapPoint;
import net.daum.mf.map.api.MapView;


public class MapActivity extends BaseActivity implements MapContract.View{

    private ActivityMapBinding mBinding;
    private MapContract.Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this , R.layout.activity_map);
        mBinding.setMapActivity(this);
        mPresenter = new MapPresenter(this, this, mBinding.mapView);

        mPresenter.getRestaurantLocation();
        mPresenter.setMap();
    }


}
