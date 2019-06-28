package com.hdh.baekalleyrestaurant.ui.map;

import android.content.Intent;

public interface MapContract {
    interface View{

    }
    interface Presenter{
        void getRestaurantLocation();
        void setMap();
    }
}
