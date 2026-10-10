package com.tencent.tencentmap.mapsdk.map;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;
import com.tencent.mapsdk.raster.model.CameraPosition;
import com.tencent.mapsdk.raster.model.Circle;
import com.tencent.mapsdk.raster.model.CircleOptions;
import com.tencent.mapsdk.raster.model.GroundOverlay;
import com.tencent.mapsdk.raster.model.GroundOverlayOptions;
import com.tencent.mapsdk.raster.model.IOverlay;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.raster.model.LatLngBounds;
import com.tencent.mapsdk.raster.model.Marker;
import com.tencent.mapsdk.raster.model.MarkerOptions;
import com.tencent.mapsdk.raster.model.Polygon;
import com.tencent.mapsdk.raster.model.PolygonOptions;
import com.tencent.mapsdk.raster.model.Polyline;
import com.tencent.mapsdk.raster.model.PolylineOptions;
import com.tencent.mapsdk.raster.model.QMapLanguage;
import com.tencent.mapsdk.raster.model.TileOverlay;
import com.tencent.mapsdk.raster.model.TileOverlayOptions;
import com.tencent.mapsdk.rastercore.d.a;
import com.tencent.mapsdk.rastercore.d.c;
import com.tencent.mapsdk.rastercore.d.f;
import com.tencent.mapsdk.rastercore.tile.MapTile;

/* JADX INFO: loaded from: classes5.dex */
public class TencentMap {
    private static OnErrorListener onErrorListener;
    private a contentLayer;
    private f mapContext;
    private c projection;

    public interface InfoWindowAdapter {
        View getInfoWindow(Marker marker);

        void onInfoWindowDettached(Marker marker, View view);
    }

    public interface OnErrorListener {
        void collectErrorInfo(String str);
    }

    public interface OnInfoWindowClickListener {
        void onInfoWindowClick(Marker marker);
    }

    public interface OnMapCameraChangeListener {
        void onCameraChange(CameraPosition cameraPosition);

        void onCameraChangeFinish(CameraPosition cameraPosition);
    }

    public interface OnMapClickListener {
        void onMapClick(LatLng latLng);
    }

    public interface OnMapLoadedListener {
        void onMapLoaded();
    }

    public interface OnMapLongClickListener {
        void onMapLongClick(LatLng latLng);
    }

    public interface OnMarkerClickListener {
        boolean onMarkerClick(Marker marker);
    }

    public interface OnMarkerDraggedListener {
        void onMarkerDrag(Marker marker);

        void onMarkerDragEnd(Marker marker);

        void onMarkerDragStart(Marker marker);
    }

    public interface OnScreenShotListener {
        void onMapScreenShot(Bitmap bitmap);
    }

    public TencentMap(f fVar) {
        this.mapContext = fVar;
        this.contentLayer = fVar.e();
        this.projection = fVar.b();
    }

    private void changeCamera(CameraUpdate cameraUpdate, long j, CancelableCallback cancelableCallback) {
        if (!this.mapContext.f().k() || j < 0) {
            cameraUpdate.getCameraUpdateFactoryDelegate().a(false);
        }
        cameraUpdate.getCameraUpdateFactoryDelegate().a(cancelableCallback);
        cameraUpdate.getCameraUpdateFactoryDelegate().a(j);
        this.mapContext.c().a(cameraUpdate.getCameraUpdateFactoryDelegate());
    }

    public static OnErrorListener getErrorListener() {
        return onErrorListener;
    }

    private boolean setBounds(LatLngBounds latLngBounds) {
        return this.projection.a(latLngBounds);
    }

    public static void setErrorListener(OnErrorListener onErrorListener2) {
        onErrorListener = onErrorListener2;
    }

    private void setMaxZoomLevel(int i) {
        this.projection.c(i);
    }

    private void setMinZoomLevel(int i) {
        this.projection.d(i);
    }

    public Circle addCircle(CircleOptions circleOptions) {
        return new Circle(this.contentLayer.a(circleOptions));
    }

    public GroundOverlay addGroundOverlay(GroundOverlayOptions groundOverlayOptions) {
        return new GroundOverlay(this.contentLayer.a(groundOverlayOptions));
    }

