package com.tencent.tencentmap.mapsdk.map;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.PointF;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ListView;
import com.tencent.mapsdk.raster.model.BitmapDescriptorFactory;
import com.tencent.mapsdk.raster.model.Circle;
import com.tencent.mapsdk.raster.model.CircleOptions;
import com.tencent.mapsdk.raster.model.GeoPoint;
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
import com.tencent.mapsdk.raster.model.TencentMapOptions;
import com.tencent.mapsdk.rastercore.d.f;
import com.tencent.mapsdk.rastercore.d.g;
import com.tencent.mapsdk.rastercore.f.b;

/* JADX INFO: loaded from: classes5.dex */
public class MapView extends FrameLayout {

    @Deprecated
    private MapController controller;
    private g eventHandler;
    private f mapContext;
    private Projection projection;
    private TencentMap tencentMap;
    private UiSettings uiSettings;

    public static class LayoutParams extends FrameLayout.LayoutParams {
        public static final int BOTTOM = 80;
        public static final int BOTTOM_CENTER = 81;
        public static final int CENTER = 17;
        public static final int CENTER_HORIZONTAL = 1;
        public static final int CENTER_VERTICAL = 16;
        public static final int LEFT = 3;
        public static final int MODE_MAP = 0;
        public static final int MODE_VIEW = 1;
        public static final int RIGHT = 5;
        public static final int TOP = 48;
        public static final int TOP_LEFT = 51;
        private int alignment;
        public int mode;
        private LatLng point;
        private int x;
        private int y;

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.mode = 1;
            this.alignment = 51;
            this.point = null;
            this.x = 0;
            this.y = 0;
        }

        public LayoutParams(int i, int i2, GeoPoint geoPoint, int i3) {
            this(i, i2, geoPoint, 0, 0, i3);
        }

        public LayoutParams(int i, int i2, GeoPoint geoPoint, int i3, int i4, int i5) {
            this(i, i2, b.a(geoPoint), i3, i4, i5);
        }

        public LayoutParams(int i, int i2, LatLng latLng, int i3) {
            this(i, i2, latLng, 0, 0, i3);
        }

        public LayoutParams(int i, int i2, LatLng latLng, int i3, int i4, int i5) {
            super(i, i2);
            this.mode = 1;
            this.alignment = 51;
            this.point = null;
            this.x = 0;
            this.y = 0;
            this.mode = 0;
            setPoint(latLng);
            this.x = i3;
            this.y = i4;
            this.alignment = i5;
        }

