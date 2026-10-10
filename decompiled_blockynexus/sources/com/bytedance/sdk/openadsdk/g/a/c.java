package com.bytedance.sdk.openadsdk.g.a;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;
import com.bytedance.sdk.adnet.core.Request;
import com.bytedance.sdk.adnet.core.e;
import com.bytedance.sdk.adnet.core.i;
import com.bytedance.sdk.adnet.core.m;
import com.bytedance.sdk.openadsdk.utils.d;
import com.bytedance.sdk.openadsdk.utils.o;

/* JADX INFO: compiled from: GifRequest.java */
/* JADX INFO: loaded from: classes.dex */
public class c extends Request<byte[]> {
    private static final Object i = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Object f6796c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private a f6797d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Bitmap.Config f6798e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f6799f;
    private final int g;
    private final ImageView.ScaleType h;

    /* JADX INFO: compiled from: GifRequest.java */
    public interface a extends m.a<byte[]> {
        void a(String str, byte[] bArr);
    }

    public c(String str, a aVar, int i2, int i3, ImageView.ScaleType scaleType, Bitmap.Config config) {
        super(0, str, aVar);
        this.f6796c = new Object();
        setRetryPolicy(new e(1000, 2, 2.0f));
        this.f6797d = aVar;
        this.f6798e = config;
        this.f6799f = i2;
        this.g = i3;
        this.h = scaleType;
        setShouldCache(false);
    }

    private m<byte[]> b(i iVar) {
        Bitmap bitmapDecodeByteArray;
        final byte[] bArr = iVar.f5525b;
        String strA = com.bytedance.sdk.openadsdk.g.a.a.a().a(getUrl(), this.f6799f, this.g, this.h);
        if (bArr.length >= 3 && bArr[0] == 71 && bArr[1] == 73 && bArr[2] == 70) {
            try {
                com.bytedance.sdk.openadsdk.g.a.a.a().a(strA, bArr);
                if (this.f6797d != null) {
                    this.f5463b.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.g.a.c.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (c.this.f6797d != null) {
                                c.this.f6797d.a(c.this.getUrl(), bArr);
                            }
                        }
                    });
                }
                return m.a(bArr, com.bytedance.sdk.adnet.d.b.a(iVar));
            } catch (Exception unused) {
            }
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        if (this.f6799f == 0 && this.g == 0) {
            options.inPreferredConfig = this.f6798e;
            bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        } else {
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            int i2 = options.outWidth;
            int i3 = options.outHeight;
            int iA = a(this.f6799f, this.g, i2, i3, this.h);
            int iA2 = a(this.g, this.f6799f, i3, i2, this.h);
            options.inJustDecodeBounds = false;
            options.inSampleSize = a(i2, i3, iA, iA2);
            bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            if (bitmapDecodeByteArray != null && (bitmapDecodeByteArray.getWidth() > iA || bitmapDecodeByteArray.getHeight() > iA2)) {
                Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmapDecodeByteArray, iA, iA2, true);
                bitmapDecodeByteArray.recycle();
                bitmapDecodeByteArray = bitmapCreateScaledBitmap;
            }
        }
        if (bitmapDecodeByteArray == null) {
            return m.a(new com.bytedance.sdk.adnet.err.e(iVar));
        }
        final byte[] bArrB = d.b(bitmapDecodeByteArray);
        com.bytedance.sdk.openadsdk.g.a.a.a().a(strA, bArrB);
        if (this.f6797d != null) {
            this.f5463b.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.g.a.c.2
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.f6797d != null) {
                        c.this.f6797d.a(c.this.getUrl(), bArrB);
                    }
                }
            });
        }
        return m.a(bArrB, com.bytedance.sdk.adnet.d.b.a(iVar));
    }

    @Override // com.bytedance.sdk.adnet.core.Request
    public void cancel() {
        super.cancel();
        synchronized (this.f6796c) {
            this.f6797d = null;
        }
    }

    @Override // com.bytedance.sdk.adnet.core.Request
    public Request.b getPriority() {
        return Request.b.LOW;
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

    @Override // com.bytedance.sdk.adnet.core.Request
    protected m<byte[]> a(i iVar) {
        m<byte[]> mVarB;
        synchronized (i) {
            try {
                try {
                    mVarB = b(iVar);
                } catch (OutOfMemoryError e2) {
                    o.c("GifRequest", "Caught OOM for byte image", e2);
                    return m.a(new com.bytedance.sdk.adnet.err.e(e2));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return mVarB;
    }

    @Override // com.bytedance.sdk.adnet.core.Request
    protected void a(m<byte[]> mVar) {
        a aVar;
        synchronized (this.f6796c) {
            aVar = this.f6797d;
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
