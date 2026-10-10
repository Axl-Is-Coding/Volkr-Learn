package c.t.m.g;

import android.location.Location;
import android.net.wifi.ScanResult;
import android.os.Build;
import android.os.SystemClock;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: TL */
/* JADX INFO: loaded from: classes.dex */
public final class Aa {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile String f2868a = "209";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile String f2869b = "fc_sdk";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Comparator<Object> f2870c = new C0484za();

    public static String a(Da da, Location location, List<ScanResult> list, List<cp> list2) {
        int size;
        String str;
        int i;
        String str2;
        String str3 = "[| _]";
        if (list != null) {
            try {
                size = list.size();
            } catch (Throwable th) {
                th = th;
                str = "";
                C0458qa.a("get write string error!", th);
                return str;
            }
        } else {
            size = 0;
        }
        int size2 = list2 != null ? list2.size() : 0;
        if (da != null && location != null && (size != 0 || size2 != 0)) {
            C0458qa.d();
            StringBuilder sb = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            StringBuilder sb3 = new StringBuilder();
            StringBuilder sb4 = new StringBuilder();
            sb.append(0);
            sb.append(",");
            sb.append(String.format("%.6f", Double.valueOf(location.getLatitude())));
            sb.append(",");
            sb.append(String.format("%.6f", Double.valueOf(location.getLongitude())));
            sb.append(",");
            str = "";
            try {
                sb.append((int) location.getAltitude());
                sb.append(",");
                sb.append((int) location.getAccuracy());
                sb.append(",");
                sb.append((int) location.getBearing());
                sb.append(",");
                sb.append(String.format("%.1f", Float.valueOf(location.getSpeed())));
                sb.append(",");
                sb.append(location.getTime());
                if (list2 != null && list2.size() > 0) {
                    int i2 = 0;
                    while (i2 < list2.size()) {
                        cp cpVar = list2.get(i2);
                        sb2.append(i2 == 0 ? str : ";");
                        sb2.append(cpVar.f3109a);
                        sb2.append(",");
                        sb2.append(cpVar.f3110b);
                        sb2.append(",");
                        sb2.append(cpVar.f3111c);
                        sb2.append(",");
                        sb2.append(cpVar.f3112d);
                        sb2.append(",");
                        sb2.append(cpVar.f3113e);
                        i2++;
                    }
                }
                if (list != null && list.size() > 0) {
                    Object[] array = list.toArray();
                    Arrays.sort(array, f2870c);
                    long jElapsedRealtime = SystemClock.elapsedRealtime() / 1000;
                    int i3 = 0;
                    while (i3 < array.length) {
                        ScanResult scanResult = (ScanResult) array[i3];
                        sb3.append(i3 == 0 ? str : "&");
                        sb3.append(scanResult.BSSID.replaceAll(":", str).toLowerCase());
                        sb3.append("&");
                        sb3.append(scanResult.level);
                        Object[] objArr = array;
                        if (Build.VERSION.SDK_INT >= 17) {
                            str2 = str3;
                            int i4 = scanResult.timestamp > 0 ? (int) (jElapsedRealtime - ((scanResult.timestamp / 1000) / 1000)) : -1;
                            sb4.append(i3 == 0 ? str : "&");
                            sb4.append(i4);
                        } else {
                            str2 = str3;
                        }
                        i3++;
                        str3 = str2;
                        array = objArr;
                    }
                }
                String str4 = str3;
                StringBuilder sb5 = new StringBuilder();
                String strA = Da.a();
                if (strA != null && strA.length() > 5) {
                    try {
                        JSONObject jSONObject = new JSONObject(strA);
                        sb5.append(jSONObject.optString("mac").replaceAll(":", str).toLowerCase());
                        sb5.append("&");
                        sb5.append(jSONObject.optString("ssid"));
                        sb5.append("&");
                        sb5.append(jSONObject.optString("rssi"));
                        i = 0;
                    } catch (Throwable unused) {
                        i = 0;
                        sb5.setLength(0);
                    }
                    if (sb5.length() < 5) {
                        sb5.setLength(i);
                    }
                }
                String str5 = Da.a(da.f2895b).replaceAll(str4, str) + "_" + Da.a(da.f2894a);
                String str6 = Da.a(Build.MANUFACTURER).replaceAll(str4, str) + "_" + Da.a(Build.MODEL).replaceAll(str4, str);
                StringBuilder sb6 = new StringBuilder();
                SimpleDateFormat simpleDateFormatA = Ua.a("yyyy-MM-dd HH:mm:ss");
                sb6.append("[");
                sb6.append(simpleDateFormatA.format(new Date()));
                sb6.append("]:1.4.8|");
                sb6.append(f2868a);
                sb6.append("|");
                sb6.append(Da.a(da.f2896c));
                sb6.append("|");
                sb6.append(C0481ya.f3449d ? Ca.a() : str);
                sb6.append("|");
                sb6.append(C0481ya.f3449d ? Ca.c() : str);
                sb6.append("||");
                sb6.append(C0481ya.f3449d ? Ca.d() : str);
                sb6.append("|||||");
                sb6.append((CharSequence) sb);
                sb6.append("||");
                sb6.append((CharSequence) sb2);
                sb6.append("|");
                sb6.append((CharSequence) sb3);
                sb6.append("||||||||||||||||");
                sb6.append(f2869b);
                sb6.append("||||");
                sb6.append((CharSequence) sb5);
                sb6.append("||");
                sb6.append(C0481ya.f3449d ? Ca.e().replaceAll(":", str).toLowerCase() : str);
                sb6.append("|");
                sb6.append(str5);
                sb6.append("|");
                sb6.append(Ca.b());
                sb6.append("||");
                sb6.append(str6);
                sb6.append("||||||||||||");
                sb6.append(sb4.toString());
                sb6.append("|");
                return sb6.toString();
            } catch (Throwable th2) {
                th = th2;
                C0458qa.a("get write string error!", th);
                return str;
            }
        }
        return "";
    }

    public static void b(String str) {
        f2868a = str;
    }

    public static void a(String str) {
        f2869b = str;
    }
}
