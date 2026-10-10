package com.tencent.tencentmap.mapsdk.map;

import android.graphics.Canvas;
import android.view.MotionEvent;
import cn.qqtheme.framework.widget.WheelView;
import com.tencent.mapsdk.raster.model.GeoPoint;
import com.tencent.mapsdk.rastercore.d.a;
import com.tencent.mapsdk.rastercore.d.f;
import com.tencent.mapsdk.rastercore.e.c;

/* JADX INFO: loaded from: classes5.dex */
public class Overlay implements c {
    protected static final float SHADOW_X_SKEW = -0.89f;
    protected static final float SHADOW_Y_SCALE = 0.5f;
    protected a contentLayer;
    protected f mapContext;
    protected MapView mapView;
    protected boolean isVisible = true;
    protected float zIndex = WheelView.DividerConfig.FILL;
    protected String id = getId();

    @Override // com.tencent.mapsdk.rastercore.e.c
    public boolean checkInBounds() {
        return false;
    }

    @Override // com.tencent.mapsdk.rastercore.e.c
    public void destroy() {
    }

    @Override // com.tencent.mapsdk.rastercore.e.c
    public void draw(Canvas canvas) {
        draw(canvas, this.mapView);
    }

    protected void draw(Canvas canvas, MapView mapView) {
    }

    @Override // com.tencent.mapsdk.rastercore.e.c
    public boolean equalsRemote(c cVar) {
        return equals(cVar) || cVar.getId().equals(getId());
    }

    @Override // com.tencent.mapsdk.rastercore.e.c
    public String getId() {
        if (this.id == null) {
            this.id = a.a("Overlay");
        }
        return this.id;
    }

    @Override // com.tencent.mapsdk.rastercore.e.c
    public float getZIndex() {
        return this.zIndex;
    }

    @Override // com.tencent.mapsdk.rastercore.e.c
    public int hashCodeRemote() {
        return 0;
    }

    public void init(MapView mapView) {
        this.mapView = mapView;
        this.mapContext = mapView.getMapContext();
        this.contentLayer = this.mapContext.e();
    }

    @Override // com.tencent.mapsdk.rastercore.e.c
    public boolean isVisible() {
        return this.isVisible;
    }

    public void onEmptyTap(GeoPoint geoPoint) {
    }

    public boolean onLongPress(GeoPoint geoPoint, MotionEvent motionEvent, MapView mapView) {
        return false;
    }

    public void onRemoveOverlay() {
    }

    public boolean onTap(GeoPoint geoPoint, MapView mapView) {
        return false;
    }

    public boolean onTouchEvent(MotionEvent motionEvent, MapView mapView) {
        return false;
    }

    @Override // com.tencent.mapsdk.rastercore.e.c
    public void remove() {
        this.contentLayer.b(getId());
        onRemoveOverlay();
    }

    @Override // com.tencent.mapsdk.rastercore.e.c
    public void setVisible(boolean z) {
        this.isVisible = z;
        this.mapContext.a(false, false);
    }

    @Override // com.tencent.mapsdk.rastercore.e.c
    public void setZIndex(float f2) {
        this.zIndex = f2;
        this.contentLayer.c();
        this.mapContext.a(false, false);
    }
}
