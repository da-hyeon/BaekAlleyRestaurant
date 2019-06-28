package com.hdh.baekalleyrestaurant.ui.map;

import android.content.Context;
import android.graphics.Color;
import android.location.Address;
import android.location.Geocoder;

import com.hdh.baekalleyrestaurant.MyApplication;

import net.daum.mf.map.api.MapCircle;
import net.daum.mf.map.api.MapPOIItem;
import net.daum.mf.map.api.MapPoint;
import net.daum.mf.map.api.MapView;

import java.io.IOException;
import java.util.List;

public class MapPresenter implements MapContract.Presenter {
    private MapContract.View mView;
    private Context mContext;
    private MyApplication mMyApplication;
    private MapView mMapView;
    public MapPresenter(MapContract.View mView, Context mContext ,MapView mMapView) {
        this.mView = mView;
        this.mContext = mContext;
        this.mMapView = mMapView;
        mMyApplication = MyApplication.getInstance();

    }


    @Override
    public void getRestaurantLocation() {
        Geocoder geocoder = new Geocoder(mContext);
        List<Address> latLon;
        try {
            latLon = geocoder.getFromLocationName("서대문구 포방터길 43" , 10);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setMap() {

        MapPoint mapPoint = MapPoint.mapPointWithGeoCoord(126.948829, 37.5986482);


        MapPOIItem myLocation = new MapPOIItem();
        myLocation.setItemName("내 위치");
        myLocation.setTag(0);
        myLocation.setMapPoint(mapPoint);
        // 기본으로 제공하는 BluePin 마커 모양.
        myLocation.setMarkerType(MapPOIItem.MarkerType.RedPin);
        // 마커를 클릭했을때, 기본으로 제공하는 RedPin 마커 모양.
        myLocation.setSelectedMarkerType(MapPOIItem.MarkerType.RedPin);


        MapCircle circle = new MapCircle(
                mapPoint, // center
                100, // radius
                Color.argb(128, 255, 0, 0), // strokeColor
                Color.argb(128, 0, 255, 0) // fillColor
        );
        circle.setTag(1234);

//        MapPoint mapPoint1 =  MapPoint.mapPointWithGeoCoord(126.948829, 37.5986482);
//
//        MapPOIItem donKa2014 = new MapPOIItem();
//        donKa2014.setItemName("돈카2014");
//        donKa2014.setTag(1);
//        donKa2014.setMapPoint(mapPoint1);
//        // 기본으로 제공하는 BluePin 마커 모양.
//        donKa2014.setMarkerType(MapPOIItem.MarkerType.RedPin);
//        // 마커를 클릭했을때, 기본으로 제공하는 RedPin 마커 모양.
//        donKa2014.setSelectedMarkerType(MapPOIItem.MarkerType.RedPin);




        mMapView.setMapCenterPoint(mapPoint, true);
        MapPOIItem[] poiItems = {myLocation };
        mMapView.addPOIItems(poiItems);
        mMapView.addCircle(circle);
    }
}
