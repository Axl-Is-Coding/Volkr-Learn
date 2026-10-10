package io.rong.imkit.utilities;

import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.media.MediaPlayer;
import android.net.Uri;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import io.rong.common.LibStorageUtils;
import io.rong.common.RLog;
import io.rong.imkit.R;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: loaded from: classes5.dex */
public class RongUtils {
    private static double RATIO = 0.85d;
    private static final String TAG = "RongUtils";
    public static float density;
    public static int densityDpi;
    public static int dialogWidth;
    public static int navbarheight;
    public static float scaleDensity;
    public static int screenHeight;
    public static int screenMax;
    public static int screenMin;
    public static int screenWidth;
    public static int statusbarheight;
    public static float xdpi;
    public static float ydpi;

    public static void GetInfo(Context context) {
        if (context == null) {
            return;
        }
        DisplayMetrics displayMetrics = context.getApplicationContext().getResources().getDisplayMetrics();
        screenWidth = displayMetrics.widthPixels;
        screenHeight = displayMetrics.heightPixels;
        int i = screenWidth;
        int i2 = screenHeight;
        if (i > i2) {
            i = i2;
        }
        screenMin = i;
        int i3 = screenWidth;
        int i4 = screenHeight;
        if (i3 < i4) {
            i3 = i4;
        }
        screenMax = i3;
        density = displayMetrics.density;
        scaleDensity = displayMetrics.scaledDensity;
        xdpi = displayMetrics.xdpi;
        ydpi = displayMetrics.ydpi;
        densityDpi = displayMetrics.densityDpi;
        statusbarheight = getStatusBarHeight(context);
        navbarheight = getNavBarHeight(context);
        Log.d(TAG, "screenWidth=" + screenWidth + " screenHeight=" + screenHeight + " density=" + density);
    }

    public static int dip2px(float f2) {
        return (int) ((f2 * density) + 0.5f);
    }

    @Deprecated
    public static String getAppName(Context context) {
        return LibStorageUtils.getAppName(context);
    }