        protected LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.mode = 1;
            this.alignment = 51;
            this.point = null;
            this.x = 0;
            this.y = 0;
        }

        public LatLng getPoint() {
            return this.point;
        }

        public void setPoint(LatLng latLng) {
            this.point = latLng;
        }
    }

    public MapView(Context context) {
        super(context);
        init(null);
    }

    public MapView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(null);
    }

    public MapView(Context context, TencentMapOptions tencentMapOptions) {
        super(context);
        init(tencentMapOptions);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0015  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0018  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void doLayout(android.view.View r3, int r4, int r5, float r6, float r7, int r8) {
        /*
            r2 = this;
            r0 = r8 & 7
            r8 = r8 & 112(0x70, float:1.57E-43)
            r1 = 5
            if (r0 != r1) goto La
            float r0 = (float) r4
        L8:
            float r6 = r6 - r0
            goto L11
        La:
            r1 = 1
            if (r0 != r1) goto L11
            int r0 = r4 / 2
            float r0 = (float) r0
            goto L8
        L11:
            r0 = 80
            if (r8 != r0) goto L18
            float r8 = (float) r5
        L16:
            float r7 = r7 - r8
            goto L20
        L18:
            r0 = 16
            if (r8 != r0) goto L20
            int r8 = r5 / 2
            float r8 = (float) r8
            goto L16
        L20:
            int r6 = java.lang.Math.round(r6)
            int r7 = java.lang.Math.round(r7)
            int r4 = r4 + r6
            int r5 = r5 + r7
            r3.layout(r6, r7, r4, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tencentmap.mapsdk.map.MapView.doLayout(android.view.View, int, int, float, float, int):void");
    }

    private void doMeasure(View view, int i, int i2, int[] iArr) {
        View view2;
        if ((view instanceof ListView) && (view2 = (View) view.getParent()) != null) {
            iArr[0] = view2.getWidth();
            iArr[1] = view2.getHeight();
        }
        if (i <= 0 || i2 <= 0) {
            view.measure(0, 0);
        }
        if (i == -2) {
            iArr[0] = view.getMeasuredWidth();
        } else if (i == -1) {
            iArr[0] = getMeasuredWidth();
        } else {
            iArr[0] = i;
        }
        if (i2 == -2) {
            iArr[1] = view.getMeasuredHeight();
        } else if (i2 == -1) {
            iArr[1] = getMeasuredHeight();
        } else {
            iArr[1] = i2;
        }
    }

    private void init(TencentMapOptions tencentMapOptions) {
        initForBugly();
        Context context = getContext();
        this.mapContext = new f(this);
        this.eventHandler = this.mapContext.h();
        setOnKeyListener(this.eventHandler);
        this.projection = new Projection(this.mapContext);
        this.uiSettings = new UiSettings(this.mapContext.f());
        this.tencentMap = new TencentMap(this.mapContext);
        this.controller = new MapController(this);
        if (tencentMapOptions != null) {
            this.mapContext.g(tencentMapOptions.isHandDrawMapEnable());
        }
        if (context instanceof MapActivity) {
            ((MapActivity) context).setMapView(this);
        }
        setBackgroundColor(-657936);
    }

    private void initForBugly() {
        SharedPreferences.Editor editorEdit = getContext().getApplicationContext().getSharedPreferences("BuglySdkInfos", 0).edit();
        editorEdit.putString("4e7cb4aa49", "1.2.6");
        editorEdit.commit();
    }

    private void layout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt != null) {
                layout(childAt);
            }
        }
    }

    private void layoutMap(View view, LayoutParams layoutParams) {
        PointF pointFA;
        int[] iArr = new int[2];
        doMeasure(view, ((FrameLayout.LayoutParams) layoutParams).width, ((FrameLayout.LayoutParams) layoutParams).height, iArr);
        if (layoutParams.getPoint() == null || (pointFA = this.mapContext.b().a(layoutParams.getPoint())) == null) {
            return;
        }
        pointFA.x += layoutParams.x;
        pointFA.y += layoutParams.y;
        doLayout(view, iArr[0], iArr[1], pointFA.x, pointFA.y, layoutParams.alignment);
    }

    private void layoutView(View view, LayoutParams layoutParams) {
        int[] iArr = new int[2];
        doMeasure(view, ((FrameLayout.LayoutParams) layoutParams).width, ((FrameLayout.LayoutParams) layoutParams).height, iArr);
        doLayout(view, iArr[0], iArr[1], layoutParams.x, layoutParams.y, layoutParams.alignment);
    }

    public Circle addCircle(CircleOptions circleOptions) {
        return this.tencentMap.addCircle(circleOptions);
    }

    public GroundOverlay addGroundOverlay(GroundOverlayOptions groundOverlayOptions) {
        return this.tencentMap.addGroundOverlay(groundOverlayOptions);
    }

    public final Marker addMarker(MarkerOptions markerOptions) {
        return this.tencentMap.addMarker(markerOptions);
    }

    public GroundOverlay addOverlay(Bitmap bitmap, LatLng latLng, LatLng latLng2) {
        return this.tencentMap.addGroundOverlay(new GroundOverlayOptions().positionFromBounds(new LatLngBounds(latLng, latLng2)).anchor(0.5f, 0.5f).transparency(0.1f).image(BitmapDescriptorFactory.fromBitmap(bitmap)));
    }

    public final boolean addOverlay(Overlay overlay) {
        if (overlay == null) {
            return false;
        }
        overlay.init(this);
        this.mapContext.e().a(overlay);
        return true;
    }

    public Polygon addPolygon(PolygonOptions polygonOptions) {
        return this.tencentMap.addPolygon(polygonOptions);
    }

    public Polyline addPolyline(PolylineOptions polylineOptions) {
        return this.tencentMap.addPolyline(polylineOptions);
    }

    public final void clearAllOverlays() {
        this.tencentMap.clearAllOverlays();
    }

    @Override // android.view.View
    public void computeScroll() {
        super.computeScroll();
        this.eventHandler.a();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        setClickable(false);
        this.eventHandler.b(MotionEvent.obtain(motionEvent));
        getParent().requestDisallowInterceptTouchEvent(true);
        return super.dispatchTouchEvent(motionEvent) || this.eventHandler.a(motionEvent);
    }

    public MapController getController() {
        return this.controller;
    }

    public int getLatitudeSpan() {
        return this.projection.getLatitudeSpan();
    }

    public int getLongitudeSpan() {
        return this.projection.getLongitudeSpan();
    }

    public TencentMap getMap() {
        return this.tencentMap;
    }

    public LatLng getMapCenter() {
        return this.tencentMap.getMapCenter();
    }

    protected f getMapContext() {
        return this.mapContext;
    }

    public MapController getMapController() {
        return this.controller;
    }

    public int getMaxZoomLevel() {
        return this.tencentMap.getMaxZoomLevel();
    }

    public int getMinZoomLevel() {
        return this.tencentMap.getMinZoomLevel();
    }

    public Projection getProjection() {
        return this.projection;
    }

    public float getScalePerPixel() {
        return this.projection.getScalePerPixel();
    }

    public UiSettings getUiSettings() {
        return this.uiSettings;
    }

    public final String getVersion() {
        return this.tencentMap.getVersion();
    }

    public int getZoomLevel() {
        return this.tencentMap.getZoomLevel();
    }

    public final boolean isAppKeyAvailable() {
        return this.tencentMap.isAppKeyAvailable();
    }

    public boolean isSatellite() {
        return this.tencentMap.isSatelliteEnabled();
    }

    public void layout() {
        layout(false, 0, 0, 0, 0);
    }

    public void layout(View view) {
        if (this == view.getParent()) {
            if (!(view.getLayoutParams() instanceof LayoutParams)) {
                layoutView(view, new LayoutParams(view.getLayoutParams()));
                return;
            }
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (layoutParams.mode == 0) {
                layoutMap(view, layoutParams);
            } else {
                layoutView(view, layoutParams);
            }
        }
    }

    public void moveCamera(CameraUpdate cameraUpdate) {
        this.tencentMap.moveCamera(cameraUpdate);
    }

    public void onCreate(Bundle bundle) {
        this.mapContext.a(bundle);
    }

    public void onDestroy() {
        this.mapContext.m();
    }

    public void onDestroyView() {
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        layout(z, i, i2, i3, i4);
    }

    public void onLowMemory() {
    }

    public void onPause() {
        f fVar = this.mapContext;
        f.n();
    }

    public void onRestart() {
    }

    public void onResume() {
    }

    public void onSaveInstanceState(Bundle bundle) {
        this.mapContext.b(bundle);
    }

    public void onStop() {
    }

    public void refreshMap() {
        postInvalidate();
    }

    public final void removeOverlay(IOverlay iOverlay) {
        this.tencentMap.removeOverlay(iOverlay);
    }

    public void setLogoPosition(int i) {
        this.uiSettings.setLogoPosition(i);
    }

    public void setPinchEnabeled(boolean z) {
        this.uiSettings.setZoomGesturesEnabled(z);
    }

    public void setSatellite(boolean z) {
        this.tencentMap.setSatelliteEnabled(z);
    }

    public void setScalControlsEnable(boolean z) {
        this.uiSettings.setScaleControlsEnabled(z);
    }

    public void setScaleControlsEnable(boolean z) {
        this.uiSettings.setScaleControlsEnabled(z);
    }

    public void setScaleViewPosition(int i) {
        this.uiSettings.setScaleViewPosition(i);
    }

    public void setScrollGesturesEnabled(boolean z) {
        this.uiSettings.setScrollGesturesEnabled(z);
    }

    public void stopAnimation() {
        clearAnimation();
        this.mapContext.c().clearAnimation();
        this.eventHandler.b();
    }
}
