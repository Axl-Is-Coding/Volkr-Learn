package com.bytedance.sdk.adnet.b;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;
import com.bytedance.sdk.adnet.core.Request;
import com.bytedance.sdk.adnet.core.m;
import com.bytedance.sdk.adnet.core.o;

/* JADX INFO: compiled from: ImageRequest.java */
/* JADX INFO: loaded from: classes.dex */
public class e extends Request<Bitmap> {
    private static final Object i = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Object f5426c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private m.a<Bitmap> f5427d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Bitmap.Config f5428e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f5429f;
    private final int g;
    private final ImageView.ScaleType h;

    public e(String str, m.a<Bitmap> aVar, int i2, int i3, ImageView.ScaleType scaleType, Bitmap.Config config) {
        super(0, str, aVar);
        this.f5426c = new Object();
        setRetryPolicy(new com.bytedance.sdk.adnet.core.e(1000, 2, 2.0f));
        this.f5427d = aVar;
        this.f5428e = config;
        this.f5429f = i2;
        this.g = i3;
        this.h = scaleType;
        setShouldCache(false);
    }

    private static int a(int i2, int i3, int i4, int i5, ImageView.ScaleType scaleType) {
        if (i2 == 0 && i3 == 0) {
            return i4;
        }
        if (scaleType == ImageView.ScaleType.FIT_XY) {
            return i2 == 0 ? i4 : i2;
        }
        if (i2 == 0) {
            double d2 = i3;
            double d3 = i5;
            Double.isNaN(d2);
            Double.isNaN(d3);
            double d4 = i4;
            Double.isNaN(d4);
            return (int) (d4 * (d2 / d3));
        }
        if (i3 == 0) {
            return i2;
        }
        double d5 = i5;
        double d6 = i4;
        Double.isNaN(d5);
        Double.isNaN(d6);
        double d7 = d5 / d6;
        if (scaleType == ImageView.ScaleType.CENTER_CROP) {
            double d8 = i2;
            Double.isNaN(d8);
            double d9 = i3;
            if (d8 * d7 >= d9) {
                return i2;
            }
            Double.isNaN(d9);
            return (int) (d9 / d7);
        }
        double d10 = i2;
        Double.isNaN(d10);
        double d11 = i3;
        if (d10 * d7 <= d11) {
            return i2;
        }
        Double.isNaN(d11);
        return (int) (d11 / d7);
    }

    private m<Bitmap> b(com.bytedance.sdk.adnet.core.i iVar) {
        Bitmap bitmapDecodeByteArray;
        byte[] bArr = iVar.f5525b;
        BitmapFactory.Options options = new BitmapFactory.Options();
        if (this.f5429f == 0 && this.g == 0) {
            options.inPreferredConfig = this.f5428e;
            bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        } else {
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            int i2 = options.outWidth;
            int i3 = options.outHeight;
            int iA = a(this.f5429f, this.g, i2, i3, this.h);
            int iA2 = a(this.g, this.f5429f, i3, i2, this.h);
            options.inJustDecodeBounds = false;
            options.inSampleSize = a(i2, i3, iA, iA2);
            bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            if (bitmapDecodeByteArray != null && (bitmapDecodeByteArray.getWidth() > iA || bitmapDecodeByteArray.getHeight() > iA2)) {
                Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmapDecodeByteArray, iA, iA2, true);
                bitmapDecodeByteArray.recycle();
                bitmapDecodeByteArray = bitmapCreateScaledBitmap;
            }
        }
        return bitmapDecodeByteArray == null ? m.a(new com.bytedance.sdk.adnet.err.e(iVar)) : m.a(bitmapDecodeByteArray, com.bytedance.sdk.adnet.d.b.a(iVar));
    }

    @Override // com.bytedance.sdk.adnet.core.Request
    public void cancel() {
        super.cancel();
        synchronized (this.f5426c) {
            this.f5427d = null;
        }
    }

    @Override // com.bytedance.sdk.adnet.core.Request
    public Request.b getPriority() {
        return Request.b.LOW;
    }

    @Override // com.bytedance.sdk.adnet.core.Request
    protected m<Bitmap> a(com.bytedance.sdk.adnet.core.i iVar) {
        m<Bitmap> mVarB;
        synchronized (i) {
            try {
                try {
                    mVarB = b(iVar);
                } catch (OutOfMemoryError e2) {
                    o.c("Caught OOM for %d byte image, url=%s", Integer.valueOf(iVar.f5525b.length), getUrl());
                    return m.a(new com.bytedance.sdk.adnet.err.e(e2));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return mVarB;
    }

    @Override // com.bytedance.sdk.adnet.core.Request
    protected void a(m<Bitmap> mVar) {
        m.a<Bitmap> aVar;
        synchronized (this.f5426c) {
            aVar = this.f5427d;
        }
        if (aVar != null) {
            aVar.a(mVar);
        }
    }

    static int a(int i2, int i3, int i4, int i5) {
        double d2 = i2;
        double d3 = i4;
        Double.isNaN(d2);
        Double.isNaN(d3);
        double d4 = i3;
        double d5 = i5;
        Double.isNaN(d4);
        Double.isNaN(d5);
        double dMin = Math.min(d2 / d3, d4 / d5);
        float f2 = 1.0f;
        while (true) {
            float f3 = 2.0f * f2;
            if (f3 > dMin) {
                return (int) f2;
            }
            f2 = f3;
        }
    }
}