    public static int getDialogWidth() {
        double d2 = screenMin;
        double d3 = RATIO;
        Double.isNaN(d2);
        dialogWidth = (int) (d2 * d3);
        return dialogWidth;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0063 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.graphics.drawable.Drawable getDrawable(android.content.Context r5, java.lang.String r6) throws java.lang.Throwable {
        /*
            java.lang.String r0 = "getDrawable"
            r1 = 0
            android.content.res.Resources r2 = r5.getResources()     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L4b
            android.graphics.BitmapFactory$Options r3 = new android.graphics.BitmapFactory$Options     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L4b
            r3.<init>()     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L4b
            r4 = 240(0xf0, float:3.36E-43)
            r3.inDensity = r4     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L4b
            android.util.DisplayMetrics r4 = r2.getDisplayMetrics()     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L4b
            int r4 = r4.densityDpi     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L4b
            r3.inScreenDensity = r4     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L4b
            android.util.DisplayMetrics r2 = r2.getDisplayMetrics()     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L4b
            int r2 = r2.densityDpi     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L4b
            r3.inTargetDensity = r2     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L4b
            android.content.res.AssetManager r2 = r5.getAssets()     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L4b
            java.io.InputStream r6 = r2.open(r6)     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L4b
            android.graphics.Rect r2 = new android.graphics.Rect     // Catch: java.lang.Exception -> L47 java.lang.Throwable -> L5f
            r2.<init>()     // Catch: java.lang.Exception -> L47 java.lang.Throwable -> L5f
            android.graphics.Bitmap r2 = android.graphics.BitmapFactory.decodeStream(r6, r2, r3)     // Catch: java.lang.Exception -> L47 java.lang.Throwable -> L5f
            android.graphics.drawable.BitmapDrawable r3 = new android.graphics.drawable.BitmapDrawable     // Catch: java.lang.Exception -> L47 java.lang.Throwable -> L5f
            android.content.res.Resources r5 = r5.getResources()     // Catch: java.lang.Exception -> L47 java.lang.Throwable -> L5f
            r3.<init>(r5, r2)     // Catch: java.lang.Exception -> L47 java.lang.Throwable -> L5f
            if (r6 == 0) goto L46
            r6.close()     // Catch: java.io.IOException -> L40
            goto L46
        L40:
            r5 = move-exception
            java.lang.String r6 = io.rong.imkit.utilities.RongUtils.TAG
            io.rong.common.RLog.e(r6, r0, r5)
        L46:
            return r3
        L47:
            r5 = move-exception
            goto L4d
        L49:
            r5 = move-exception
            goto L61
        L4b:
            r5 = move-exception
            r6 = r1
        L4d:
            java.lang.String r2 = io.rong.imkit.utilities.RongUtils.TAG     // Catch: java.lang.Throwable -> L5f
            io.rong.common.RLog.e(r2, r0, r5)     // Catch: java.lang.Throwable -> L5f
            if (r6 == 0) goto L5e
            r6.close()     // Catch: java.io.IOException -> L58
            goto L5e
        L58:
            r5 = move-exception
            java.lang.String r6 = io.rong.imkit.utilities.RongUtils.TAG
            io.rong.common.RLog.e(r6, r0, r5)
        L5e:
            return r1
        L5f:
            r5 = move-exception
            r1 = r6
        L61:
            if (r1 == 0) goto L6d
            r1.close()     // Catch: java.io.IOException -> L67
            goto L6d
        L67:
            r6 = move-exception
            java.lang.String r1 = io.rong.imkit.utilities.RongUtils.TAG
            io.rong.common.RLog.e(r1, r0, r6)
        L6d:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.rong.imkit.utilities.RongUtils.getDrawable(android.content.Context, java.lang.String):android.graphics.drawable.Drawable");
    }

    @Deprecated
    public static String getFileSavePath(Context context) {
        return KitStorageUtils.getFileSavePath(context);
    }

    public static View getHorizontalThinLine(Context context) {
        View view = new View(context);
        view.setBackgroundColor(context.getResources().getColor(R.color.rc_divider_line));
        view.setLayoutParams(new LinearLayout.LayoutParams(-1, 1));
        return view;
    }

    @Deprecated
    public static String getImageSavePath(Context context) {
        return KitStorageUtils.getImageSavePath(context);
    }

    public static int getNavBarHeight(Context context) {
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("navigation_bar_height", "dimen", "android");
        if (identifier > 0) {
            return resources.getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public static Bitmap getResizedBitmap(Context context, Uri uri, int i, int i2) throws IOException {
        String string;
        int i3;
        int i4;
        Bitmap bitmapDecodeFile;
        if (!uri.getScheme().equals(LibStorageUtils.FILE)) {
            if (uri.getScheme().equals("content")) {
                Cursor cursorQuery = context.getContentResolver().query(uri, new String[]{"_data"}, null, null, null);
                cursorQuery.moveToFirst();
                string = cursorQuery.getString(0);
                cursorQuery.close();
            }
            return null;
        }
        string = uri.getPath();
        ExifInterface exifInterface = new ExifInterface(string);
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(string, options);
        int attributeInt = exifInterface.getAttributeInt("Orientation", 0);
        if (attributeInt == 6 || attributeInt == 8 || attributeInt == 5 || attributeInt == 7) {
            i3 = i;
            i4 = i2;
        } else {
            i4 = i;
            i3 = i2;
        }
        int i5 = options.outWidth;
        int i6 = options.outHeight;
        int i7 = 1;
        while (true) {
            i5 /= 2;
            if (i5 <= i4) {
                break;
            }
            i7 <<= 1;
        }
        int i8 = 1;
        while (true) {
            i6 /= 2;
            if (i6 <= i3) {
                break;
            }
            i8 <<= 1;
        }
        BitmapFactory.Options options2 = new BitmapFactory.Options();
        options2.inSampleSize = Math.max(i7, i8);
        try {
            bitmapDecodeFile = BitmapFactory.decodeFile(string, options2);
        } catch (OutOfMemoryError e2) {
            RLog.e(TAG, "getResizedBitmap", e2);
            options2.inSampleSize <<= 1;
            bitmapDecodeFile = BitmapFactory.decodeFile(string, options2);
        }
        Bitmap bitmap = bitmapDecodeFile;
        Matrix matrix = new Matrix();
        if (bitmap == null) {
            return bitmap;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (attributeInt == 6 || attributeInt == 8 || attributeInt == 5 || attributeInt == 7) {
            height = width;
            width = height;
        }
        switch (attributeInt) {
            case 2:
                matrix.preScale(-1.0f, 1.0f);
                break;
            case 3:
                matrix.setRotate(180.0f, width / 2.0f, height / 2.0f);
                break;
            case 4:
                matrix.preScale(1.0f, -1.0f);
                break;
            case 5:
                matrix.setRotate(90.0f, width / 2.0f, height / 2.0f);
                matrix.preScale(1.0f, -1.0f);
                break;
            case 6:
                matrix.setRotate(90.0f, width / 2.0f, height / 2.0f);
                break;
            case 7:
                matrix.setRotate(270.0f, width / 2.0f, height / 2.0f);
                matrix.preScale(1.0f, -1.0f);
                break;
            case 8:
                matrix.setRotate(270.0f, width / 2.0f, height / 2.0f);
                break;
        }
        float width2 = i4 / bitmap.getWidth();
        float height2 = i3 / bitmap.getHeight();
        matrix.postScale(Math.min(width2, height2), Math.min(width2, height2));
        try {
            return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        } catch (OutOfMemoryError e3) {
            RLog.e(TAG, "getResizedBitmap", e3);
            Log.e("ResourceCompressHandler", "OOMHeight:" + bitmap.getHeight() + "Width:" + bitmap.getHeight() + "matrix:" + width2 + " " + height2);
        }
    }

    public static int getScreenHeight() {
        return screenHeight;
    }

    public static int getScreenWidth() {
        return screenWidth;
    }

    public static int getStatusBarHeight(Context context) {
        try {
            Class<?> cls = Class.forName("com.android.internal.R$dimen");
            return context.getResources().getDimensionPixelSize(Integer.parseInt(cls.getField("status_bar_height").get(cls.newInstance()).toString()));
        } catch (Exception e2) {
            RLog.e(TAG, "getStatusBarHeight", e2);
            return 0;
        }
    }

    public static View getVerticalThinLine(Context context) {
        View view = new View(context);
        view.setBackgroundColor(context.getResources().getColor(R.color.rc_divider_line));
        view.setLayoutParams(new LinearLayout.LayoutParams(1, -1));
        return view;
    }

    public static int getVideoDuration(Context context, String str) {
        try {
            MediaPlayer mediaPlayerCreate = MediaPlayer.create(context, Uri.parse(str));
            int duration = mediaPlayerCreate.getDuration();
            mediaPlayerCreate.release();
            return duration;
        } catch (Exception e2) {
            RLog.e(TAG, e2.toString());
            return 0;
        }
    }

    @Deprecated
    public static String getVideoSavePath(Context context) {
        return KitStorageUtils.getVideoSavePath(context);
    }

    public static void init(Context context) {
        if (context == null) {
            return;
        }
        DisplayMetrics displayMetrics = context.getApplicationContext().getResources().getDisplayMetrics();
        screenWidth = displayMetrics.widthPixels;
        screenHeight = displayMetrics.heightPixels;
        int i = screenWidth;
        int i2 = screenHeight;
        if (i > i2) {
            i = i2;
        }
        screenMin = i;
        density = displayMetrics.density;
        scaleDensity = displayMetrics.scaledDensity;
        xdpi = displayMetrics.xdpi;
        ydpi = displayMetrics.ydpi;
        densityDpi = displayMetrics.densityDpi;
    }

    public static String md5(Object obj) {
        try {
            byte[] bArrDigest = MessageDigest.getInstance("MD5").digest(toByteArray(obj));
            StringBuilder sb = new StringBuilder(bArrDigest.length * 2);
            for (byte b2 : bArrDigest) {
                int i = b2 & 255;
                if (i < 16) {
                    sb.append("0");
                }
                sb.append(Integer.toHexString(i));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e2) {
            throw new RuntimeException("Huh, MD5 should be supported?", e2);
        }
    }

    public static int px2dip(float f2) {
        return (int) ((f2 / density) + 0.5f);
    }

    private static byte[] toByteArray(Object obj) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] byteArray = null;
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(obj);
            objectOutputStream.flush();
            byteArray = byteArrayOutputStream.toByteArray();
            objectOutputStream.close();
            byteArrayOutputStream.close();
            return byteArray;
        } catch (IOException e2) {
            RLog.e(TAG, "toByteArray", e2);
            return byteArray;
        }
    }
}