    public Marker addMarker(MarkerOptions markerOptions) {
        return new Marker(this.contentLayer.a(markerOptions));
    }

    public Polygon addPolygon(PolygonOptions polygonOptions) {
        return new Polygon(this.contentLayer.a(polygonOptions));
    }

    public Polyline addPolyline(PolylineOptions polylineOptions) {
        return new Polyline(this.contentLayer.a(polylineOptions));
    }

    public TileOverlay addTileOverlay(TileOverlayOptions tileOverlayOptions) {
        return new TileOverlay(this.mapContext.g().a(tileOverlayOptions));
    }

    public void animateCamera(CameraUpdate cameraUpdate) {
        changeCamera(cameraUpdate, 1000L, null);
    }

    public void animateCamera(CameraUpdate cameraUpdate, long j, CancelableCallback cancelableCallback) {
        if (j < 0) {
            j = 0;
        }
        changeCamera(cameraUpdate, j, cancelableCallback);
    }

    public void animateCamera(CameraUpdate cameraUpdate, CancelableCallback cancelableCallback) {
        changeCamera(cameraUpdate, 1000L, cancelableCallback);
    }

    public void animateTo(LatLng latLng) {
        changeCamera(CameraUpdateFactory.newLatLng(latLng), 1000L, null);
    }

    public void animateTo(LatLng latLng, long j, CancelableCallback cancelableCallback) {
        changeCamera(CameraUpdateFactory.newLatLng(latLng), j, cancelableCallback);
    }

    public void animateTo(LatLng latLng, final Runnable runnable) {
        changeCamera(CameraUpdateFactory.newLatLng(latLng), 1000L, new CancelableCallback() { // from class: com.tencent.tencentmap.mapsdk.map.TencentMap.1
            @Override // com.tencent.tencentmap.mapsdk.map.CancelableCallback
            public void onCancel() {
                runnable.run();
            }

            @Override // com.tencent.tencentmap.mapsdk.map.CancelableCallback
            public void onFinish() {
                runnable.run();
            }
        });
    }

    public final void clearAllOverlays() {
        this.contentLayer.a();
        this.mapContext.a(false, false);
    }

    public boolean clearCache() {
        return com.tencent.mapsdk.rastercore.tile.a.a.a().a(MapTile.MapSource.WORLD) && com.tencent.mapsdk.rastercore.tile.a.a.a().a(MapTile.MapSource.TENCENT) && com.tencent.mapsdk.rastercore.tile.a.a.a().a(MapTile.MapSource.SATELLITE);
    }

    public LatLng getMapCenter() {
        return this.projection.d().getTarget();
    }

    public int getMaxZoomLevel() {
        return this.projection.i().a();
    }

    public int getMinZoomLevel() {
        return this.projection.j().a();
    }

    public void getScreenShot(OnScreenShotListener onScreenShotListener) {
        this.mapContext.a(onScreenShotListener);
    }

    public void getScreenShot(OnScreenShotListener onScreenShotListener, Rect rect) {
        this.mapContext.a(onScreenShotListener, rect);
    }

    public final String getVersion() {
        return "1.3.2";
    }

    public int getZoomLevel() {
        return (int) this.projection.d().getZoom();
    }

    public final boolean isAppKeyAvailable() {
        return f.p();
    }

    public boolean isHandDrawMapEnable() {
        f fVar = this.mapContext;
        if (fVar == null) {
            return false;
        }
        return fVar.r();
    }

    public final boolean isSatelliteEnabled() {
        return this.mapContext.l() == 2;
    }

    public boolean isTrafficEnabled() {
        return this.mapContext.i().a();
    }

    public void moveCamera(CameraUpdate cameraUpdate) {
        com.tencent.mapsdk.rastercore.c.a cameraUpdateFactoryDelegate;
        if (cameraUpdate == null || (cameraUpdateFactoryDelegate = cameraUpdate.getCameraUpdateFactoryDelegate()) == null) {
            return;
        }
        cameraUpdateFactoryDelegate.a(false);
        this.mapContext.c().a(cameraUpdateFactoryDelegate);
    }

