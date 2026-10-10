package com.tencent.mapsdk.rastercore.f;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import cn.qqtheme.framework.widget.WheelView;
import com.tencent.mapsdk.raster.model.BitmapDescriptorFactory;
import com.tencent.mapsdk.raster.model.GeoPoint;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.rastercore.d.f;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static int f19600a = 160;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int f19601b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f19602c;

    static {
        Double.doubleToRawLongBits(0.0d);
        Double.doubleToRawLongBits(-0.0d);
        f19601b = Float.floatToRawIntBits(WheelView.DividerConfig.FILL);
        f19602c = Float.floatToRawIntBits(-0.0f);
        Double.longBitsToDouble(4368491638549381120L);
        Double.longBitsToDouble(4503599627370496L);
    }

    public static int a(Object[] objArr) {
        return Arrays.hashCode(objArr);
    }

    public static Bitmap a(Bitmap bitmap, float f2) {
        if (bitmap != null && !bitmap.isRecycled()) {
            try {
                return Bitmap.createScaledBitmap(bitmap, (int) (bitmap.getWidth() * f2), (int) (bitmap.getHeight() * f2), true);
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public static Bitmap a(String str) {
        try {
            InputStream resourceAsStream = BitmapDescriptorFactory.class.getResourceAsStream("/assets/" + str);
            Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(resourceAsStream);
            resourceAsStream.close();
            return bitmapDecodeStream;
        } catch (Exception unused) {
            return null;
        }
    }

    public static GeoPoint a(LatLng latLng) {
        return new GeoPoint((int) (latLng.getLatitude() * 1000000.0d), (int) (latLng.getLongitude() * 1000000.0d));
    }

    public static LatLng a(GeoPoint geoPoint) {
        double latitudeE6 = geoPoint.getLatitudeE6();
        Double.isNaN(latitudeE6);
        double longitudeE6 = geoPoint.getLongitudeE6();
        Double.isNaN(longitudeE6);
        return new LatLng((latitudeE6 * 1.0d) / 1000000.0d, (longitudeE6 * 1.0d) / 1000000.0d);
    }

    public static String a() {
        Context contextA = f.a();
        String deviceId = (Build.VERSION.SDK_INT < 23 || (contextA != null && contextA.checkSelfPermission("android.permission.READ_PHONE_STATE") == 0)) ? ((TelephonyManager) contextA.getSystemService("phone")).getDeviceId() : "";
        if (TextUtils.isEmpty(deviceId)) {
            deviceId = "noIMEI";
        }
        return b(deviceId);
    }

    public static String a(Context context) {
        if (context == null) {
            return "";
        }
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(f.a().getPackageName(), 128);
            String string = applicationInfo.metaData.getString("com.tencent.map.api_key");
            return TextUtils.isEmpty(string) ? applicationInfo.metaData.getString("TencentMapSDK") : string;
        } catch (Exception e2) {
            new StringBuilder("error get mapkey:").append(e2.getMessage());
            return "";
        }
    }

    public static String a(String str, Object obj) {
        return str + "=" + String.valueOf(obj);
    }

    public static String a(String... strArr) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (String str : strArr) {
            sb.append(str);
            if (i != strArr.length - 1) {
                sb.append(",");
            }
            i++;
        }
        return sb.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x0019  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean a(float r6, float r7) {
        /*
            int r7 = java.lang.Float.floatToRawIntBits(r6)
            r0 = 0
            int r1 = java.lang.Float.floatToRawIntBits(r0)
            r2 = r7 ^ r1
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r2 & r3
            r3 = 0
            r4 = 1
            if (r2 != 0) goto L1d
            int r7 = r7 - r1
            int r7 = java.lang.Math.abs(r7)
            if (r7 > r4) goto L1b
        L19:
            r7 = 1
            goto L36
        L1b:
            r7 = 0
            goto L36
        L1d:
            if (r7 >= r1) goto L29
            int r2 = com.tencent.mapsdk.rastercore.f.b.f19601b
            int r1 = r1 - r2
            int r2 = com.tencent.mapsdk.rastercore.f.b.f19602c
            int r7 = r7 - r2
            r5 = r1
            r1 = r7
            r7 = r5
            goto L2f
        L29:
            int r2 = com.tencent.mapsdk.rastercore.f.b.f19601b
            int r7 = r7 - r2
            int r2 = com.tencent.mapsdk.rastercore.f.b.f19602c
            int r1 = r1 - r2
        L2f:
            if (r7 > r4) goto L1b
            int r7 = 1 - r7
            if (r1 > r7) goto L1b
            goto L19
        L36:
            if (r7 == 0) goto L45
            boolean r6 = java.lang.Float.isNaN(r6)
            if (r6 != 0) goto L45
            boolean r6 = java.lang.Float.isNaN(r0)
            if (r6 != 0) goto L45
            return r4
        L45:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mapsdk.rastercore.f.b.a(float, float):boolean");
    }

    public static boolean a(LatLng latLng, List<LatLng> list) {
        if (list == null || list.size() < 3 || latLng == null) {
            return false;
        }
        int size = list.size() - 1;
        boolean z = false;
        for (int i = 0; i < list.size(); i++) {
            if (((list.get(i).getLatitude() < latLng.getLatitude() && list.get(size).getLatitude() >= latLng.getLatitude()) || (list.get(size).getLatitude() < latLng.getLatitude() && list.get(i).getLatitude() >= latLng.getLatitude())) && (list.get(i).getLongitude() <= latLng.getLongitude() || list.get(size).getLongitude() <= latLng.getLongitude())) {
                z ^= list.get(i).getLongitude() + (((latLng.getLatitude() - list.get(i).getLatitude()) / (list.get(size).getLatitude() - list.get(i).getLatitude())) * (list.get(size).getLongitude() - list.get(i).getLongitude())) < latLng.getLongitude();
            }
            size = i;
        }
        return z;
    }

    public static final boolean a(Collection<?> collection) {
        return collection == null || collection.size() <= 0;
    }

    public static int b(Context context) {
        DisplayMetrics displayMetrics;
        if (context != null && (displayMetrics = context.getResources().getDisplayMetrics()) != null) {
            int i = displayMetrics.densityDpi;
            f19600a = i;
            return i;
        }
        return f19600a;
    }

    public static String b(String str) {
        if (str == null || str.length() == 0) {
            return "";
        }
        String strReplace = str.replace("&", "").replace("#", "").replace("?", "");
        try {
            return URLEncoder.encode(strReplace, "utf-8");
        } catch (UnsupportedEncodingException unused) {
            return strReplace;
        }
    }

    public static String c(Context context) {
        DisplayMetrics displayMetrics;
        if (context == null || (displayMetrics = context.getResources().getDisplayMetrics()) == null) {
            return "unknown";
        }
        return Integer.toString(displayMetrics.widthPixels) + "*" + Integer.toString(displayMetrics.heightPixels);
    }

    public static String d(Context context) {
        String strEncode = "";
        if (context == null) {
            return "";
        }
        PackageManager packageManager = context.getPackageManager();
        ApplicationInfo applicationInfo = null;
        try {
            applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 128);
        } catch (PackageManager.NameNotFoundException unused) {
        }
        try {
            strEncode = URLEncoder.encode((applicationInfo != null ? applicationInfo.loadLabel(packageManager) : "can't find app name").toString(), "utf-8");
        } catch (Exception unused2) {
        }
        return b(strEncode);
    }

    public static String e(Context context) {
        String str = "";
        if (context == null) {
            return "";
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            str = packageInfo.versionName + Integer.toString(packageInfo.versionCode);
        } catch (Exception unused) {
        }
        return b(str);
    }
}
