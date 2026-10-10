package com.tencent.mapsdk.rastercore.tile.a;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.mapsdk.rastercore.d.f;

/* JADX INFO: loaded from: classes5.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f19643a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private byte[] f19644b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f19645c;

    public b(byte[] bArr, int i) {
        this.f19643a = "md5";
        this.f19645c = -1;
        this.f19644b = bArr;
        this.f19645c = i;
    }

    public b(byte[] bArr, int i, String str) {
        this.f19643a = "md5";
        this.f19645c = -1;
        this.f19644b = bArr;
        this.f19645c = i;
        this.f19643a = str;
    }

    public final String a() {
        return this.f19643a;
    }

    public final Bitmap b() {
        byte[] bArr = this.f19644b;
        if (bArr == null) {
            return null;
        }
        Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
        if (bitmapDecodeByteArray != null) {
            bitmapDecodeByteArray.setDensity(f.s());
        }
        return bitmapDecodeByteArray;
    }

    public final byte[] c() {
        return this.f19644b;
    }

    public final int d() {
        return this.f19645c;
    }
}
