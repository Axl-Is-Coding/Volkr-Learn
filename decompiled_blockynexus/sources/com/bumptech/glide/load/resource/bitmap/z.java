package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.util.Log;
import cn.qqtheme.framework.widget.WheelView;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: compiled from: TransformationUtils.java */
/* JADX INFO: loaded from: classes.dex */
public final class z {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Paint f4713c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Lock f4715e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Paint f4711a = new Paint(6);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Paint f4712b = new Paint(7);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Set<String> f4714d = new HashSet(Arrays.asList("XT1085", "XT1092", "XT1093", "XT1094", "XT1095", "XT1096", "XT1097", "XT1098", "XT1031", "XT1028", "XT937C", "XT1032", "XT1008", "XT1033", "XT1035", "XT1034", "XT939G", "XT1039", "XT1040", "XT1042", "XT1045", "XT1063", "XT1064", "XT1068", "XT1069", "XT1072", "XT1077", "XT1078", "XT1079"));

    /* JADX INFO: compiled from: TransformationUtils.java */
    private static final class a implements Lock {
        a() {
        }

        @Override // java.util.concurrent.locks.Lock
        public void lock() {
        }

        @Override // java.util.concurrent.locks.Lock
        public void lockInterruptibly() throws InterruptedException {
        }

        @Override // java.util.concurrent.locks.Lock
        public Condition newCondition() {
            throw new UnsupportedOperationException("Should not be called");
        }

        @Override // java.util.concurrent.locks.Lock
        public boolean tryLock() {
            return true;
        }

        @Override // java.util.concurrent.locks.Lock
        public boolean tryLock(long j, TimeUnit timeUnit) throws InterruptedException {
            return true;
        }

        @Override // java.util.concurrent.locks.Lock
        public void unlock() {
        }
    }

    static {
        f4715e = f4714d.contains(Build.MODEL) ? new ReentrantLock() : new a();
        f4713c = new Paint(7);
        f4713c.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    }

    public static int a(int i) {
        switch (i) {
            case 3:
            case 4:
                return 180;
            case 5:
            case 6:
                return 90;
            case 7:
            case 8:
                return 270;
            default:
                return 0;
        }
    }

    public static Lock a() {
        return f4715e;
    }

    public static Bitmap b(com.bumptech.glide.load.engine.a.e eVar, Bitmap bitmap, int i, int i2) {
        if (bitmap.getWidth() > i || bitmap.getHeight() > i2) {
            if (Log.isLoggable("TransformationUtils", 2)) {
                Log.v("TransformationUtils", "requested target size too big for input, fit centering instead");
            }
            return d(eVar, bitmap, i, i2);
        }
        if (Log.isLoggable("TransformationUtils", 2)) {
            Log.v("TransformationUtils", "requested target size larger or equal to input, returning input");
        }
        return bitmap;
    }

    public static boolean b(int i) {
        switch (i) {
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                return true;
            default:
                return false;
        }
    }

    public static Bitmap c(com.bumptech.glide.load.engine.a.e eVar, Bitmap bitmap, int i, int i2) {
        int iMin = Math.min(i, i2);
        float f2 = iMin;
        float f3 = f2 / 2.0f;
        float width = bitmap.getWidth();
        float height = bitmap.getHeight();
        float fMax = Math.max(f2 / width, f2 / height);
        float f4 = width * fMax;
        float f5 = fMax * height;
        float f6 = (f2 - f4) / 2.0f;
        float f7 = (f2 - f5) / 2.0f;
        RectF rectF = new RectF(f6, f7, f4 + f6, f5 + f7);
        Bitmap bitmapA = a(eVar, bitmap);
        Bitmap bitmapA2 = eVar.a(iMin, iMin, a(bitmap));
        bitmapA2.setHasAlpha(true);
        f4715e.lock();
        try {
            Canvas canvas = new Canvas(bitmapA2);
            canvas.drawCircle(f3, f3, f3, f4712b);
            canvas.drawBitmap(bitmapA, (Rect) null, rectF, f4713c);
            a(canvas);
            f4715e.unlock();
            if (!bitmapA.equals(bitmap)) {
                eVar.a(bitmapA);
            }
            return bitmapA2;
        } catch (Throwable th) {
            f4715e.unlock();
            throw th;
        }
    }

