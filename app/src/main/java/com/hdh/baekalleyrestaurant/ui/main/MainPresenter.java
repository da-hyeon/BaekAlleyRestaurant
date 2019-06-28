package com.hdh.baekalleyrestaurant.ui.main;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.util.Log;

import com.hdh.baekalleyrestaurant.MyApplication;
import com.hdh.baekalleyrestaurant.ui.map.MapActivity;
import com.hdh.baekalleyrestaurant.uitls.GpsInfo;

import java.util.List;

public class MainPresenter implements MainContract.Presenter {
    private MainContract.View mView;
    private Context mContext;
    private Activity mActivity;
    private double latitude;
    private double longitude;
    private MyApplication mMyApplication;


    public MainPresenter(MainContract.View mView, Context mContext, Activity mActivity) {
        this.mView = mView;
        this.mContext = mContext;
        this.mActivity = mActivity;
        mMyApplication = MyApplication.getInstance();
    }

    /**
     * 현재위치 클릭 이벤트 처리
     */
    @Override
    public void clickCurrentLocation() {
        mContext.startActivity(new Intent(mContext , MapActivity.class));
    }

    @Override
    public void loadIngUserLocation() {
        // GPSTracker class
        GpsInfo gps = new GpsInfo(mContext);
        // GPS 사용유무 가져오기
        if (gps.isGetLocation()) {
            latitude = gps.getLatitude();
            longitude = gps.getLongitude();

            MyApplication.latitude = latitude;
            MyApplication.longitude = longitude;

            Geocoder geocoder = new Geocoder(mContext);
            try {

                List<Address> mResultList = geocoder.getFromLocation(latitude , longitude , 1 );
                String currentLocation ="";

                if (mResultList.get(0).getLocality() != null){
                    currentLocation += mResultList.get(0).getLocality() +" ";
                }

                if (mResultList.get(0).getSubLocality() != null){
                    currentLocation += mResultList.get(0).getSubLocality() +" ";
                }

                currentLocation += mResultList.get(0).getThoroughfare();

                mView.changeCurrentAddress(currentLocation);
            } catch (Exception e){
                mView.changeCurrentAddress("현재위치를 찾지 못함");
            }

        } else {
            // GPS 를 사용할수 없으므로
            gps.showSettingsAlert();
        }
    }
}
