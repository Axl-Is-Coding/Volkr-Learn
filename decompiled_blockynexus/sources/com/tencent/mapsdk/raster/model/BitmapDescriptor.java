package com.tencent.mapsdk.raster.model;

import android.graphics.Bitmap;

/* JADX INFO: loaded from: classes5.dex */
public final class BitmapDescriptor implements Cloneable {
    int h;
    Bitmap mBitmap;
    int w;

    public BitmapDescriptor(Bitmap bitmap) {
        this.w = 0;
        this.h = 0;
        if (bitmap != null) {
            this.w = bitmap.getWidth();
            this.h = bitmap.getHeight();
            this.mBitmap = bitmap;
        }
    }

    private BitmapDescriptor(Bitmap bitmap, int i, int i2) {
        this.w = 0;
        this.h = 0;
        this.w = i;
        this.h = i2;
        this.mBitmap = bitmap;
    }

    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public final BitmapDescriptor m103clone() {
        return new BitmapDescriptor(Bitmap.createBitmap(this.mBitmap), this.w, this.h);
    }

    public final Bitmap getBitmap() {
        return this.mBitmap;
    }

    public final int getHeight() {
        return this.h;
    }

    public final int getWidth() {
        return this.w;
    }
}
