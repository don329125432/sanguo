package com.sanguo.Fragment.data;

import android.app.Activity;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.maps.AMap;
import com.amap.api.maps.AMap.InfoWindowAdapter;
import com.amap.api.maps.AMap.OnInfoWindowClickListener;
import com.amap.api.maps.AMap.OnMapClickListener;
import com.amap.api.maps.AMap.OnMarkerClickListener;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.LocationSource;
import com.amap.api.maps.MapView;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.CircleOptions;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.core.PoiItem;
import com.amap.api.services.core.SuggestionCity;
import com.amap.api.services.poisearch.PoiResult;
import com.amap.api.services.poisearch.PoiSearch;
import com.amap.api.services.poisearch.PoiSearch.OnPoiSearchListener;
import com.sanguo.R;


import java.util.ArrayList;
import java.util.List;

import static android.widget.Toast.LENGTH_LONG;
import static android.widget.Toast.makeText;

/**
 * Created by Administrator on 2016/5/26.
 */
public class LocationModeSourceActivity extends Activity implements View.OnClickListener,
        OnMapClickListener, OnInfoWindowClickListener, InfoWindowAdapter, OnMarkerClickListener,
        OnPoiSearchListener, RadioGroup.OnCheckedChangeListener, LocationSource, AMapLocationListener {
    private AMap aMap;
    private MapView mapView;
    private LocationSource.OnLocationChangedListener mListener;
    private AMapLocationClient mlocationClient;
    private AMapLocationClientOption mLocationOption;
    private RadioGroup mGPSModeGroup;
    private LatLonPoint lp = new LatLonPoint(39.993167, 116.473274);

    private TextView mLocationErrText;
    private String chenshi;
    private String shengshi;
    private String chengqu;
    private String jiedao;
    private String menpai;
    private Button mSousuo_button;
    private LinearLayout mSousuo_caidan;
    private Button mKaishisousuo;
    private Button mSousuo_next;
    private EditText mSousuo_chengshi;
    private EditText mSousuo_diqu;
    private EditText mSousuo_xiangxi;
    private boolean style = false;
    private Button mSousuo_huanyuan;
    private int currentPage = 0;
    private String keyWord;
    private String keyWord1;
    private String keyWord2;
    private String keyWord3;
    private PoiSearch.Query query;
    private Marker locationMarker;
    private PoiResult poiResult;
    private List<PoiItem> poiItems;
    private Marker mlastMarker;
    private PoiSearch poiSearch;
    private myPoiOverlay poiOverlay;
    private Marker detailMarker;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.locationmodesource_activity);

        mlocationClient = new AMapLocationClient(getApplicationContext());
        mapView = (MapView) findViewById(R.id.map);
        mapView.onCreate(savedInstanceState);

        mSousuo_caidan = (LinearLayout) findViewById(R.id.sousuocaidan);

        mSousuo_chengshi = (EditText) findViewById(R.id.sousuo_chengshi);
        mSousuo_diqu = (EditText) findViewById(R.id.sousuo_diqu);
        mSousuo_xiangxi = (EditText) findViewById(R.id.sousuo_xiangxi);
        mSousuo_chengshi.setOnClickListener(this);
        mSousuo_diqu.setOnClickListener(this);
        mSousuo_xiangxi.setOnClickListener(this);

        mSousuo_button = (Button) findViewById(R.id.sousuo_button);
        mKaishisousuo = (Button) findViewById(R.id.kaishisousuo);
        mSousuo_next = (Button) findViewById(R.id.sousuo_next);
        mSousuo_huanyuan = (Button) findViewById(R.id.sousuo_huanyuan);
        mSousuo_button.setOnClickListener(this);
        mSousuo_caidan.setOnClickListener(this);
        mKaishisousuo.setOnClickListener(this);
        mSousuo_huanyuan.setOnClickListener(this);
        init();
        setfromandtoMarker();
    }

    private void setfromandtoMarker() {
        aMap.addMarker(new MarkerOptions()
                .position(AMapUtil.convertToLatLng(mStartPoint))
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.start)));
        aMap.addMarker(new MarkerOptions()
                .position(AMapUtil.convertToLatLng(mEndPoint))
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.end)));
    }

    private void init() {
        if (aMap == null) {
            aMap = mapView.getMap();
            aMap.setOnMapClickListener(this);
            aMap.setOnMarkerClickListener(this);
            aMap.setOnInfoWindowClickListener(this);
            aMap.setInfoWindowAdapter(this);
            locationMarker = aMap.addMarker(new MarkerOptions()
                    .anchor(0.5f, 0.5f)
                    .icon(BitmapDescriptorFactory
                            .fromBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.point4)))
                    .position(new LatLng(lp.getLatitude(), lp.getLongitude())));
            locationMarker.showInfoWindow();

            setUpMap();
            aMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(lp.getLatitude(), lp.getLongitude()), 14));
        }

        mGPSModeGroup = (RadioGroup) findViewById(R.id.gps_radio_group);
        mGPSModeGroup.setOnCheckedChangeListener(this);
        mLocationErrText = (TextView) findViewById(R.id.location_errInfo_text);
        mLocationErrText.setVisibility(View.GONE);
    }

    private void setUpMap() {
        aMap.setLocationSource(this);
        aMap.getUiSettings().setMyLocationButtonEnabled(true);
        aMap.setMyLocationEnabled(true);
        aMap.setMyLocationType(AMap.LOCATION_TYPE_LOCATE);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.gps_locate_button:
                aMap.setMyLocationType(AMap.LOCATION_TYPE_LOCATE);
                break;
            case R.id.gps_follow_button:
                aMap.setMyLocationType(AMap.LOCATION_TYPE_MAP_FOLLOW);
                break;
            case R.id.gps_rotate_button:
                aMap.setMyLocationType(AMap.LOCATION_TYPE_MAP_ROTATE);
                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mapView.onPause();
        deactivate();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mapView.onSaveInstanceState(outState);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
        if (null != mlocationClient) {
            mlocationClient.onDestroy();
        }
    }

    @Override
    public void onLocationChanged(AMapLocation amapLocation) {
        if (amapLocation != null) {
            if (amapLocation.getErrorCode() == 0) {
                mLocationErrText.setVisibility(View.GONE);
                mListener.onLocationChanged(amapLocation);
                shengshi = amapLocation.getProvince();
                chenshi = amapLocation.getCity();
                chengqu = amapLocation.getDistrict();
                jiedao = amapLocation.getStreet();
                menpai = amapLocation.getStreetNum();
                mLocationErrText.setVisibility(View.VISIBLE);
                if (shengshi != chenshi) {
                    mLocationErrText.setText("您当前的位置在：" + chenshi + " " + chengqu + " " + jiedao + " " + menpai);
                } else {
                    mLocationErrText.setText("您当前的位置在：" + shengshi + " " + chenshi + " " + chengqu + " " + jiedao + " " + menpai);
                }
            } else {
                String errText = "定位失败，" + amapLocation.getErrorCode() + ":" + amapLocation.getErrorInfo();
                Log.e("AmapErr", errText);
                mLocationErrText.setVisibility(View.VISIBLE);
                mLocationErrText.setText(String.valueOf(errText));
            }
        }
    }

    @Override
    public void activate(OnLocationChangedListener listener) {
        mListener = listener;
        if (mlocationClient != null) {
            mlocationClient = new AMapLocationClient(this);
            mLocationOption = new AMapLocationClientOption();
            mlocationClient.setLocationListener(this);
            mLocationOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
            mlocationClient.setLocationOption(mLocationOption);
            mlocationClient.startLocation();
        }
    }

    @Override
    public void deactivate() {
        mListener = null;
        if (mlocationClient != null) {
            mlocationClient.stopLocation();
            mlocationClient.onDestroy();
        }
        mlocationClient = null;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.sousuo_button:
                if (style) {
                    mSousuo_caidan.setVisibility(View.GONE);
                    style = false;
                    mSousuo_button.setText("搜索");
                } else {
                    mSousuo_caidan.setVisibility(View.VISIBLE);
                    style = true;
                    mSousuo_button.setText("取消搜索");
                }
                mSousuo_xiangxi.setFocusable(true);
                mSousuo_xiangxi.setFocusableInTouchMode(true);
                mSousuo_xiangxi.requestFocus();
                break;
            case R.id.sousuo_huanyuan:
                mSousuo_xiangxi.setText(jiedao + menpai);
                mSousuo_diqu.setText(chengqu);
                mSousuo_chengshi.setText(chenshi);
                break;
            case R.id.kaishisousuo:
                doSearchQuery();
                break;
            case R.id.sousuo_next:
                break;
            case R.id.sousuo_xiangxi:
                mSousuo_xiangxi.setText("");
                break;
            case R.id.sousuo_diqu:
                mSousuo_diqu.setText("");
                break;
            case R.id.sousuo_chengshi:
                mSousuo_chengshi.setText("");
                break;
        }
    }

    protected void doSearchQuery() {
        keyWord3 = mSousuo_xiangxi.getText().toString().trim();
        keyWord2 = mSousuo_diqu.getText().toString().trim();
        keyWord1 = mSousuo_chengshi.getText().toString().trim();

        makeText(this, keyWord1 + keyWord2 + keyWord3, LENGTH_LONG).show();

        currentPage = 0;
        query = new PoiSearch.Query(keyWord3, "", keyWord1);
        query.setPageSize(20);
        query.setPageNum(currentPage);

        if (lp != null) {
            poiSearch = new PoiSearch(this, query);
            poiSearch.setOnPoiSearchListener(this);
//            poiSearch.setBound(new PoiSearch.SearchBound(lp, 500000000, true));
            poiSearch.searchPOIAsyn();
        }
    }

    private void setPoiItemDisplayContent(final PoiItem mCurrentPoi) {
        mSousuo_chengshi.setText(mCurrentPoi.getTitle());
        mSousuo_diqu.setText(mCurrentPoi.getSnippet());
    }

    private int[] markers = {
            R.drawable.poi_marker_1,
            R.drawable.poi_marker_2,
            R.drawable.poi_marker_3,
            R.drawable.poi_marker_4,
            R.drawable.poi_marker_5,
            R.drawable.poi_marker_6,
            R.drawable.poi_marker_7,
            R.drawable.poi_marker_8,
            R.drawable.poi_marker_9,
            R.drawable.poi_marker_10
    };

    @Override
    public void onPoiSearched(PoiResult result, int rcode) {

        if (rcode == 1000) {
            if (result != null && result.getQuery() != null) {// 搜索poi的结果;
                if (result.getQuery().equals(query)) {// 是否是同一条
                    poiResult = result;
                    poiItems = poiResult.getPois();// 取得第一页的poiitem数据，页数从数字0开始
                    List<SuggestionCity> suggestionCities = poiResult
                            .getSearchSuggestionCitys();// 当搜索不到poiitem数据时，会返回含有搜索关键字的城市信息
                    if (poiItems != null && poiItems.size() > 0) {
                        //清除POI信息显示
                        whetherToShowDetailInfo(false);
                        //并还原点击marker样式
                        if (mlastMarker != null) {
                            resetlastmarker();
                        }
                        //清理之前搜索结果的marker
                        if (poiOverlay != null) {
                            poiOverlay.removeFromMap();
                        }
                        aMap.clear();
                        poiOverlay = new myPoiOverlay(aMap, poiItems);
                        poiOverlay.addToMap();
                        poiOverlay.zoomToSpan();

                        aMap.addMarker(new MarkerOptions()
                                .anchor(0.5f, 0.5f)
                                .icon(BitmapDescriptorFactory
                                        .fromBitmap(BitmapFactory.decodeResource(
                                                getResources(), R.drawable.point4)))
                                .position(new LatLng(lp.getLatitude(), lp.getLongitude())));

                        aMap.addCircle(new CircleOptions()
                                .center(new LatLng(lp.getLatitude(),
                                        lp.getLongitude())).radius(5000)
                                .strokeColor(Color.BLUE)
                                .fillColor(Color.argb(50, 1, 1, 1))
                                .strokeWidth(2));

                    } else if (suggestionCities != null
                            && suggestionCities.size() > 0) {
                        showSuggestCity(suggestionCities);
                    } else {
                        makeText(this, R.string.no_result, LENGTH_LONG).show();
                    }
                }
            } else {
                makeText(this,"error",Toast.LENGTH_SHORT).show();
                makeText(this, R.string.no_result, LENGTH_LONG).show();
            }
        }
    }

    private void showSuggestCity(List<SuggestionCity> cities) {
        String infomation = "推荐城市\n";
        for (int i = 0; i < cities.size(); i++) {
            infomation += "城市名称:" + cities.get(i).getCityName() + "城市区号:"
                    + cities.get(i).getCityCode() + "城市编码:"
                    + cities.get(i).getAdCode() + "\n";
        }
        Toast.makeText(this,infomation,Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        if (marker.getObject() != null) {
            whetherToShowDetailInfo(true);
            try {
                PoiItem mCurrentPoi = (PoiItem) marker.getObject();
                if (mlastMarker == null) {
                    mlastMarker = marker;
                } else {
                    // 将之前被点击的marker置为原来的状态
                    resetlastmarker();
                    mlastMarker = marker;
                }
                detailMarker = marker;
                detailMarker.setIcon(BitmapDescriptorFactory
                        .fromBitmap(BitmapFactory.decodeResource(
                                getResources(),
                                R.drawable.poi_marker_pressed)));

                setPoiItemDisplayContent(mCurrentPoi);
            } catch (Exception e) {
                // TODO: handle exception
            }
        } else {
            whetherToShowDetailInfo(false);
            resetlastmarker();
        }
        return true;
    }

    @Override
    public void onPoiItemSearched(PoiItem poiItem, int i) {

    }

    private void resetlastmarker() {
        int index = poiOverlay.getPoiIndex(mlastMarker);
        if (index < 10) {
            mlastMarker.setIcon(BitmapDescriptorFactory
                    .fromBitmap(BitmapFactory.decodeResource(
                            getResources(),
                            markers[index])));
        } else {
            mlastMarker.setIcon(BitmapDescriptorFactory.fromBitmap(
                    BitmapFactory.decodeResource(getResources(), R.drawable.marker_other_highlight)));
        }
        mlastMarker = null;
    }

    @Override
    public void onInfoWindowClick(Marker marker) {
    }

    @Override
    public View getInfoWindow(Marker marker) {
        return null;
    }

    @Override
    public View getInfoContents(Marker marker) {
        return null;
    }

    private void whetherToShowDetailInfo(boolean isToShow) {
        if (isToShow) {
            mSousuo_caidan.setVisibility(View.VISIBLE);
        } else {
            mSousuo_caidan.setVisibility(View.GONE);
        }
    }

    @Override
    public void onMapClick(LatLng latLng) {
        whetherToShowDetailInfo(false);
        if (mlastMarker != null) {
            resetlastmarker();
        }
    }

    private class myPoiOverlay {
        private AMap mamap;
        private List<PoiItem> mPois;
        private ArrayList<Marker> mPoiMarks = new ArrayList<Marker>();

        public myPoiOverlay(AMap amap, List<PoiItem> pois) {
            mamap = amap;
            mPois = pois;
        }

        public void addToMap() {
            for (int i = 0; i < mPois.size(); i++) {
                Marker marker = mamap.addMarker(getMarkerOptions(i));
                PoiItem item = mPois.get(i);
                marker.setObject(item);
                mPoiMarks.add(marker);
            }
        }

        public void removeFromMap() {
            for (Marker mark : mPoiMarks) {
                mark.remove();
            }
        }

        public void zoomToSpan() {
            if (mPois != null && mPois.size() > 0) {
                if (mamap == null)
                    return;
                LatLngBounds bounds = getLatLngBounds();
                mamap.moveCamera(CameraUpdateFactory.newLatLngBounds(bounds, 100));
            }
        }

        private LatLngBounds getLatLngBounds() {
            LatLngBounds.Builder b = LatLngBounds.builder();
            for (int i = 0; i < mPois.size(); i++) {
                b.include(new LatLng(mPois.get(i).getLatLonPoint().getLatitude(),
                        mPois.get(i).getLatLonPoint().getLongitude()));
            }
            return b.build();
        }

        protected MarkerOptions getMarkerOptions(int index) {
            return new MarkerOptions()
                    .position(
                            new LatLng(mPois.get(index).getLatLonPoint()
                                    .getLatitude(), mPois.get(index)
                                    .getLatLonPoint().getLongitude()))
                    .title(getTitle(index)).snippet(getSnippet(index))
                    .icon(getBitmapDescriptor(index));
        }

        private String getTitle(int index) {
            return mPois.get(index).getTitle();
        }

        protected String getSnippet(int index) {
            return mPois.get(index).getSnippet();
        }

        public int getPoiIndex(Marker marker) {
            for (int i = 0; i < mPoiMarks.size(); i++) {
                if (mPoiMarks.get(i).equals(marker)) {
                    return i;
                }
            }
            return -1;
        }

        public PoiItem getPoiItem(int index) {
            if (index < 0 || index >= mPois.size()) {
                return null;
            }
            return mPois.get(index);
        }

        protected BitmapDescriptor getBitmapDescriptor(int arg0) {
            if (arg0 < 10) {
                BitmapDescriptor icon = BitmapDescriptorFactory.fromBitmap(
                        BitmapFactory.decodeResource(getResources(), markers[arg0]));
                return icon;
            } else {
                BitmapDescriptor icon = BitmapDescriptorFactory.fromBitmap(
                        BitmapFactory.decodeResource(getResources(), R.drawable.marker_other_highlight));
                return icon;
            }
        }
    }
}
