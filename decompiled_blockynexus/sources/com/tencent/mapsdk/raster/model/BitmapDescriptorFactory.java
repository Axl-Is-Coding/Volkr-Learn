package com.tencent.mapsdk.raster.model;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.mapsdk.rastercore.c;
import com.tencent.mapsdk.rastercore.d.f;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/* JADX INFO: loaded from: classes5.dex */
public final class BitmapDescriptorFactory {
    public static BitmapDescriptor defaultMarker() {
        return fromAsset("marker.png");
    }

    public static BitmapDescriptor fromAsset(String str) {
        try {
            InputStream resourceAsStream = BitmapDescriptorFactory.class.getResourceAsStream("/assets/" + str);
            Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(resourceAsStream);
            resourceAsStream.close();
            return fromBitmap(bitmapDecodeStream);
        } catch (Exception unused) {
            return null;
        }
    }

    public static BitmapDescriptor fromBitmap(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        return new BitmapDescriptor(bitmap);
    }

    public static BitmapDescriptor fromFile(String str) {
        try {
            FileInputStream fileInputStream = new FileInputStream(new File(str));
            Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(fileInputStream);
            fileInputStream.close();
            return fromBitmap(bitmapDecodeStream);
        } catch (Exception unused) {
            return null;
        }
    }

    public static BitmapDescriptor fromPath(String str) {
        try {
            return fromBitmap(BitmapFactory.decodeFile(str));
        } catch (Exception unused) {
            return null;
        }
    }

    public static BitmapDescriptor fromResource(int i) throws Throwable {
        InputStream inputStreamOpenRawResource;
        InputStream inputStream = null;
        try {
            Context contextA = f.a();
            if (contextA == null) {
                c.a((Closeable) null);
                return null;
            }
            inputStreamOpenRawResource = contextA.getResources().openRawResource(i);
            try {
                BitmapDescriptor bitmapDescriptorFromBitmap = fromBitmap(BitmapFactory.decodeStream(inputStreamOpenRawResource));
                c.a((Closeable) inputStreamOpenRawResource);
                return bitmapDescriptorFromBitmap;
            } catch (Exception unused) {
            } catch (Throwable th) {
                inputStream = inputStreamOpenRawResource;
                th = th;
                c.a((Closeable) inputStream);
                throw th;
            }
        } catch (Exception unused2) {
            inputStreamOpenRawResource = null;
        } catch (Throwable th2) {
            th = th2;
        }
        c.a((Closeable) inputStreamOpenRawResource);
        return null;
    }

    public static BitmapDescriptor fromView(View view) {
        try {
            Context contextA = f.a();
            if (contextA != null) {
                FrameLayout frameLayout = new FrameLayout(contextA);
                frameLayout.addView(view);
                frameLayout.destroyDrawingCache();
                return fromBitmap(getViewBitmap(frameLayout));
            }
        } catch (Exception unused) {
        }
        return null;
    }

    private static Bitmap getViewBitmap(View view) {
        view.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
        view.buildDrawingCache();
        Bitmap drawingCache = view.getDrawingCache();
        if (drawingCache != null) {
            return drawingCache.copy(Bitmap.Config.ARGB_8888, false);
        }
        return null;
    }
}
