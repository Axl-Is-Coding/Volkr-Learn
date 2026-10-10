package com.tencent.mapsdk.raster.model;

import cn.qqtheme.framework.widget.WheelView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public final class PolygonOptions {
    private int strokeColor = -16777216;
    private int fillColor = -16777216;
    private float strokeWidth = 10.0f;
    private boolean isVisible = true;
    private float zIndex = WheelView.DividerConfig.FILL;
    private final List<LatLng> points = new ArrayList();

    public final PolygonOptions add(LatLng latLng) {
        this.points.add(latLng);
        return this;
    }

    public final PolygonOptions add(LatLng... latLngArr) {
        this.points.addAll(Arrays.asList(latLngArr));
        return this;
    }

    public final PolygonOptions addAll(Iterable<LatLng> iterable) {
        Iterator<LatLng> it = iterable.iterator();
        while (it.hasNext()) {
            this.points.add(it.next());
        }
        return this;
    }

    public final PolygonOptions fillColor(int i) {
        this.fillColor = i;
        return this;
    }

    public final int getFillColor() {
        return this.fillColor;
    }

    public final List<LatLng> getPoints() {
        return this.points;
    }

    public final int getStrokeColor() {
        return this.strokeColor;
    }

    public final float getStrokeWidth() {
        return this.strokeWidth;
    }

    public final float getZIndex() {
        return this.zIndex;
    }

    public final boolean isVisible() {
        return this.isVisible;
    }

    public final PolygonOptions strokeColor(int i) {
        this.strokeColor = i;
        return this;
    }

    public final PolygonOptions strokeWidth(float f2) {
        this.strokeWidth = f2;
        return this;
    }

    public final PolygonOptions visible(boolean z) {
        this.isVisible = z;
        return this;
    }

    public final PolygonOptions zIndex(float f2) {
        this.zIndex = f2;
        return this;
    }
}
