package com.tencent.tencentmap.mapsdk.map;

import com.tencent.mapsdk.raster.model.BitmapDescriptor;
import com.tencent.mapsdk.raster.model.Circle;
import com.tencent.mapsdk.raster.model.CircleOptions;
import com.tencent.mapsdk.raster.model.GroundOverlay;
import com.tencent.mapsdk.raster.model.GroundOverlayOptions;
import com.tencent.mapsdk.raster.model.IOverlay;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.raster.model.Marker;
import com.tencent.mapsdk.raster.model.MarkerOptions;
import com.tencent.mapsdk.raster.model.Polygon;
import com.tencent.mapsdk.raster.model.PolygonOptions;
import com.tencent.mapsdk.raster.model.Polyline;
import com.tencent.mapsdk.raster.model.PolylineOptions;

/* JADX INFO: loaded from: classes5.dex */
public class MapFragmentUtil {
    UiSettings mUi;
    MapView mapView;
    TencentMap tencentMap;

    public MapFragmentUtil(QSupportMapFragment qSupportMapFragment) {
        this.mapView = qSupportMapFragment.getMapView();
        this.mUi = this.mapView.getUiSettings();
        this.tencentMap = this.mapView.getMap();
        this.mUi.setLogoPosition(1);
        setScaleControlsEnable(true);
        this.mUi.setScaleViewPosition(0);
    }

    public Circle addCircle(CircleOptions circleOptions) {
        return this.mapView.addCircle(circleOptions);
    }

    public GroundOverlay addGroundOverlay(GroundOverlayOptions groundOverlayOptions) {
        return this.mapView.getMap().addGroundOverlay(groundOverlayOptions);
    }

    public Marker addMarker(MarkerOptions markerOptions) {
        Marker markerAddMarker = this.mapView.addMarker(markerOptions);
        invalidate();
        return markerAddMarker;
    }

    public GroundOverlay addOverlay(BitmapDescriptor bitmapDescriptor, LatLng latLng, LatLng latLng2) {
        return this.mapView.addOverlay(bitmapDescriptor.getBitmap(), latLng, latLng2);
    }

    public Polygon addPolygon(PolygonOptions polygonOptions) {
        return this.mapView.addPolygon(polygonOptions);
    }

    public Polyline addPolyline(PolylineOptions polylineOptions) {
        return this.mapView.addPolyline(polylineOptions);
    }

    public void clearAllOverlays() {
        this.mapView.clearAllOverlays();
    }

    public int getLatitudeSpan() {
        return this.mapView.getLatitudeSpan();
    }

    public int getLongitudeSpan() {
        return this.mapView.getLongitudeSpan();
    }

    public LatLng getMapCenter() {
        return this.mapView.getMapCenter();
    }

    public MapController getMapController() {
        return this.mapView.getController();
    }

    public float getScalePerPixel() {
        return this.mapView.getScalePerPixel();
    }

    public int getZoomLevel() {
        return this.tencentMap.getZoomLevel();
    }

    public void invalidate() {
        this.mapView.getMapContext().a(false, false);
    }

    public boolean isSatellite() {
        return this.tencentMap.isSatelliteEnabled();
    }

    public void moveCamera(CameraUpdate cameraUpdate) {
        this.mapView.moveCamera(cameraUpdate);
    }

    public void postInvalidate() {
        refreshMap();
    }

    public void refreshMap() {
        this.mapView.getMapContext().a(false, false);
    }

    public void removeOverlay(IOverlay iOverlay) {
        this.mapView.removeOverlay(iOverlay);
    }

    public void setLogoPosition(int i) {
        this.mUi.setLogoPosition(i);
    }

    public void setPinchEnabeled(boolean z) {
        this.mUi.setZoomGesturesEnabled(z);
    }

    public void setSatellite(boolean z) {
        this.tencentMap.setSatelliteEnabled(z);
    }

    public void setScaleControlsEnable(boolean z) {
        this.mUi.setScaleControlsEnabled(z);
    }

    public void setScaleViewPosition(int i) {
        this.mUi.setScaleViewPosition(i);
    }

    public void setScrollGesturesEnabled(boolean z) {
        this.mUi.setScrollGesturesEnabled(z);
    }
}
