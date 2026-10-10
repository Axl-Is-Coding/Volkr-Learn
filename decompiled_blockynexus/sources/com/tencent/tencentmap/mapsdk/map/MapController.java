package com.tencent.tencentmap.mapsdk.map;

import android.graphics.Rect;
import com.tencent.mapsdk.raster.model.GeoPoint;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.raster.model.Marker;
import com.tencent.mapsdk.rastercore.f.b;
import com.tencent.tencentmap.mapsdk.map.TencentMap;

/* JADX INFO: loaded from: classes5.dex */
public class MapController {
    private boolean animateEable = true;
    private MapView mapView;

    public MapController(MapView mapView) {
        this.mapView = mapView;
    }

    public void animateTo(GeoPoint geoPoint) {
        this.mapView.getMap().animateTo(b.a(geoPoint));
    }

    public void animateTo(GeoPoint geoPoint, long j, CancelableCallback cancelableCallback) {
        this.mapView.getMap().animateTo(b.a(geoPoint), j, cancelableCallback);
    }

    public void animateTo(GeoPoint geoPoint, Runnable runnable) {
        this.mapView.getMap().animateTo(b.a(geoPoint), runnable);
    }

    public void animateTo(LatLng latLng, long j, CancelableCallback cancelableCallback) {
        this.mapView.getMap().animateTo(latLng, j, cancelableCallback);
    }

    public Projection getProjection() {
        return this.mapView.getProjection();
    }

    public void getScreenShot(TencentMap.OnScreenShotListener onScreenShotListener) {
        this.mapView.getMap().getScreenShot(onScreenShotListener);
    }

    public void getScreenShot(TencentMap.OnScreenShotListener onScreenShotListener, Rect rect) {
        this.mapView.getMap().getScreenShot(onScreenShotListener, rect);
    }

    public boolean isAnimateEable() {
        return this.animateEable;
    }

    public void scrollBy(float f2, float f3) {
        this.mapView.getMap().scrollBy(f2, f3);
    }

    public void scrollBy(float f2, float f3, long j, CancelableCallback cancelableCallback) {
        this.mapView.getMap().scrollBy(f2, f3, j, cancelableCallback);
    }

    public void setAnimateEable(boolean z) {
        this.animateEable = z;
    }

    public void setCenter(GeoPoint geoPoint) {
        this.mapView.getMap().setCenter(b.a(geoPoint));
    }

    public void setInfoWindowAdapter(TencentMap.InfoWindowAdapter infoWindowAdapter) {
        this.mapView.getMap().setInfoWindowAdapter(infoWindowAdapter);
    }

    public void setOnInfoWindowClickListener(TencentMap.OnInfoWindowClickListener onInfoWindowClickListener) {
        this.mapView.getMap().setOnInfoWindowClickListener(onInfoWindowClickListener);
    }

    public void setOnMapCameraChangeListener(TencentMap.OnMapCameraChangeListener onMapCameraChangeListener) {
        this.mapView.getMap().setOnMapCameraChangeListener(onMapCameraChangeListener);
    }

    public void setOnMapClickListener(TencentMap.OnMapClickListener onMapClickListener) {
        this.mapView.getMap().setOnMapClickListener(onMapClickListener);
    }

    public void setOnMapHitListener(final OnMapHitListener onMapHitListener) {
        this.mapView.getMap().setOnMapClickListener(new TencentMap.OnMapClickListener() { // from class: com.tencent.tencentmap.mapsdk.map.MapController.3
            @Override // com.tencent.tencentmap.mapsdk.map.TencentMap.OnMapClickListener
            public void onMapClick(LatLng latLng) {
                onMapHitListener.onMapClick(latLng);
            }
        });
    }

    public void setOnMapLoadedListener(final OnLoadedListener onLoadedListener) {
        this.mapView.getMap().setOnMapLoadedListener(new TencentMap.OnMapLoadedListener() { // from class: com.tencent.tencentmap.mapsdk.map.MapController.1
            @Override // com.tencent.tencentmap.mapsdk.map.TencentMap.OnMapLoadedListener
            public void onMapLoaded() {
                onLoadedListener.onMapLoaded();
            }
        });
    }

    public void setOnMapLoadedListener(TencentMap.OnMapLoadedListener onMapLoadedListener) {
        this.mapView.getMap().setOnMapLoadedListener(onMapLoadedListener);
    }

    public void setOnMapLongClickLisener(TencentMap.OnMapLongClickListener onMapLongClickListener) {
        this.mapView.getMap().setOnMapLongClickListener(onMapLongClickListener);
    }

    public void setOnMapPressClickLisener(final OnMapLongPressListener onMapLongPressListener) {
        this.mapView.getMap().setOnMapLongClickListener(new TencentMap.OnMapLongClickListener() { // from class: com.tencent.tencentmap.mapsdk.map.MapController.4
            @Override // com.tencent.tencentmap.mapsdk.map.TencentMap.OnMapLongClickListener
            public void onMapLongClick(LatLng latLng) {
                onMapLongPressListener.onMapLongPress(latLng);
            }
        });
    }

    public void setOnMarkerClickListener(final OnMarkerPressListener onMarkerPressListener) {
        this.mapView.getMap().setOnMarkerClickListener(new TencentMap.OnMarkerClickListener() { // from class: com.tencent.tencentmap.mapsdk.map.MapController.2
            @Override // com.tencent.tencentmap.mapsdk.map.TencentMap.OnMarkerClickListener
            public boolean onMarkerClick(Marker marker) {
                onMarkerPressListener.onMarkerPressed(marker);
                return false;
            }
        });
    }

    public void setOnMarkerClickListener(TencentMap.OnMarkerClickListener onMarkerClickListener) {
        this.mapView.getMap().setOnMarkerClickListener(onMarkerClickListener);
    }

    public void setOnMarkerDragListener(TencentMap.OnMarkerDraggedListener onMarkerDraggedListener) {
        this.mapView.getMap().setOnMarkerDraggedListener(onMarkerDraggedListener);
    }

    public void setZoom(int i) {
        this.mapView.getMap().setZoom(i);
    }

    public void stopAnimation() {
        this.mapView.stopAnimation();
    }

    public void zoomIn() {
        this.mapView.getMap().zoomIn();
    }

    public void zoomInFixing(int i, int i2) {
        this.mapView.getMap().zoomInFixing(i, i2);
    }

    public void zoomOut() {
        this.mapView.getMap().zoomOut();
    }

    public void zoomOutFixing(int i, int i2) {
        this.mapView.getMap().zoomOutFixing(i, i2);
    }

    public void zoomToSpan(int i, int i2) {
        TencentMap map = this.mapView.getMap();
        double d2 = i;
        Double.isNaN(d2);
        double d3 = i2;
        Double.isNaN(d3);
        map.zoomToSpan(d2 / 1000000.0d, d3 / 1000000.0d);
    }

    public void zoomToSpan(GeoPoint geoPoint, GeoPoint geoPoint2) {
        this.mapView.getMap().zoomToSpan(b.a(geoPoint), b.a(geoPoint2));
    }
}
