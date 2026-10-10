package io.rong.imkit.plugin.location;

import android.os.Bundle;
import android.widget.TextView;
import cn.qqtheme.framework.widget.WheelView;
import com.amap.api.maps.AMap;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.MapView;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import io.rong.imkit.R;
import io.rong.imkit.RongBaseActivity;
import io.rong.message.LocationMessage;

/* JADX INFO: loaded from: classes5.dex */
public class AMapPreviewActivity extends RongBaseActivity {
    private MapView mAMapView;

    private void initMap() {
        AMap map = this.mAMapView.getMap();
        map.setMyLocationEnabled(false);
        map.getUiSettings().setTiltGesturesEnabled(false);
        map.getUiSettings().setZoomControlsEnabled(false);
        map.getUiSettings().setMyLocationButtonEnabled(false);
        LocationMessage locationMessage = (LocationMessage) getIntent().getParcelableExtra("location");
        double lat = locationMessage.getLat();
        double lng = locationMessage.getLng();
        Marker markerAddMarker = map.addMarker(new MarkerOptions().anchor(0.5f, 0.5f).position(new LatLng(lat, lng)).title(locationMessage.getPoi()).snippet(lat + "," + lng).draggable(false));
        map.setInfoWindowAdapter(new AmapInfoWindowAdapter(this));
        markerAddMarker.showInfoWindow();
        map.moveCamera(CameraUpdateFactory.newCameraPosition(new CameraPosition.Builder().target(new LatLng(lat, lng)).zoom(16.0f).bearing(WheelView.DividerConfig.FILL).build()));
    }

    @Override // io.rong.imkit.RongBaseActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.rc_location_preview_activity);
        this.mAMapView = findViewById(R.id.rc_ext_amap);
        this.mAMapView.onCreate(bundle);
        ((TextView) findViewById(R.id.rc_action_bar_title)).setText(R.string.rc_plugin_location);
        onCreateActionbar(new RongBaseActivity.ActionBar());
        initMap();
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        this.mAMapView.onDestroy();
        super.onDestroy();
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        this.mAMapView.onPause();
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