    public void removeOverlay(IOverlay iOverlay) {
        if (iOverlay == null) {
            return;
        }
        iOverlay.remove();
    }

    public void scrollBy(float f2, float f3) {
        changeCamera(CameraUpdateFactory.scrollBy(f2, f3), 1000L, null);
    }

    public void scrollBy(float f2, float f3, long j, CancelableCallback cancelableCallback) {
        changeCamera(CameraUpdateFactory.scrollBy(f2, f3), j, cancelableCallback);
    }

    public void setCenter(LatLng latLng) {
        changeCamera(CameraUpdateFactory.newLatLngZoom(latLng, getZoomLevel()), 0L, null);
    }

    public void setHandDrawMapEnable(boolean z) {
        f fVar = this.mapContext;
        if (fVar != null) {
            fVar.g(z);
        }
    }

    public void setInfoWindowAdapter(InfoWindowAdapter infoWindowAdapter) {
        this.mapContext.h().a(infoWindowAdapter);
    }

    public void setLanguage(QMapLanguage qMapLanguage) {
        f.a(QMapLanguage.getLanguageCode(qMapLanguage));
        this.mapContext.a(true, true);
    }

    public void setOnInfoWindowClickListener(OnInfoWindowClickListener onInfoWindowClickListener) {
        this.mapContext.h().a(onInfoWindowClickListener);
    }

    public void setOnMapCameraChangeListener(OnMapCameraChangeListener onMapCameraChangeListener) {
        this.mapContext.h().a(onMapCameraChangeListener);
    }

    public void setOnMapClickListener(OnMapClickListener onMapClickListener) {
        this.mapContext.h().a(onMapClickListener);
    }

    public void setOnMapLoadedListener(OnMapLoadedListener onMapLoadedListener) {
        this.mapContext.c().a(onMapLoadedListener);
    }

    public void setOnMapLongClickListener(OnMapLongClickListener onMapLongClickListener) {
        this.mapContext.h().a(onMapLongClickListener);
    }

    public void setOnMarkerClickListener(OnMarkerClickListener onMarkerClickListener) {
        this.mapContext.h().a(onMarkerClickListener);
    }

    public void setOnMarkerDraggedListener(OnMarkerDraggedListener onMarkerDraggedListener) {
        this.mapContext.h().a(onMarkerDraggedListener);
    }

    public void setSatelliteEnabled(boolean z) {
        f fVar;
        int i;
        if (z) {
            fVar = this.mapContext;
            i = 2;
        } else {
            fVar = this.mapContext;
            i = 1;
        }
        fVar.a(i);
    }

    public void setTrafficEnabled(boolean z) {
        this.mapContext.i().a(z);
    }

    public void setZoom(int i) {
        changeCamera(CameraUpdateFactory.zoomTo(i), 0L, null);
    }

    public void stopAnimation() {
        this.mapContext.d().stopAnimation();
    }

    public void zoomIn() {
        changeCamera(CameraUpdateFactory.zoomIn(), 1000L, null);
    }

    public void zoomInFixing(int i, int i2) {
        changeCamera(CameraUpdateFactory.zoomBy(1.0f, new Point(i, i2)), 1000L, null);
    }

    public void zoomOut() {
        changeCamera(CameraUpdateFactory.zoomOut(), 1000L, null);
    }

    public void zoomOutFixing(int i, int i2) {
        changeCamera(CameraUpdateFactory.zoomBy(-1.0f, new Point(i, i2)), 1000L, null);
    }

    public void zoomToSpan(double d2, double d3) {
        double d4 = d2 / 2.0d;
        double d5 = d3 / 2.0d;
        zoomToSpan(new LatLng(getMapCenter().getLatitude() - d4, getMapCenter().getLongitude() + d5), new LatLng(getMapCenter().getLatitude() + d4, getMapCenter().getLongitude() - d5));
    }

    public void zoomToSpan(LatLng latLng, LatLng latLng2) {
        this.mapContext.c().a(CameraUpdateFactory.newLatLngBounds(new LatLngBounds.Builder().include(latLng).include(latLng2).build(), 10).getCameraUpdateFactoryDelegate());
    }
}
