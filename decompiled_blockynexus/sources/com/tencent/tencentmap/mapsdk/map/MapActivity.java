package com.tencent.tencentmap.mapsdk.map;

import android.app.Activity;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public abstract class MapActivity extends Activity {
    private List<MapView> mapViewList = new ArrayList();
    private Bundle mysavedInstanceState;

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mysavedInstanceState = bundle;
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        for (MapView mapView : this.mapViewList) {
            if (mapView != null) {
                mapView.onDestroy();
            }
        }
        this.mapViewList.clear();
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        for (MapView mapView : this.mapViewList) {
            if (mapView != null) {
                mapView.onPause();
            }
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        for (MapView mapView : this.mapViewList) {
            if (mapView != null) {
                mapView.onResume();
            }
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        for (MapView mapView : this.mapViewList) {
            if (mapView != null) {
                mapView.onSaveInstanceState(bundle);
            }
        }
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        for (MapView mapView : this.mapViewList) {
            if (mapView != null) {
                mapView.onStop();
            }
        }
    }

    protected void setMapView(MapView mapView) {
        this.mapViewList.add(mapView);
        mapView.onCreate(this.mysavedInstanceState);
    }
}
