package com.hdh.baekalleyrestaurant.ui.main;

public interface MainContract {
    interface View{
        void changeCurrentAddress(String address);
    }
    interface Presenter{
        void clickCurrentLocation();
        void loadIngUserLocation();
    }
}
