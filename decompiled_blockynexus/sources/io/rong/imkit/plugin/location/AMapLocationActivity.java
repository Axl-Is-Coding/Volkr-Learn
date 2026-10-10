package io.rong.imkit.plugin.location;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import cn.qqtheme.framework.widget.WheelView;
import com.amap.api.maps.AMap;
import com.amap.api.maps.CameraUpdate;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.LocationSource;
import com.amap.api.maps.MapView;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.maps.model.MyLocationStyle;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.core.PoiItem;
import com.amap.api.services.geocoder.GeocodeResult;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.amap.api.services.geocoder.RegeocodeAddress;
import com.amap.api.services.geocoder.RegeocodeQuery;
import com.amap.api.services.geocoder.RegeocodeResult;
import com.amap.api.services.poisearch.PoiResult;
import com.amap.api.services.poisearch.PoiSearch;
import com.umeng.analytics.pro.b;
import io.rong.common.RLog;
import io.rong.imkit.R;
import io.rong.imkit.RongBaseActivity;
import io.rong.imkit.plugin.LocationConst;
import io.rong.imkit.utilities.RongUtils;
import io.rong.imlib.common.NetUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class AMapLocationActivity extends RongBaseActivity implements View.OnClickListener, AMap.OnCameraChangeListener, LocationSource, GeocodeSearch.OnGeocodeSearchListener, IMyLocationChangedListener {
    private static final int PAGE_COUNT = 20;
    private static final int REQUEST_CODE_ASK_PERMISSIONS = 100;
    private static final int REQUEST_SEARCH_LOCATION = 1;
    private static final String TAG = "AMapLocationActivity";
    private float Y;
    ValueAnimator animator;
    private float downY;
    private float lastY;
    private ProgressBar listLoadingView;
    private ListView listViewNearby;
    private AMap mAMap;
    private MapView mAMapView;
    private BitmapDescriptor mBitmapDescriptor;
    private GeocodeSearch mGeocodeSearch;
    private Handler mHandler;
    private double mLatResult;
    private double mLngResult;
    private LocationSource.OnLocationChangedListener mLocationChangedListener;
    private TextView mLocationTip;
    private Marker mMarker;
    private double mMyLat;
    private double mMyLng;
    private String mMyPoi;
    private String mPoiResult;
    private int mTouchSlop;
    private boolean mUpdateNearby;
    private NearbyListAdapter nearbyListAdapter;
    private Button send;
    private int currentPage = 1;
    private int flag = 0;
    private String cityCode = "";
    private AbsListView.OnScrollListener onScrollListener = new AbsListView.OnScrollListener() { // from class: io.rong.imkit.plugin.location.AMapLocationActivity.8
        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            View childAt;
            if (i == 0 || i + i2 != i3 || (childAt = AMapLocationActivity.this.listViewNearby.getChildAt(AMapLocationActivity.this.listViewNearby.getChildCount() - 1)) == null || childAt.getBottom() != AMapLocationActivity.this.listViewNearby.getHeight()) {
                return;
            }
            AMapLocationActivity.this.loadNextPageNearByView();
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
        }
    };

    private class MapNearbyInfo {
        String address;
        boolean checked;
        double latitude;
        double longitude;
        String name;
        String poi;

        public MapNearbyInfo() {
        }

        public String getAddress() {
            return this.address;
        }

        public boolean getChecked() {
            return this.checked;
        }

        public double getLatitude() {
            return this.latitude;
        }

        public double getLongitude() {
            return this.longitude;
        }

        public String getName() {
            return this.name;
        }

        public String getPoi() {
            return this.poi;
        }

        public void setAddress(String str) {
            this.address = str;
        }

        public void setChecked(boolean z) {
            this.checked = z;
        }

        public void setLatitude(double d2) {
            this.latitude = d2;
        }

        public void setLongitude(double d2) {
            this.longitude = d2;
        }

        public void setName(String str) {
            this.name = str;
        }

        public void setPoi(String str) {
            this.poi = str;
        }

        public MapNearbyInfo(String str, String str2) {
            this.name = str;
            this.address = str2;
        }
    }

    private class NearbyListAdapter extends BaseAdapter {
        Context context;
        List<MapNearbyInfo> nearbyInfoList;

        class NearbyViewHolder {
            ImageView ivNearbyChecked;
            TextView tvNearbyAddress;
            TextView tvNearbyName;

            NearbyViewHolder() {
            }
        }

        public NearbyListAdapter(Context context, List<MapNearbyInfo> list) {
            this.context = context;
            this.nearbyInfoList = list;
        }

        public void addItems(List<MapNearbyInfo> list) {
            List<MapNearbyInfo> list2 = this.nearbyInfoList;
            if (list2 != null) {
                list2.addAll(list);
            }
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.nearbyInfoList.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            List<MapNearbyInfo> list = this.nearbyInfoList;
            if (list == null || list.size() <= 0) {
                return null;
            }
            return this.nearbyInfoList.get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            View viewInflate;
            NearbyViewHolder nearbyViewHolder;
            MapNearbyInfo mapNearbyInfo = this.nearbyInfoList.get(i);
            if (view == null) {
                nearbyViewHolder = new NearbyViewHolder();
                viewInflate = View.inflate(this.context, R.layout.rc_map_nearby_info_item, null);
                nearbyViewHolder.tvNearbyName = (TextView) viewInflate.findViewById(R.id.rc_nearby_name);
                nearbyViewHolder.tvNearbyAddress = (TextView) viewInflate.findViewById(R.id.rc_nearby_address);
                nearbyViewHolder.ivNearbyChecked = (ImageView) viewInflate.findViewById(R.id.rc_nearby_checked);
                viewInflate.setTag(nearbyViewHolder);
            } else {
                viewInflate = view;
                nearbyViewHolder = (NearbyViewHolder) view.getTag();
            }
            if (i == 0) {
                nearbyViewHolder.tvNearbyAddress.setVisibility(8);
                nearbyViewHolder.tvNearbyName.setText(mapNearbyInfo.getName());
            } else {
                nearbyViewHolder.tvNearbyAddress.setVisibility(0);
                nearbyViewHolder.tvNearbyName.setText(mapNearbyInfo.getName());
                nearbyViewHolder.tvNearbyAddress.setText(mapNearbyInfo.getAddress());
            }
            if (mapNearbyInfo.getChecked()) {
                nearbyViewHolder.ivNearbyChecked.setVisibility(0);
            } else {
                nearbyViewHolder.ivNearbyChecked.setVisibility(8);
            }
            return viewInflate;
        }
    }

    private enum ScrollDirection {
        SCROLL_UP,
        SCROLL_DOWN
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addLocatedMarker(LatLng latLng, String str) {
        this.mBitmapDescriptor = BitmapDescriptorFactory.fromResource(R.drawable.rc_ext_location_marker);
        MarkerOptions markerOptionsIcon = new MarkerOptions().position(latLng).icon(this.mBitmapDescriptor);
        Marker marker = this.mMarker;
        if (marker != null) {
            marker.remove();
        }
        this.mMarker = this.mAMap.addMarker(markerOptionsIcon);
        this.mMarker.setPositionByPixels(this.mAMapView.getWidth() / 2, this.mAMapView.getHeight() / 2);
        this.mLocationTip.setText(String.format("%s", str));
    }

    @TargetApi(11)
    private void animMarker() {
        if (Build.VERSION.SDK_INT > 11) {
            ValueAnimator valueAnimator = this.animator;
            if (valueAnimator != null) {
                valueAnimator.start();
                return;
            }
            this.animator = ValueAnimator.ofFloat(this.mAMapView.getHeight() / 2, (this.mAMapView.getHeight() / 2) - 30);
            this.animator.setInterpolator(new DecelerateInterpolator());
            this.animator.setDuration(150L);
            this.animator.setRepeatCount(1);
            this.animator.setRepeatMode(2);
            this.animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: io.rong.imkit.plugin.location.AMapLocationActivity.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    RLog.d(AMapLocationActivity.TAG, "onAnimationUpdate");
                    AMapLocationActivity.this.mMarker.setPositionByPixels(AMapLocationActivity.this.mAMapView.getWidth() / 2, Math.round(((Float) valueAnimator2.getAnimatedValue()).floatValue()));
                }
            });
            this.animator.addListener(new AnimatorListenerAdapter() { // from class: io.rong.imkit.plugin.location.AMapLocationActivity.2
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    AMapLocationActivity.this.mMarker.setIcon(AMapLocationActivity.this.mBitmapDescriptor);
                }
            });
            this.animator.start();
        }
    }

    private String getMapUrl(double d2, double d3) {
        return "http://restapi.amap.com/v3/staticmap?location=" + d3 + "," + d2 + "&zoom=16&scale=2&size=408*240&markers=mid,,A:" + d3 + "," + d2 + "&key=e09af6a2b26c02086e9216bd07c960ae";
    }

    private void handleMyLocation() {
        if (this.mMyPoi == null) {
            LocationManager.getInstance().updateMyLocation();
            return;
        }
        this.mAMap.setOnCameraChangeListener((AMap.OnCameraChangeListener) null);
        this.mAMap.animateCamera(CameraUpdateFactory.changeLatLng(new LatLng(this.mMyLat, this.mMyLng)), new AMap.CancelableCallback() { // from class: io.rong.imkit.plugin.location.AMapLocationActivity.9
            public void onCancel() {
            }

            public void onFinish() {
                AMapLocationActivity.this.mAMap.setOnCameraChangeListener(AMapLocationActivity.this);
            }
        });
        this.mLocationTip.setText(this.mMyPoi);
        this.mLatResult = this.mMyLat;
        this.mLngResult = this.mMyLng;
        this.mPoiResult = this.mMyPoi;
        LatLng latLng = new LatLng(this.mLatResult, this.mLngResult);
        updateNearByView(this.mMyPoi);
        Marker marker = this.mMarker;
        if (marker != null) {
            marker.setPosition(latLng);
        }
    }

    private void handleOkButton() {
        if (this.mLatResult == 0.0d && this.mLngResult == 0.0d && TextUtils.isEmpty(this.mPoiResult)) {
            Toast.makeText(this, getString(R.string.rc_location_temp_failed), 0).show();
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("thumb", getMapUrl(this.mLatResult, this.mLngResult));
        intent.putExtra(b.B, this.mLatResult);
        intent.putExtra(b.C, this.mLngResult);
        intent.putExtra(LocationConst.POI, this.mPoiResult);
        setResult(-1, intent);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean handleScrollState(ScrollDirection scrollDirection) {
        int dimension = (int) getResources().getDimension(R.dimen.rc_ext_location_nearby_list_min_height);
        int dimension2 = (int) getResources().getDimension(R.dimen.rc_ext_location_nearby_list_max_height);
        return scrollDirection == ScrollDirection.SCROLL_DOWN ? updateListViewHeight(dimension2, dimension) : updateListViewHeight(dimension, dimension2);
    }

    private void initMap() {
        this.mAMap = this.mAMapView.getMap();
        this.mAMap.setLocationSource(this);
        this.mAMap.setMyLocationEnabled(true);
        this.mAMap.getUiSettings().setZoomControlsEnabled(false);
        this.mAMap.getUiSettings().setMyLocationButtonEnabled(false);
        this.mAMap.setMapType(1);
        MyLocationStyle myLocationStyle = new MyLocationStyle();
        myLocationStyle.myLocationIcon(BitmapDescriptorFactory.fromResource(R.drawable.rc_ext_my_locator));
        myLocationStyle.strokeWidth(WheelView.DividerConfig.FILL);
        myLocationStyle.strokeColor(R.color.rc_main_theme);
        myLocationStyle.radiusFillColor(0);
        this.mAMap.setMyLocationStyle(myLocationStyle);
        this.mGeocodeSearch = new GeocodeSearch(this);
        this.mGeocodeSearch.setOnGeocodeSearchListener(this);
        LocationManager.getInstance().setMyLocationChangedListener(this);
        this.mAMap.setOnCameraChangeListener(this);
    }

    private void initNearbyView() {
        this.listViewNearby = (ListView) findViewById(R.id.rc_list_nearby);
        this.listLoadingView = (ProgressBar) findViewById(R.id.rc_ext_loading);
        this.listViewNearby.setVisibility(8);
        this.listLoadingView.setVisibility(0);
        this.mTouchSlop = ViewConfiguration.get(this).getScaledTouchSlop();
        this.listViewNearby.setOnScrollListener(this.onScrollListener);
        this.listViewNearby.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: io.rong.imkit.plugin.location.AMapLocationActivity.4
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                for (int i2 = 0; i2 < AMapLocationActivity.this.nearbyListAdapter.getCount(); i2++) {
                    MapNearbyInfo mapNearbyInfo = (MapNearbyInfo) AMapLocationActivity.this.nearbyListAdapter.getItem(i2);
                    if (i2 == i) {
                        mapNearbyInfo.setChecked(true);
                        AMapLocationActivity.this.mLngResult = mapNearbyInfo.getLongitude();
                        AMapLocationActivity.this.mLatResult = mapNearbyInfo.getLatitude();
                        AMapLocationActivity.this.mPoiResult = mapNearbyInfo.getPoi();
                        AMapLocationActivity aMapLocationActivity = AMapLocationActivity.this;
                        aMapLocationActivity.updateCheckedMapView(aMapLocationActivity.mLngResult, AMapLocationActivity.this.mLatResult, AMapLocationActivity.this.mPoiResult);
                    } else {
                        mapNearbyInfo.setChecked(false);
                    }
                }
                AMapLocationActivity.this.nearbyListAdapter.notifyDataSetChanged();
            }
        });
        this.listViewNearby.setOnTouchListener(new View.OnTouchListener() { // from class: io.rong.imkit.plugin.location.AMapLocationActivity.5
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                AMapLocationActivity.this.Y = motionEvent.getRawY();
                int action = motionEvent.getAction();
                if (action == 0) {
                    AMapLocationActivity aMapLocationActivity = AMapLocationActivity.this;
                    aMapLocationActivity.downY = aMapLocationActivity.Y;
                    AMapLocationActivity aMapLocationActivity2 = AMapLocationActivity.this;
                    aMapLocationActivity2.lastY = aMapLocationActivity2.Y;
                } else if (action == 1) {
                    AMapLocationActivity.this.Y = WheelView.DividerConfig.FILL;
                    if (AMapLocationActivity.this.flag == 1) {
                        AMapLocationActivity.this.flag = 0;
                        return true;
                    }
                    AMapLocationActivity.this.lastY = WheelView.DividerConfig.FILL;
                } else if (action == 2 && Math.abs(AMapLocationActivity.this.Y - AMapLocationActivity.this.downY) > AMapLocationActivity.this.mTouchSlop) {
                    if (AMapLocationActivity.this.Y - AMapLocationActivity.this.downY < WheelView.DividerConfig.FILL || AMapLocationActivity.this.Y - AMapLocationActivity.this.lastY < WheelView.DividerConfig.FILL) {
                        AMapLocationActivity aMapLocationActivity3 = AMapLocationActivity.this;
                        aMapLocationActivity3.lastY = aMapLocationActivity3.Y;
                        return AMapLocationActivity.this.handleScrollState(ScrollDirection.SCROLL_UP);
                    }
                    AMapLocationActivity aMapLocationActivity4 = AMapLocationActivity.this;
                    aMapLocationActivity4.lastY = aMapLocationActivity4.Y;
                    return AMapLocationActivity.this.handleScrollState(ScrollDirection.SCROLL_DOWN);
                }
                return false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadNextPageNearByView() {
        PoiSearch.Query query = new PoiSearch.Query("", LocationConst.CATEGORY, "");
        query.setPageSize(20);
        int i = this.currentPage + 1;
        this.currentPage = i;
        query.setPageNum(i);
        PoiSearch poiSearch = new PoiSearch(this, query);
        double d2 = this.mLngResult;
        double d3 = this.mLatResult;
        if (d3 == 0.0d || d2 == 0.0d) {
            Toast.makeText(this, getResources().getString(R.string.rc_location_fail), 0).show();
            return;
        }
        poiSearch.setBound(new PoiSearch.SearchBound(new LatLonPoint(d3, d2), LocationConst.DISTANCE));
        poiSearch.setOnPoiSearchListener(new PoiSearch.OnPoiSearchListener() { // from class: io.rong.imkit.plugin.location.AMapLocationActivity.7
            public void onPoiItemSearched(PoiItem poiItem, int i2) {
            }

            public void onPoiSearched(PoiResult poiResult, int i2) {
                if (poiResult == null || poiResult.getPois().size() <= 0) {
                    return;
                }
                ArrayList arrayList = new ArrayList();
                ArrayList pois = poiResult.getPois();
                for (int i3 = 0; i3 < pois.size(); i3++) {
                    PoiItem poiItem = (PoiItem) pois.get(i3);
                    MapNearbyInfo mapNearbyInfo = AMapLocationActivity.this.new MapNearbyInfo(poiItem.getTitle(), poiItem.getSnippet());
                    mapNearbyInfo.setLongitude(poiItem.getLatLonPoint().getLongitude());
                    mapNearbyInfo.setLatitude(poiItem.getLatLonPoint().getLatitude());
                    mapNearbyInfo.setPoi(poiItem.getTitle());
                    arrayList.add(mapNearbyInfo);
                }
                AMapLocationActivity.this.nearbyListAdapter.addItems(arrayList);
                AMapLocationActivity.this.nearbyListAdapter.notifyDataSetChanged();
            }
        });
        poiSearch.searchPOIAsyn();
    }

    private void resetViewHeight() {
        if (this.listViewNearby != null) {
            int dimension = (int) getResources().getDimension(R.dimen.rc_ext_location_nearby_list_min_height);
            ViewGroup.LayoutParams layoutParams = this.listViewNearby.getLayoutParams();
            layoutParams.height = dimension;
            this.listViewNearby.setLayoutParams(layoutParams);
        }
        final FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.mLocationTip.getLayoutParams();
        layoutParams2.setMargins(RongUtils.dip2px(20.0f), RongUtils.dip2px(20.0f), RongUtils.dip2px(20.0f), 0);
        this.mLocationTip.post(new Runnable() { // from class: io.rong.imkit.plugin.location.AMapLocationActivity.10
            @Override // java.lang.Runnable
            public void run() {
                AMapLocationActivity.this.mLocationTip.setLayoutParams(layoutParams2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateCheckedMapView(double d2, double d3, String str) {
        updateToPosition(d2, d3, str, false);
    }

    private boolean updateListViewHeight(int i, int i2) {
        int height = this.listViewNearby.getHeight();
        ListView listView = this.listViewNearby;
        if (listView != null && listView.getChildAt(0) != null) {
            if (this.listViewNearby.getChildAt(0).getTop() == 0 && Math.abs(this.Y - this.downY) > this.mTouchSlop && this.flag == 0 && height == i) {
                this.flag = 1;
            }
            if (this.flag == 1) {
                ViewGroup.LayoutParams layoutParams = this.listViewNearby.getLayoutParams();
                layoutParams.height = i2;
                this.listViewNearby.setLayoutParams(layoutParams);
                LatLng latLng = new LatLng(this.mLatResult, this.mLngResult);
                Marker marker = this.mMarker;
                if (marker != null) {
                    marker.setPosition(latLng);
                }
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.mLocationTip.getLayoutParams();
                if (i < i2) {
                    layoutParams2.setMargins(RongUtils.dip2px(20.0f), RongUtils.dip2px(3.0f), RongUtils.dip2px(20.0f), 0);
                    this.mLocationTip.setLayoutParams(layoutParams2);
                } else {
                    layoutParams2.setMargins(RongUtils.dip2px(20.0f), RongUtils.dip2px(20.0f), RongUtils.dip2px(20.0f), 0);
                    this.mLocationTip.setLayoutParams(layoutParams2);
                }
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateNearByView(final String str) {
        PoiSearch.Query query = new PoiSearch.Query("", LocationConst.CATEGORY, "");
        query.setPageSize(20);
        this.currentPage = 1;
        query.setPageNum(this.currentPage);
        PoiSearch poiSearch = new PoiSearch(this, query);
        double d2 = this.mLngResult;
        double d3 = this.mLatResult;
        if (d3 == 0.0d || d2 == 0.0d) {
            this.listViewNearby.setVisibility(0);
            this.listLoadingView.setVisibility(8);
            Toast.makeText(this, getResources().getString(R.string.rc_location_fail), 0).show();
        } else {
            poiSearch.setBound(new PoiSearch.SearchBound(new LatLonPoint(d3, d2), LocationConst.DISTANCE));
            poiSearch.setOnPoiSearchListener(new PoiSearch.OnPoiSearchListener() { // from class: io.rong.imkit.plugin.location.AMapLocationActivity.6
                public void onPoiItemSearched(PoiItem poiItem, int i) {
                }

                public void onPoiSearched(PoiResult poiResult, int i) {
                    if (poiResult == null || poiResult.getPois().size() <= 0) {
                        return;
                    }
                    ArrayList arrayList = new ArrayList();
                    ArrayList pois = poiResult.getPois();
                    MapNearbyInfo mapNearbyInfo = AMapLocationActivity.this.new MapNearbyInfo();
                    mapNearbyInfo.setName(str);
                    mapNearbyInfo.setChecked(true);
                    mapNearbyInfo.setLongitude(AMapLocationActivity.this.mLngResult);
                    mapNearbyInfo.setLatitude(AMapLocationActivity.this.mLatResult);
                    mapNearbyInfo.setPoi(str);
                    arrayList.add(mapNearbyInfo);
                    for (int i2 = 0; i2 < pois.size(); i2++) {
                        PoiItem poiItem = (PoiItem) pois.get(i2);
                        MapNearbyInfo mapNearbyInfo2 = AMapLocationActivity.this.new MapNearbyInfo(poiItem.getTitle(), poiItem.getSnippet());
                        mapNearbyInfo2.setLongitude(poiItem.getLatLonPoint().getLongitude());
                        mapNearbyInfo2.setLatitude(poiItem.getLatLonPoint().getLatitude());
                        mapNearbyInfo2.setPoi(poiItem.getTitle());
                        arrayList.add(mapNearbyInfo2);
                    }
                    AMapLocationActivity aMapLocationActivity = AMapLocationActivity.this;
                    aMapLocationActivity.nearbyListAdapter = aMapLocationActivity.new NearbyListAdapter(aMapLocationActivity, arrayList);
                    AMapLocationActivity.this.listViewNearby.setAdapter((ListAdapter) AMapLocationActivity.this.nearbyListAdapter);
                    AMapLocationActivity.this.listViewNearby.setVisibility(0);
                    AMapLocationActivity.this.listLoadingView.setVisibility(8);
                }
            });
            poiSearch.searchPOIAsyn();
        }
    }

    private void updateToPosition(double d2, double d3, String str, boolean z) {
        if (str != null) {
            this.mLatResult = d3;
            this.mLngResult = d2;
            this.mPoiResult = str;
            this.mLocationTip.setText(this.mPoiResult);
            this.mUpdateNearby = z;
            if (z) {
                updateNearByView(this.mPoiResult);
            }
            final LatLng latLng = new LatLng(this.mLatResult, this.mLngResult);
            CameraUpdate cameraUpdateChangeLatLng = CameraUpdateFactory.changeLatLng(latLng);
            this.mAMap.setOnCameraChangeListener((AMap.OnCameraChangeListener) null);
            this.mAMap.animateCamera(cameraUpdateChangeLatLng, new AMap.CancelableCallback() { // from class: io.rong.imkit.plugin.location.AMapLocationActivity.11
                public void onCancel() {
                }

                public void onFinish() {
                    AMapLocationActivity.this.mAMap.setOnCameraChangeListener(AMapLocationActivity.this);
                    if (AMapLocationActivity.this.mMarker != null) {
                        AMapLocationActivity.this.mMarker.setPosition(latLng);
                    }
                }
            });
        }
    }

    public void activate(LocationSource.OnLocationChangedListener onLocationChangedListener) {
        this.mLocationChangedListener = onLocationChangedListener;
    }

    public void deactivate() {
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i != 1 || intent == null) {
            return;
        }
        this.mLngResult = intent.getDoubleExtra(LocationConst.LONGITUDE, 0.0d);
        this.mLatResult = intent.getDoubleExtra(LocationConst.LATITUDE, 0.0d);
        this.mPoiResult = intent.getStringExtra(LocationConst.POI);
        resetViewHeight();
        updateToPosition(this.mLngResult, this.mLatResult, this.mPoiResult, true);
    }

    public void onCameraChange(CameraPosition cameraPosition) {
        RLog.d(TAG, "onCameraChange");
        if (Build.VERSION.SDK_INT < 11) {
            this.mMarker.setPosition(cameraPosition.target);
        }
    }

    public void onCameraChangeFinish(CameraPosition cameraPosition) {
        RLog.d(TAG, "onCameraChangeFinish");
        if (!this.mUpdateNearby) {
            this.mUpdateNearby = true;
            return;
        }
        this.mGeocodeSearch.getFromLocationAsyn(new RegeocodeQuery(new LatLonPoint(cameraPosition.target.latitude, cameraPosition.target.longitude), 50.0f, "autonavi"));
        if (this.mMarker != null) {
            animMarker();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.rc_ext_my_location) {
            handleMyLocation();
            return;
        }
        if (view.getId() == R.id.rc_action_bar_ok) {
            handleOkButton();
        } else if (view.getId() == R.id.rc_search) {
            Intent intent = new Intent(this, (Class<?>) SearchLocationActivity.class);
            intent.putExtra(LocationConst.CITY_CODE, this.cityCode);
            startActivityForResult(intent, 1);
        }
    }

    @Override // io.rong.imkit.RongBaseActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.rc_plugin_location_activity);
        this.mAMapView = findViewById(R.id.rc_ext_amap);
        initNearbyView();
        this.mHandler = new Handler();
        this.mLocationTip = (TextView) findViewById(R.id.rc_ext_location_marker);
        this.searchButton.setVisibility(0);
        this.searchButton.setOnClickListener(this);
        ((ImageView) findViewById(R.id.rc_ext_my_location)).setOnClickListener(this);
        this.send = (Button) findViewById(R.id.rc_action_bar_ok);
        this.send.setText(getResources().getString(R.string.rc_ext_send));
        this.send.setVisibility(0);
        this.send.setOnClickListener(this);
        if (NetUtils.isNetWorkAvailable(this)) {
            this.send.setEnabled(true);
            this.send.setTextColor(getResources().getColor(R.color.rc_map_send_enabled));
        } else {
            this.send.setEnabled(false);
            this.send.setTextColor(getResources().getColor(R.color.rc_map_send_not_enabled));
        }
        this.mAMapView.onCreate(bundle);
        initMap();
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        this.mAMapView.onDestroy();
        LocationManager.getInstance().setMyLocationChangedListener(null);
        super.onDestroy();
    }

    public void onGeocodeSearched(GeocodeResult geocodeResult, int i) {
    }

    @Override // io.rong.imkit.plugin.location.IMyLocationChangedListener
    public void onMyLocationChanged(final AMapLocationInfo aMapLocationInfo) {
        RLog.d(TAG, "onLocationChanged");
        if (this.mLocationChangedListener != null) {
            this.mHandler.post(new Runnable() { // from class: io.rong.imkit.plugin.location.AMapLocationActivity.3
                @Override // java.lang.Runnable
                public void run() {
                    AMapLocationInfo aMapLocationInfo2 = aMapLocationInfo;
                    if (aMapLocationInfo2 == null) {
                        AMapLocationActivity aMapLocationActivity = AMapLocationActivity.this;
                        Toast.makeText(aMapLocationActivity, aMapLocationActivity.getString(R.string.rc_location_fail), 0).show();
                        return;
                    }
                    AMapLocationActivity aMapLocationActivity2 = AMapLocationActivity.this;
                    double lat = aMapLocationInfo2.getLat();
                    aMapLocationActivity2.mLatResult = lat;
                    aMapLocationActivity2.mMyLat = lat;
                    AMapLocationActivity aMapLocationActivity3 = AMapLocationActivity.this;
                    double lng = aMapLocationInfo.getLng();
                    aMapLocationActivity3.mLngResult = lng;
                    aMapLocationActivity3.mMyLng = lng;
                    AMapLocationActivity aMapLocationActivity4 = AMapLocationActivity.this;
                    String str = aMapLocationInfo.getStreet() + aMapLocationInfo.getPoiname();
                    aMapLocationActivity4.mPoiResult = str;
                    aMapLocationActivity4.mMyPoi = str;
                    AMapLocationActivity.this.cityCode = aMapLocationInfo.getCitycode();
                    AMapLocationActivity aMapLocationActivity5 = AMapLocationActivity.this;
                    aMapLocationActivity5.updateNearByView(aMapLocationActivity5.mMyPoi);
                    Location location = new Location("AMap");
                    location.setLatitude(aMapLocationInfo.getLat());
                    location.setLongitude(aMapLocationInfo.getLng());
                    location.setTime(aMapLocationInfo.getTime());
                    location.setAccuracy(aMapLocationInfo.getAccuracy());
                    AMapLocationActivity.this.mLocationChangedListener.onLocationChanged(location);
                    LatLng latLng = new LatLng(AMapLocationActivity.this.mLatResult, AMapLocationActivity.this.mLngResult);
                    AMapLocationActivity aMapLocationActivity6 = AMapLocationActivity.this;
                    aMapLocationActivity6.addLocatedMarker(latLng, aMapLocationActivity6.mPoiResult);
                    AMapLocationActivity.this.mAMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 17.0f));
                }
            });
        }
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        this.mAMapView.onPause();
    }

    public void onRegeocodeSearched(RegeocodeResult regeocodeResult, int i) {
        RLog.e(TAG, "onRegeocodeSearched");
        if (regeocodeResult == null) {
            this.send.setEnabled(false);
            this.send.setTextColor(getResources().getColor(R.color.rc_map_send_not_enabled));
            Toast.makeText(this, getString(R.string.rc_location_fail), 0).show();
            return;
        }
        RegeocodeAddress regeocodeAddress = regeocodeResult.getRegeocodeAddress();
        this.mLatResult = regeocodeResult.getRegeocodeQuery().getPoint().getLatitude();
        this.mLngResult = regeocodeResult.getRegeocodeQuery().getPoint().getLongitude();
        this.mPoiResult = regeocodeResult.getRegeocodeAddress().getFormatAddress().replace(regeocodeAddress.getProvince(), "").replace(regeocodeAddress.getCity(), "").replace(regeocodeAddress.getDistrict(), "");
        this.mLocationTip.setText(this.mPoiResult);
        updateNearByView(this.mPoiResult);
        this.send.setEnabled(true);
        this.send.setTextColor(getResources().getColor(R.color.rc_map_send_enabled));
    }

    @Override // io.rong.imkit.RongBaseActivity, android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i != 100) {
            super.onRequestPermissionsResult(i, strArr, iArr);
        } else if (iArr[0] == 0 && strArr[0].equals("android.permission.ACCESS_COARSE_LOCATION")) {
            initMap();
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        this.mAMapView.onResume();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.mAMapView.onSaveInstanceState(bundle);
    }
}
