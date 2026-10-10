package com.tencent.mapsdk.raster.model;

import cn.qqtheme.framework.widget.WheelView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public final class PolylineOptions {
    private BitmapDescriptor arrowTexture;
    private boolean isDottedLine = false;
    private boolean isGeodesic = false;
    private boolean isVisible = true;
    private int color = -16777216;
    private float width = 10.0f;
    private float zIndex = WheelView.DividerConfig.FILL;
    private float edgeWidth = WheelView.DividerConfig.FILL;
    private int edgeColor = -983041;
    private float arrowGap = 90.0f;
    private final List<LatLng> points = new ArrayList();

    public final PolylineOptions add(LatLng latLng) {
        this.points.add(latLng);
        return this;
    }

    public final PolylineOptions add(LatLng... latLngArr) {
        this.points.addAll(Arrays.asList(latLngArr));
        return this;
    }

    public final PolylineOptions addAll(Iterable<LatLng> iterable) {
        Iterator<LatLng> it = iterable.iterator();
        while (it.hasNext()) {
            this.points.add(it.next());
        }
        return this;
    }

    public final PolylineOptions arrowGap(float f2) {
        if (f2 > WheelView.DividerConfig.FILL) {
            this.arrowGap = f2;
        }
        return this;
    }

    public final PolylineOptions arrowTexture(BitmapDescriptor bitmapDescriptor) {
        if (bitmapDescriptor != null) {
            this.arrowTexture = bitmapDescriptor;
        }
        return this;
    }

    public final PolylineOptions color(int i) {
        this.color = i;
        return this;
    }

    public final PolylineOptions edgeColor(int i) {
        this.edgeColor = i;
        return this;
    }

    public final PolylineOptions edgeWidth(float f2) {
        if (f2 > WheelView.DividerConfig.FILL) {
            this.edgeWidth = f2;
        }
        return this;
    }

    public final PolylineOptions geodesic(boolean z) {
        this.isGeodesic = z;
        return this;
    }

    public final float getArrowGap() {
        return this.arrowGap;
    }

    public final BitmapDescriptor getArrowTexture() {
        return this.arrowTexture;
    }

    public final int getColor() {
        return this.color;
    }

    public final int getEdgeColor() {
        return this.edgeColor;
    }

    public final float getEdgeWidth() {
        return this.edgeWidth;
    }

    public final List<LatLng> getPoints() {
        return this.points;
    }

    public final float getWidth() {
        return this.width;
    }

    public final float getZIndex() {
        return this.zIndex;
    }

    public final boolean isDottedLine() {
        return this.isDottedLine;
    }

    public final boolean isGeodesic() {
        return this.isGeodesic;
    }

    public final boolean isVisible() {
        return this.isVisible;
    }

    public final PolylineOptions setDottedLine(boolean z) {
        this.isDottedLine = z;
        return this;
    }

    public final PolylineOptions visible(boolean z) {
        this.isVisible = z;
        return this;
    }

    public final PolylineOptions width(float f2) {
        this.width = f2;
        return this;
    }

    public final PolylineOptions zIndex(float f2) {
        this.zIndex = f2;
        return this;
    }
}
