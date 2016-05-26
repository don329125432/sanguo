package com.sanguo.Fragment.data;

import android.app.Activity;
import android.os.Bundle;

import com.amap.api.maps.MapView;
import com.sanguo.R;

/**
 * Created by Administrator on 2016/5/26.
 */
public class GPSActivity extends Activity {
    private MapView mMapView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gps);

        mMapView = (MapView) findViewById(R.id.map);
        mMapView.onCreate(savedInstanceState);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mMapView.onDestroy();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mMapView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mMapView.onPause();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mMapView.onSaveInstanceState(outState);
    }
}