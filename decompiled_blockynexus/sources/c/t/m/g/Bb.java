package c.t.m.g;

import android.location.Location;
import android.net.wifi.ScanResult;
import android.text.TextUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import org.json.JSONObject;

/* JADX INFO: compiled from: TL */
/* JADX INFO: loaded from: classes.dex */
public final class Bb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f2878a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Db f2879b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ek f2880c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final el f2881d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final List<Ab> f2882e;

    public Bb(Db db, ek ekVar, el elVar, List<Ab> list) {
        this.f2879b = db;
        this.f2880c = ekVar;
        this.f2881d = elVar;
        this.f2882e = list;
    }

    private String b(int i, String str, C0423eb c0423eb, boolean z, boolean z2, boolean z3) {
        boolean z4;
        String string;
        CharSequence charSequence;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        Object obj;
        String str7;
        String str8;
        Bb bb;
        C0423eb c0423eb2;
        CharSequence charSequence2;
        String strA;
        if (c0423eb == null) {
            return null;
        }
        try {
            int i2 = 0;
            if (this.f2880c == null) {
                z4 = true;
            } else {
                z4 = f2878a != this.f2880c.f3180e;
                f2878a = this.f2880c.f3180e;
            }
            Db db = this.f2879b;
            List<ScanResult> listUnmodifiableList = db == null ? null : Collections.unmodifiableList(db.f2898b);
            if (listUnmodifiableList == null) {
                string = "[]";
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("[");
                try {
                    if (listUnmodifiableList.size() <= 0) {
                        sb.append("]");
                        string = sb.toString();
                    } else {
                        for (ScanResult scanResult : listUnmodifiableList) {
                            listUnmodifiableList.size();
                            if (i2 > 0) {
                                sb.append(",");
                            }
                            sb.append("{\"mac\":\"");
                            sb.append(scanResult.BSSID.replace(":", ""));
                            sb.append("\",");
                            sb.append("\"rssi\":");
                            sb.append(scanResult.level);
                            sb.append("}");
                            i2++;
                        }
                        sb.append("]");
                        string = sb.toString();
                    }
                } catch (Throwable unused) {
                    return null;
                }
            }
            String strA2 = Vb.a(this.f2880c, z4);
            el elVar = this.f2881d;
            String string2 = "{}";
            if (elVar == null) {
                str6 = string;
                str3 = strA2;
                str4 = "{}";
                str5 = "[";
                obj = "[]";
                str8 = "}";
                charSequence = "";
                str2 = "]";
                bb = this;
                str7 = ",\"source\":";
            } else {
                Location location = elVar.f3187a;
                StringBuilder sb2 = new StringBuilder();
                charSequence = "";
                str2 = "]";
                str3 = strA2;
                double dA = Vb.a(location.getLatitude(), 6);
                str4 = "{}";
                str5 = "[";
                double dA2 = Vb.a(location.getLongitude(), 6);
                str6 = string;
                obj = "[]";
                double dA3 = Vb.a(location.getAltitude(), 1);
                try {
                    double dA4 = Vb.a(location.getAccuracy(), 1);
                    double dA5 = Vb.a(location.getBearing(), 1);
                    double dA6 = Vb.a(location.getSpeed(), 1);
                    sb2.append("{");
                    sb2.append("\"latitude\":");
                    sb2.append(dA);
                    sb2.append(",\"longitude\":");
                    sb2.append(dA2);
                    sb2.append(",\"additional\":");
                    sb2.append("\"" + dA3 + "," + dA4 + "," + dA5 + "," + dA6 + "," + elVar.f3188b + "\"");
                    str7 = ",\"source\":";
                    sb2.append(str7);
                    sb2.append(elVar.f3192f - 1);
                    str8 = "}";
                    sb2.append(str8);
                    string2 = sb2.toString();
                    bb = this;
                } catch (Throwable unused2) {
                    return null;
                }
            }
            try {
                String strA3 = Ab.a(bb.f2882e);
                if (z2) {
                    c0423eb2 = c0423eb;
                    string2 = str4;
                } else {
                    c0423eb2 = c0423eb;
                }
                Ya ya = c0423eb2.f3148d;
                HashMap map = new HashMap();
                map.put("imei", ya.a());
                map.put("imsi", ya.b());
                map.put("phonenum", C0458qa.a(ya.f3061e));
                map.put("qq", C0458qa.a(ya.g));
                map.put("mac", ya.c().toLowerCase(Locale.ENGLISH));
                String string3 = new JSONObject(map).toString();
                String strF = ya.f();
                Tb.a();
                int iA = Tb.a(c0423eb2.f3147c);
                String strC = Xb.c(c0423eb);
                String str9 = str6;
                try {
                    if (str9.equals(obj) && !strC.equals(str4)) {
                        JSONObject jSONObject = new JSONObject(strC);
                        jSONObject.remove("ssid");
                        str9 = str5 + jSONObject.toString() + str2;
                    }
                } catch (Throwable unused3) {
                }
                String strReplace = ya.l;
                if (strReplace != null) {
                    charSequence2 = charSequence;
                    strReplace = strReplace.replace("\"", charSequence2);
                } else {
                    charSequence2 = charSequence;
                }
                if (strReplace != null) {
                    strReplace = strReplace.replace("|", charSequence2);
                }
                String str10 = strReplace + "_" + ya.j;
                int iAbs = 203;
                if (z3 && (strA = ya.a()) != null) {
                    iAbs = (Math.abs(strA.hashCode()) % 1000) + 1001;
                }
                StringBuilder sb3 = new StringBuilder("{\"version\":\"");
                sb3.append(ya.G == null ? "None" : ya.G);
                sb3.append("\",\"address\":");
                sb3.append(i);
                String str11 = (sb3.toString() + str7 + iAbs + ",\"access_token\":\"" + strF + "\",\"app_name\":\"" + str + "\",\"app_label\":\"" + str10 + "\",\"bearing\":1") + ",\"control\":0";
                if (!TextUtils.isEmpty(C0458qa.a(ya.h))) {
                    str11 = str11 + ",\"smallappname\":\"" + C0458qa.a(ya.h) + "\"";
                }
                return (((z ? str11 + ",\"detectgps\":1" : str11 + ",\"detectgps\":0") + ",\"pstat\":" + iA) + ",\"wlan\":" + strC) + ",\"attribute\":" + string3 + ",\"location\":" + string2 + ",\"cells\":" + str3 + ",\"wifis\":" + str9 + ",\"bles\":" + strA3 + str8;
            } catch (Throwable unused4) {
                return null;
            }
        } catch (Throwable unused5) {
        }
    }

    public final String a(int i, String str, C0423eb c0423eb, boolean z, boolean z2, boolean z3) {
        return b(i, str, c0423eb, z, z2, z3);
    }
}
