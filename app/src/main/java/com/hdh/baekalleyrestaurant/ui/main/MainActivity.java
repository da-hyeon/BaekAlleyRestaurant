package com.hdh.baekalleyrestaurant.ui.main;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;

import com.hdh.baekalleyrestaurant.R;
import com.hdh.baekalleyrestaurant.adapter.MainPagerAdapter;
import com.hdh.baekalleyrestaurant.databinding.ActivityMainBinding;
import com.hdh.baekalleyrestaurant.ui.base.activity.BaseActivity;

import java.security.MessageDigest;

public class MainActivity extends BaseActivity implements MainContract.View {

    private ActivityMainBinding mBinding;
    private MainContract.Presenter mPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mBinding.setMainActivity(this);
        mPresenter = new MainPresenter(this, this , this);

        initData();

        //현재위치 클릭
        mBinding.lyToolbar.tvLocation.setOnClickListener(v->
            mPresenter.clickCurrentLocation()
        );
    }

    /**
     * 데이터 초기화
     */
    private void initData(){
        isPermissionCheck();

        mBinding.vpMain.setAdapter(new MainPagerAdapter(getSupportFragmentManager()));
        mBinding.vpMain.setOffscreenPageLimit(3);

        mBinding.ntTab.setTitles("홈", "찜한가게" , "my골목");
        mBinding.ntTab.setViewPager(mBinding.vpMain);

        //유저 위치 받아오기
        mPresenter.loadIngUserLocation();
    }

    @Override
    public void changeCurrentAddress(String address) {
        mBinding.lyToolbar.tvLocation.setText(address);
    }
}