    public static Bitmap d(com.bumptech.glide.load.engine.a.e eVar, Bitmap bitmap, int i, int i2) {
        if (bitmap.getWidth() == i && bitmap.getHeight() == i2) {
            if (Log.isLoggable("TransformationUtils", 2)) {
                Log.v("TransformationUtils", "requested target size matches input, returning input");
            }
            return bitmap;
        }
        float fMin = Math.min(i / bitmap.getWidth(), i2 / bitmap.getHeight());
        int iRound = Math.round(bitmap.getWidth() * fMin);
        int iRound2 = Math.round(bitmap.getHeight() * fMin);
        if (bitmap.getWidth() == iRound && bitmap.getHeight() == iRound2) {
            if (Log.isLoggable("TransformationUtils", 2)) {
                Log.v("TransformationUtils", "adjusted target size matches input, returning input");
            }
            return bitmap;
        }
        Bitmap bitmapA = eVar.a((int) (bitmap.getWidth() * fMin), (int) (bitmap.getHeight() * fMin), b(bitmap));
        a(bitmap, bitmapA);
        if (Log.isLoggable("TransformationUtils", 2)) {
            Log.v("TransformationUtils", "request: " + i + "x" + i2);
            Log.v("TransformationUtils", "toFit:   " + bitmap.getWidth() + "x" + bitmap.getHeight());
            Log.v("TransformationUtils", "toReuse: " + bitmapA.getWidth() + "x" + bitmapA.getHeight());
            StringBuilder sb = new StringBuilder();
            sb.append("minPct:   ");
            sb.append(fMin);
            Log.v("TransformationUtils", sb.toString());
        }
        Matrix matrix = new Matrix();
        matrix.setScale(fMin, fMin);
        a(bitmap, bitmapA, matrix);
        return bitmapA;
    }

    public static Bitmap a(com.bumptech.glide.load.engine.a.e eVar, Bitmap bitmap, int i, int i2) {
        float width;
        float width2;
        if (bitmap.getWidth() == i && bitmap.getHeight() == i2) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        int width3 = bitmap.getWidth() * i2;
        int height = bitmap.getHeight() * i;
        float height2 = WheelView.DividerConfig.FILL;
        if (width3 > height) {
            width = i2 / bitmap.getHeight();
            width2 = (i - (bitmap.getWidth() * width)) * 0.5f;
        } else {
            width = i / bitmap.getWidth();
            height2 = (i2 - (bitmap.getHeight() * width)) * 0.5f;
            width2 = WheelView.DividerConfig.FILL;
        }
        matrix.setScale(width, width);
        matrix.postTranslate((int) (width2 + 0.5f), (int) (height2 + 0.5f));
        Bitmap bitmapA = eVar.a(i, i2, b(bitmap));
        a(bitmap, bitmapA);
        a(bitmap, bitmapA, matrix);
        return bitmapA;
    }

    private static Bitmap.Config b(Bitmap bitmap) {
        return bitmap.getConfig() != null ? bitmap.getConfig() : Bitmap.Config.ARGB_8888;
    }

    public static void a(Bitmap bitmap, Bitmap bitmap2) {
        bitmap2.setHasAlpha(bitmap.hasAlpha());
    }

    public static Bitmap a(com.bumptech.glide.load.engine.a.e eVar, Bitmap bitmap, int i) {
        if (!b(i)) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        a(i, matrix);
        RectF rectF = new RectF(WheelView.DividerConfig.FILL, WheelView.DividerConfig.FILL, bitmap.getWidth(), bitmap.getHeight());
        matrix.mapRect(rectF);
        Bitmap bitmapA = eVar.a(Math.round(rectF.width()), Math.round(rectF.height()), b(bitmap));
        matrix.postTranslate(-rectF.left, -rectF.top);
        bitmapA.setHasAlpha(bitmap.hasAlpha());
        a(bitmap, bitmapA, matrix);
        return bitmapA;
    }

    private static Bitmap a(com.bumptech.glide.load.engine.a.e eVar, Bitmap bitmap) {
        Bitmap.Config configA = a(bitmap);
        if (configA.equals(bitmap.getConfig())) {
            return bitmap;
        }
        Bitmap bitmapA = eVar.a(bitmap.getWidth(), bitmap.getHeight(), configA);
        new Canvas(bitmapA).drawBitmap(bitmap, WheelView.DividerConfig.FILL, WheelView.DividerConfig.FILL, (Paint) null);
        return bitmapA;
    }

    private static Bitmap.Config a(Bitmap bitmap) {
        if (Build.VERSION.SDK_INT >= 26 && Bitmap.Config.RGBA_F16.equals(bitmap.getConfig())) {
            return Bitmap.Config.RGBA_F16;
        }
        return Bitmap.Config.ARGB_8888;
    }

    private static void a(Canvas canvas) {
        canvas.setBitmap(null);
    }

    private static void a(Bitmap bitmap, Bitmap bitmap2, Matrix matrix) {
        f4715e.lock();
        try {
            Canvas canvas = new Canvas(bitmap2);
            canvas.drawBitmap(bitmap, matrix, f4711a);
            a(canvas);
        } finally {
            f4715e.unlock();
        }
    }

    static void a(int i, Matrix matrix) {
        switch (i) {
            case 2:
                matrix.setScale(-1.0f, 1.0f);
                break;
            case 3:
                matrix.setRotate(180.0f);
                break;
            case 4:
                matrix.setRotate(180.0f);
                matrix.postScale(-1.0f, 1.0f);
                break;
            case 5:
                matrix.setRotate(90.0f);
                matrix.postScale(-1.0f, 1.0f);
                break;
            case 6:
                matrix.setRotate(90.0f);
                break;
            case 7:
                matrix.setRotate(-90.0f);
                matrix.postScale(-1.0f, 1.0f);
                break;
            case 8:
                matrix.setRotate(-90.0f);
                break;
        }
    }
}
