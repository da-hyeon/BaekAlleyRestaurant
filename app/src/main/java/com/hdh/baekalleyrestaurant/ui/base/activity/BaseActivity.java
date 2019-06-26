package com.hdh.baekalleyrestaurant.ui.base.activity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity {
    // Permission
    public static final int PERMISSION = 0x00;

    /**
     * 권한 획득 결과
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case PERMISSION:
                // 권한은 입력받은 순서대로 돌아옴
                // 0 : WRITE_EXTERNAL_STORAGE
                for (int i = 0; i < permissions.length; i++) {
                    if (grantResults.length > 0 && grantResults[i] == PackageManager.PERMISSION_GRANTED) {
                        // 권한 허가
                    } else {
                        // 권한 거부
                        finish();
                    }
                }
        }
    }

    /**
     * 권한 획득
     */
    public void isPermissionCheck() {
        if (android.os.Build.VERSION.SDK_INT >= 23) {
            int rContactPermission = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS);
            int cameraPermission = ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA);
            int sSmsPermission = ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS);
            int wExtPermission = ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
            int rExtPermission = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE);
            int aFineLocationPermission = ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION);
            int aCoarseLocationPermission = ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION);

            if (rContactPermission != PackageManager.PERMISSION_GRANTED ||
                    cameraPermission != PackageManager.PERMISSION_GRANTED ||
                    sSmsPermission != PackageManager.PERMISSION_GRANTED ||
                    wExtPermission != PackageManager.PERMISSION_GRANTED ||
                    rExtPermission != PackageManager.PERMISSION_GRANTED ||
                    aFineLocationPermission != PackageManager.PERMISSION_GRANTED ||
            aCoarseLocationPermission != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.READ_CONTACTS,
                                Manifest.permission.CAMERA,
                                Manifest.permission.SEND_SMS,
                                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                                Manifest.permission.READ_EXTERNAL_STORAGE,
                                Manifest.permission.ACCESS_FINE_LOCATION,
                                Manifest.permission.ACCESS_COARSE_LOCATION},
                        PERMISSION);
            }
        }
    }

}
