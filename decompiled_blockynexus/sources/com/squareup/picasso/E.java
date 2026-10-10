package com.squareup.picasso;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.NetworkInfo;
import com.squareup.picasso.Picasso;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: RequestHandler.java */
/* JADX INFO: loaded from: classes5.dex */
public abstract class E {

    /* JADX INFO: compiled from: RequestHandler.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Picasso.LoadedFrom f19231a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Bitmap f19232b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final InputStream f19233c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final int f19234d;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public a(Bitmap bitmap, Picasso.LoadedFrom loadedFrom) {
            this(bitmap, null, loadedFrom, 0);
            P.a(bitmap, "bitmap == null");
        }

        public Bitmap a() {
            return this.f19232b;
        }

        int b() {
            return this.f19234d;
        }

        public Picasso.LoadedFrom c() {
            return this.f19231a;
        }

        public InputStream d() {
            return this.f19233c;
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public a(InputStream inputStream, Picasso.LoadedFrom loadedFrom) {
            this(null, inputStream, loadedFrom, 0);
            P.a(inputStream, "stream == null");
        }

        a(Bitmap bitmap, InputStream inputStream, Picasso.LoadedFrom loadedFrom, int i) {
            if ((inputStream != null) ^ (bitmap != null)) {
                this.f19232b = bitmap;
                this.f19233c = inputStream;
                P.a(loadedFrom, "loadedFrom == null");
                this.f19231a = loadedFrom;
                this.f19234d = i;
                return;
            }
            throw new AssertionError();
        }
    }

    static boolean a(BitmapFactory.Options options) {
        return options != null && options.inJustDecodeBounds;
    }

    static BitmapFactory.Options b(C c2) {
        boolean zC = c2.c();
        boolean z = c2.r != null;
        BitmapFactory.Options options = null;
        if (zC || z) {
            options = new BitmapFactory.Options();
            options.inJustDecodeBounds = zC;
            if (z) {
                options.inPreferredConfig = c2.r;
            }
        }
        return options;
    }

    int a() {
        return 0;
    }

    public abstract a a(C c2, int i) throws IOException;

    public abstract boolean a(C c2);

    boolean a(boolean z, NetworkInfo networkInfo) {
        return false;
    }

    boolean b() {
        return false;
    }

    static void a(int i, int i2, BitmapFactory.Options options, C c2) {
        a(i, i2, options.outWidth, options.outHeight, options, c2);
    }

    static void a(int i, int i2, int i3, int i4, BitmapFactory.Options options, C c2) {
        int iMin;
        double dFloor;
        if (i4 > i2 || i3 > i) {
            if (i2 == 0) {
                dFloor = Math.floor(i3 / i);
            } else if (i == 0) {
                dFloor = Math.floor(i4 / i2);
            } else {
                int iFloor = (int) Math.floor(i4 / i2);
                int iFloor2 = (int) Math.floor(i3 / i);
                if (c2.l) {
                    iMin = Math.max(iFloor, iFloor2);
                } else {
                    iMin = Math.min(iFloor, iFloor2);
                }
            }
            iMin = (int) dFloor;
        } else {
            iMin = 1;
        }
        options.inSampleSize = iMin;
        options.inJustDecodeBounds = false;
    }
}
