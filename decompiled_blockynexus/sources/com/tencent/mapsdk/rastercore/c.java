package com.tencent.mapsdk.rastercore;

import android.content.Context;
import android.graphics.Point;
import android.graphics.PointF;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.facebook.internal.AnalyticsEvents;
import com.tencent.mapsdk.raster.model.CameraPosition;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.raster.model.LatLngBounds;
import com.tencent.mapsdk.rastercore.b.f;
import com.tencent.mapsdk.rastercore.c.e;
import com.tencent.mapsdk.rastercore.d.h;
import com.tencent.mapsdk.rastercore.tile.MapTile;
import com.umeng.analytics.pro.ci;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Stack;
import java.util.zip.GZIPInputStream;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f19461a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private b f19462b;

    public interface a {
        void a(boolean z);
    }

    static class b extends AsyncTask<String, Void, Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private a f19463a;

        public b(a aVar) {
            this.f19463a = aVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean doInBackground(String... strArr) {
            if (strArr != null && strArr.length > 0) {
                InputStream gZIPInputStream = null;
                try {
                    try {
                        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(strArr[0]).openConnection();
                        httpURLConnection.setRequestProperty("Accept-Encoding", "gzip");
                        if (httpURLConnection.getResponseCode() == 200) {
                            String headerField = httpURLConnection.getHeaderField("Content-Encoding");
                            gZIPInputStream = headerField != null && headerField.length() > 0 && headerField.toLowerCase().contains("gzip") ? new GZIPInputStream(httpURLConnection.getInputStream()) : httpURLConnection.getInputStream();
                            String str = new String(c.a(gZIPInputStream));
                            new StringBuilder("TencentConfigChecker Response:").append(str);
                            JSONObject jSONObject = new JSONObject(str);
                            if (jSONObject.optInt("error") != 0) {
                                return false;
                            }
                            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("info");
                            if (jSONObjectOptJSONObject == null) {
                                return false;
                            }
                            JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("raster");
                            if (jSONObjectOptJSONObject2 == null) {
                                return false;
                            }
                            int iOptInt = jSONObjectOptJSONObject2.optInt(AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, 1000);
                            int iOptInt2 = jSONObjectOptJSONObject2.optInt("version", com.tencent.mapsdk.rastercore.b.f19432a);
                            int iOptInt3 = jSONObjectOptJSONObject2.optInt("sat", com.tencent.mapsdk.rastercore.b.f19434c);
                            int iOptInt4 = jSONObjectOptJSONObject2.optInt("cur", com.tencent.mapsdk.rastercore.b.f19433b);
                            com.tencent.mapsdk.rastercore.f.a aVarA = com.tencent.mapsdk.rastercore.f.a.a();
                            aVarA.a("tencent_style", iOptInt);
                            aVarA.a("tencent_version", iOptInt2);
                            aVarA.a("sat_version", iOptInt3);
                            aVarA.a("tencent_clean_cache_version", iOptInt4);
                            final boolean z = h.c() != iOptInt4;
                            final boolean z2 = h.d() != iOptInt3;
                            new Thread(this) { // from class: com.tencent.mapsdk.rastercore.c.b.1
                                @Override // java.lang.Thread, java.lang.Runnable
                                public final void run() {
                                    if (z) {
                                        com.tencent.mapsdk.rastercore.tile.a.a.a().a(MapTile.MapSource.TENCENT);
                                    }
                                    if (z2) {
                                        com.tencent.mapsdk.rastercore.tile.a.a.a().a(MapTile.MapSource.SATELLITE);
                                    }
                                }
                            }.start();
                            boolean z3 = (iOptInt2 != h.b()) | (iOptInt != h.a()) | (iOptInt4 != h.c());
                            boolean z4 = iOptInt3 != h.d();
                            h.a(iOptInt, iOptInt2, iOptInt4, iOptInt3);
                            return Boolean.valueOf(z4 | z3);
                        }
                    } catch (Exception e2) {
                        new StringBuilder("check version got error:").append(e2.getMessage());
                    }
                } finally {
                    c.a((Closeable) gZIPInputStream);
                }
            }
            return false;
        }

        @Override // android.os.AsyncTask
        protected final /* synthetic */ void onPostExecute(Boolean bool) {
            a aVar;
            Boolean bool2 = bool;
            if (bool2 == null || (aVar = this.f19463a) == null) {
                return;
            }
            aVar.a(bool2.booleanValue());
        }
    }

    public c(Context context, a aVar) {
        String strA = com.tencent.mapsdk.rastercore.f.b.a(context);
        context.getPackageName();
        StringBuilder sb = new StringBuilder(256);
        sb.append("https://confinfo.map.qq.com/confinfo?apikey=");
        sb.append(strA);
        sb.append("&type=2");
        sb.append("&pf=Android_2D");
        sb.append("&uk=");
        sb.append(com.tencent.mapsdk.rastercore.f.b.a());
        this.f19461a = sb.toString();
        this.f19462b = new b(aVar);
    }

    public static double a(LatLng latLng, LatLng latLng2) {
        double longitude = latLng.getLongitude();
        double d2 = longitude * 0.01745329251994329d;
        double latitude = latLng.getLatitude() * 0.01745329251994329d;
        double longitude2 = latLng2.getLongitude() * 0.01745329251994329d;
        double latitude2 = latLng2.getLatitude() * 0.01745329251994329d;
        double dSin = Math.sin(d2);
        double dSin2 = Math.sin(latitude);
        double dCos = Math.cos(d2);
        double dCos2 = Math.cos(latitude);
        double dSin3 = Math.sin(longitude2);
        double dSin4 = Math.sin(latitude2);
        double dCos3 = Math.cos(longitude2);
        double dCos4 = Math.cos(latitude2);
        double[] dArr = {dCos * dCos2, dCos2 * dSin, dSin2};
        double[] dArr2 = {dCos3 * dCos4, dCos4 * dSin3, dSin4};
        return Math.asin(Math.sqrt((((dArr[0] - dArr2[0]) * (dArr[0] - dArr2[0])) + ((dArr[1] - dArr2[1]) * (dArr[1] - dArr2[1]))) + ((dArr[2] - dArr2[2]) * (dArr[2] - dArr2[2]))) / 2.0d) * 1.27420015798544E7d;
    }

    public static int a(byte[] bArr, int i) {
        if (bArr == null || i + 4 > bArr.length) {
            throw new IllegalArgumentException("Four bytes are required for an integer.");
        }
        return ((bArr[i + 3] << 24) & (-16777216)) | (bArr[i + 0] & 255) | ((bArr[i + 1] << 8) & 65280) | ((bArr[i + 2] << ci.n) & 16711680);
    }

    public static NetworkInfo a(Context context) {
        try {
            return ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Exception unused) {
            return null;
        }
    }

    public static LatLng a(f fVar) {
        float fB = (float) ((fVar.b() * 180.0d) / 2.003750834E7d);
        Double.isNaN((float) ((fVar.a() * 180.0d) / 2.003750834E7d));
        return new LatLng((float) (((Math.atan(Math.exp((r4 * 3.141592653589793d) / 180.0d)) * 2.0d) - 1.5707963267948966d) * 57.29577951308232d), fB);
    }

    public static f a(PointF pointF, f fVar, PointF pointF2, com.tencent.mapsdk.rastercore.b.d dVar) {
        float f2 = pointF.x - pointF2.x;
        float f3 = pointF.y - pointF2.y;
        double dB = fVar.b();
        double d2 = f2;
        double d3 = dVar.d();
        Double.isNaN(d2);
        double d4 = dB + (d2 * d3);
        double dA = fVar.a();
        double d5 = f3;
        double d6 = dVar.d();
        Double.isNaN(d5);
        return new f(d4, dA - (d5 * d6));
    }

    public static f a(LatLng latLng) {
        if (latLng == null) {
            return null;
        }
        return new f((latLng.getLongitude() * 2.003750834E7d) / 180.0d, ((Math.log(Math.tan(((latLng.getLatitude() + 90.0d) * 3.141592653589793d) / 360.0d)) / 0.017453292519943295d) * 2.003750834E7d) / 180.0d);
    }

    public static com.tencent.mapsdk.rastercore.c.a a(float f2, Point point) {
        e eVar = new e();
        eVar.a(f2);
        eVar.a(point);
        return eVar;
    }

    public static com.tencent.mapsdk.rastercore.c.a a(CameraPosition cameraPosition) {
        com.tencent.mapsdk.rastercore.c.c cVar = new com.tencent.mapsdk.rastercore.c.c();
        cVar.a(cameraPosition);
        return cVar;
    }

    public static com.tencent.mapsdk.rastercore.c.a a(LatLngBounds latLngBounds, int i, int i2, int i3) {
        com.tencent.mapsdk.rastercore.c.b bVar = new com.tencent.mapsdk.rastercore.c.b();
        bVar.a(latLngBounds);
        bVar.c(i3);
        bVar.a(i);
        bVar.b(i2);
        return bVar;
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    public static boolean a(String str) {
        File[] fileArrListFiles;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Stack stack = new Stack();
        stack.push(str);
        while (!stack.isEmpty()) {
            File file = new File((String) stack.peek());
            if (file.exists()) {
                if (!file.isDirectory() || (fileArrListFiles = file.listFiles()) == null || fileArrListFiles.length == 0) {
                    file.delete();
                } else {
                    for (File file2 : fileArrListFiles) {
                        if (file2.isDirectory()) {
                            stack.push(file2.getAbsolutePath());
                        } else {
                            file2.delete();
                        }
                    }
                }
            }
            stack.pop();
        }
        return true;
    }

    public static byte[] a(InputStream inputStream) throws Throwable {
        ByteArrayOutputStream byteArrayOutputStream;
        byte[] bArr;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                try {
                    bArr = new byte[4096];
                } catch (IOException e2) {
                    e = e2;
                    new StringBuilder("IO:").append(e.toString());
                    a(byteArrayOutputStream);
                    return null;
                }
            } catch (Throwable th) {
                th = th;
            }
        } catch (IOException e3) {
            e = e3;
            byteArrayOutputStream = null;
        } catch (Throwable th2) {
            th = th2;
            byteArrayOutputStream = null;
        }
        while (true) {
            int i = inputStream.read(bArr, 0, bArr.length);
            if (i == -1) {
                byteArrayOutputStream.flush();
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                a(byteArrayOutputStream);
                return byteArray;
            }
            byteArrayOutputStream.write(bArr, 0, i);
            th = th;
            a(byteArrayOutputStream);
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0051  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String b(android.content.Context r11) {
        /*
            android.net.NetworkInfo r11 = a(r11)
            r0 = 6
            java.lang.String r1 = "ctwap"
            java.lang.String r2 = "3gwap"
            java.lang.String r3 = "uniwap"
            java.lang.String r4 = "cmwap"
            r5 = 5
            r6 = 4
            r7 = 3
            r8 = 2
            r9 = 1
            if (r11 == 0) goto L53
            boolean r10 = r11.isAvailable()
            if (r10 != 0) goto L1b
            goto L53
        L1b:
            int r10 = r11.getType()
            if (r10 != r9) goto L23
            r0 = 5
            goto L54
        L23:
            if (r10 == 0) goto L26
            goto L54
        L26:
            java.lang.String r11 = r11.getExtraInfo()
            if (r11 == 0) goto L54
            int r10 = r11.length()
            if (r10 != 0) goto L33
            goto L54
        L33:
            boolean r0 = r11.equalsIgnoreCase(r4)
            if (r0 == 0) goto L3b
            r0 = 1
            goto L54
        L3b:
            boolean r0 = r11.equalsIgnoreCase(r2)
            if (r0 != 0) goto L51
            boolean r0 = r11.equalsIgnoreCase(r3)
            if (r0 == 0) goto L49
            r0 = 2
            goto L54
        L49:
            boolean r11 = r11.equalsIgnoreCase(r1)
            if (r11 == 0) goto L51
            r0 = 4
            goto L54
        L51:
            r0 = 3
            goto L54
        L53:
            r0 = 0
        L54:
            if (r0 == r9) goto L68
            if (r0 == r8) goto L66
            if (r0 == r7) goto L64
            if (r0 == r6) goto L69
            if (r0 == r5) goto L61
            java.lang.String r1 = ""
            goto L69
        L61:
            java.lang.String r1 = "wifi"
            goto L69
        L64:
            r1 = r2
            goto L69
        L66:
            r1 = r3
            goto L69
        L68:
            r1 = r4
        L69:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mapsdk.rastercore.c.b(android.content.Context):java.lang.String");
    }

    public static boolean b(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            File file = new File(str);
            if (file.exists() && file.isDirectory()) {
                return true;
            }
            if (file.exists() && file.isFile()) {
                file.delete();
            }
            return file.mkdirs();
        } catch (Exception unused) {
            return false;
        }
    }

    public final void a() {
        this.f19462b.execute(this.f19461a);
    }
}
