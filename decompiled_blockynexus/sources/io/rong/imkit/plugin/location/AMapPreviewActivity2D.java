package io.rong.imkit.plugin.location;

import android.os.Bundle;
import android.widget.TextView;
import cn.qqtheme.framework.widget.WheelView;
import com.amap.api.maps2d.AMap;
import com.amap.api.maps2d.CameraUpdateFactory;
import com.amap.api.maps2d.MapView;
import com.amap.api.maps2d.model.CameraPosition;
import com.amap.api.maps2d.model.LatLng;
import com.amap.api.maps2d.model.Marker;
import com.amap.api.maps2d.model.MarkerOptions;
import io.rong.imkit.R;
import io.rong.imkit.RongBaseActivity;
import io.rong.message.LocationMessage;

/* JADX INFO: loaded from: classes5.dex */
public class AMapPreviewActivity2D extends RongBaseActivity {
    private MapView mAMapView;

    private void initMap() {
        AMap map = this.mAMapView.getMap();
        map.setMyLocationEnabled(true);
        map.getUiSettings().setZoomControlsEnabled(false);
        map.getUiSettings().setMyLocationButtonEnabled(false);
        LocationMessage locationMessage = (LocationMessage) getIntent().getParcelableExtra("location");
        double lat = locationMessage.getLat();
        double lng = locationMessage.getLng();
        Marker markerAddMarker = map.addMarker(new MarkerOptions().anchor(0.5f, 0.5f).position(new LatLng(lat, lng)).title(locationMessage.getPoi()).snippet(lat + "," + lng).draggable(false));
        map.setInfoWindowAdapter(new AmapInfoWindowAdapter2D(this));
        markerAddMarker.showInfoWindow();
        map.moveCamera(CameraUpdateFactory.newCameraPosition(new CameraPosition.Builder().target(new LatLng(lat, lng)).zoom(16.0f).bearing(WheelView.DividerConfig.FILL).tilt(30.0f).build()));
    }

    @Override // io.rong.imkit.RongBaseActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.rc_location_preview_activity_2d);
        this.mAMapView = findViewById(R.id.rc_ext_amap);
        this.mAMapView.onCreate(bundle);
        ((TextView) findViewById(R.id.rc_action_bar_title)).setText(R.string.rc_plugin_location);
        initMap();
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        this.mAMapView.onDestroy();
        super.onDestroy();
    }
}
