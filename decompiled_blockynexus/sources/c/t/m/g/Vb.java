package c.t.m.g;

import android.location.Location;
import android.os.Parcelable;
import android.telephony.NeighboringCellInfo;
import android.text.TextUtils;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.map.geolocation.TencentLocationManagerOptions;
import com.tencent.map.geolocation.TencentPoi;
import com.umeng.analytics.pro.au;
import io.rong.imkit.plugin.LocationConst;
import java.io.ByteArrayOutputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.zip.GZIPOutputStream;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: TL */
/* JADX INFO: loaded from: classes.dex */
public final class Vb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f3026a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList<TencentPoi> f3027b = new ArrayList<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Lb f3028c;

    public Vb() {
    }

    private static double a(double d2) {
        return (d2 * 3.141592653589793d) / 180.0d;
    }

    private static int a(char c2) {
        int i = (c2 < 'A' || c2 > 'Z') ? 256 : c2 - 'A';
        if (c2 >= 'a' && c2 <= 'z') {
            i = (c2 - 'a') + 64;
        }
        return (c2 < '0' || c2 > '9') ? i : (c2 + 128) - 48;
    }

    public static byte[] a(byte[] bArr) {
        byte[] byteArray = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(bArr.length);
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
            byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            return byteArray;
        } catch (Throwable th) {
            th.printStackTrace();
            return byteArray;
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("DetailsData{");
        sb.append("subnation=");
        sb.append(this.f3028c);
        sb.append(",");
        sb.append("poilist=[");
        Iterator<TencentPoi> it = this.f3027b.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            sb.append(",");
        }
        sb.append("]");
        sb.append("}");
        return sb.toString();
    }

    public Vb(JSONObject jSONObject) throws JSONException {
        this.f3026a = jSONObject.optInt("stat");
        if (jSONObject.has("subnation")) {
            this.f3028c = new Lb(jSONObject.optJSONObject("subnation"));
        } else if (jSONObject.has("results")) {
            this.f3028c = a(jSONObject.optJSONArray("results"));
        } else {
            this.f3028c = Lb.f2954a;
        }
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("poilist");
        if (jSONArrayOptJSONArray != null) {
            try {
                int length = jSONArrayOptJSONArray.length();
                for (int i = 0; i < length; i++) {
                    this.f3027b.add(new Kb(jSONArrayOptJSONArray.getJSONObject(i)));
                }
            } catch (JSONException unused) {
            }
        }
    }

    public static boolean a(Location location, double[] dArr) {
        int latitude = (int) (location.getLatitude() * 1000000.0d);
        int longitude = (int) (location.getLongitude() * 1000000.0d);
        String strA = Wb.a("tencent_loc_lib");
        int iA = 0;
        for (int i = 0; i < strA.length(); i++) {
            iA += a(strA.charAt(i));
        }
        double[] dArr2 = new double[2];
        try {
            com.tencent.tencentmap.lbssdk.service.e.b(latitude ^ iA, longitude ^ iA, dArr2);
        } catch (UnsatisfiedLinkError unused) {
        }
        dArr[0] = dArr2[0];
        dArr[1] = dArr2[1];
        return true;
    }

    public static boolean a(double[] dArr, double[] dArr2) {
        if (TencentLocationManagerOptions.isLoadLibraryEnabled()) {
            try {
                System.loadLibrary("tencentloc");
            } catch (Throwable th) {
                new StringBuilder("LOAD:").append(th.toString());
                return false;
            }
        }
        int i = (int) (dArr[0] * 1000000.0d);
        int i2 = (int) (dArr[1] * 1000000.0d);
        String strA = Wb.a("tencent_loc_lib");
        int iA = 0;
        for (int i3 = 0; i3 < strA.length(); i3++) {
            iA += a(strA.charAt(i3));
        }
        double[] dArr3 = new double[2];
        try {
            com.tencent.tencentmap.lbssdk.service.e.b(i ^ iA, i2 ^ iA, dArr3);
            dArr2[0] = dArr3[0];
            dArr2[1] = dArr3[1];
            return true;
        } catch (Throwable th2) {
            new StringBuilder("E.B:").append(th2.toString());
            return false;
        }
    }

    public static double a(double d2, int i) {
        try {
            if (Double.isNaN(d2)) {
                return 0.0d;
            }
            return BigDecimal.valueOf(d2).setScale(i, RoundingMode.HALF_DOWN).doubleValue();
        } catch (Exception unused) {
            return 0.0d;
        }
    }

    public static String a(ek ekVar, boolean z) {
        List<NeighboringCellInfo> list;
        ArrayList arrayList;
        String str;
        String str2;
        String str3;
        String str4;
        ArrayList arrayList2;
        if (ekVar == null) {
            return "[]";
        }
        int i = ekVar.f3177b;
        int i2 = ekVar.f3178c;
        int iOrdinal = ekVar.f3176a.ordinal();
        ArrayList arrayList3 = new ArrayList();
        List<NeighboringCellInfo> listA = ekVar.a();
        if (Pb.a(iOrdinal, i, i2, ekVar.f3179d, ekVar.f3180e)) {
            int i3 = ekVar.f3179d;
            int i4 = ekVar.f3180e;
            int i5 = ekVar.f3181f;
            list = listA;
            int i6 = ekVar.g;
            int i7 = ekVar.h;
            arrayList = arrayList3;
            StringBuilder sb = new StringBuilder();
            sb.append("{");
            sb.append("\"mcc\":");
            sb.append(i);
            sb.append(",\"mnc\":");
            sb.append(i2);
            sb.append(",\"lac\":");
            sb.append(i3);
            sb.append(",\"cellid\":");
            sb.append(i4);
            sb.append(",\"rss\":");
            sb.append(i5);
            sb.append(",\"seed\":");
            sb.append(z ? 1 : 0);
            sb.append(",\"networktype\":");
            sb.append(iOrdinal);
            if (i6 != Integer.MAX_VALUE && i7 != Integer.MAX_VALUE) {
                sb.append(",\"stationLat\":");
                sb.append(String.format("%.6f", Float.valueOf(i6 / 14400.0f)));
                sb.append(",\"stationLng\":");
                sb.append(String.format("%.6f", Float.valueOf(i7 / 14400.0f)));
            }
            sb.append("}");
            arrayList.add(sb.toString());
            str4 = ",\"mnc\":";
            str2 = "}";
            str = "{";
            str3 = "\"mcc\":";
        } else {
            list = listA;
            arrayList = arrayList3;
            str = "{";
            str2 = "}";
            str3 = "\"mcc\":";
            str4 = ",\"mnc\":";
            a("illeagal main cell! ", i, i2, iOrdinal, ekVar.f3179d, ekVar.f3180e);
        }
        try {
            for (NeighboringCellInfo neighboringCellInfo : list) {
                int lac = neighboringCellInfo.getLac();
                int cid = neighboringCellInfo.getCid();
                if (Pb.a(iOrdinal, i, i2, lac, cid)) {
                    int rssi = (neighboringCellInfo.getRssi() << 1) - 113;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(str);
                    sb2.append(str3);
                    sb2.append(i);
                    sb2.append(str4);
                    sb2.append(i2);
                    sb2.append(",\"lac\":");
                    sb2.append(lac);
                    sb2.append(",\"cellid\":");
                    sb2.append(cid);
                    sb2.append(",\"rss\":");
                    sb2.append(rssi);
                    String str5 = str2;
                    sb2.append(str5);
                    ArrayList arrayList4 = arrayList;
                    try {
                        arrayList4.add(sb2.toString());
                        arrayList = arrayList4;
                        str2 = str5;
                    } catch (Exception unused) {
                        arrayList2 = arrayList4;
                    }
                } else {
                    String str6 = str2;
                    arrayList2 = arrayList;
                    try {
                        a("illeagal neighboringCell! ", i, i2, iOrdinal, lac, cid);
                        str2 = str6;
                        arrayList = arrayList2;
                    } catch (Exception unused2) {
                    }
                }
            }
        } catch (Exception unused3) {
        }
        arrayList2 = arrayList;
        StringBuilder sb3 = new StringBuilder("[");
        Rb rb = new Rb(",");
        Iterator<?> it = arrayList2.iterator();
        StringBuilder sb4 = new StringBuilder();
        rb.a(sb4, it);
        sb3.append(sb4.toString());
        sb3.append("]");
        return sb3.toString();
    }

    private static void a(String str, int i, int i2, int i3, int i4, int i5) {
        StringBuilder sb = new StringBuilder();
        sb.append("getCellInfoWithJsonFormat: ");
        sb.append(str);
        sb.append("isGsm=");
        sb.append(i3 == 1);
        sb.append(", mcc,mnc=");
        sb.append(i);
        sb.append(",");
        sb.append(i2);
        sb.append(", lac,cid=");
        sb.append(i4);
        sb.append(",");
        sb.append(i5);
    }

    public static boolean a(String str) {
        JSONObject jSONObject;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            jSONObject = new JSONObject(str);
        } catch (Exception unused) {
        }
        if (str.contains(LocationConst.LATITUDE)) {
            return true;
        }
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("cells");
        if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
            return true;
        }
        JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("wifis");
        return jSONArrayOptJSONArray2 != null && jSONArrayOptJSONArray2.length() > 0;
    }

    public static double a(double d2, double d3, double d4, double d5) {
        double dA = a(d2);
        double dA2 = a(d4);
        double dRound = Math.round(Math.asin(Math.sqrt(Math.pow(Math.sin((dA - dA2) / 2.0d), 2.0d) + (Math.cos(dA) * Math.cos(dA2) * Math.pow(Math.sin((a(d3) - a(d5)) / 2.0d), 2.0d)))) * 2.0d * 6378.137d * 10000.0d);
        Double.isNaN(dRound);
        return (dRound / 10000.0d) * 1000.0d;
    }

    public static Vb a(Vb vb) {
        if (vb == null) {
            return null;
        }
        Vb vb2 = new Vb();
        vb2.f3026a = vb.f3026a;
        vb2.f3028c = Lb.a(vb.f3028c);
        Iterator<TencentPoi> it = vb.f3027b.iterator();
        while (it.hasNext()) {
            vb2.f3027b.add(new Kb(it.next()));
        }
        return vb2;
    }

    private static Lb a(JSONArray jSONArray) {
        Lb lbA;
        JSONObject jSONObjectOptJSONObject;
        if (jSONArray == null || (lbA = Lb.a(Lb.f2954a)) == null) {
            return null;
        }
        int length = jSONArray.length();
        if (length > 0 && (jSONObjectOptJSONObject = jSONArray.optJSONObject(0)) != null) {
            lbA.f2955b = jSONObjectOptJSONObject.optString("n", null);
            lbA.f2959f = jSONObjectOptJSONObject.optString(au.aw, null);
            lbA.g = jSONObjectOptJSONObject.optString("c", null);
            lbA.h = jSONObjectOptJSONObject.optString(au.au, null);
            lbA.f2957d = jSONObjectOptJSONObject.optString("adcode", null);
        }
        if (length > 1) {
            JSONObject jSONObjectOptJSONObject2 = jSONArray.optJSONObject(1);
            lbA.n.putString("addrdesp.name", jSONObjectOptJSONObject2.optString("address_name"));
            JSONObject jSONObjectOptJSONObject3 = jSONObjectOptJSONObject2.optJSONObject("landmark");
            JSONObject jSONObjectOptJSONObject4 = jSONObjectOptJSONObject2.optJSONObject("second_landmark");
            if (jSONObjectOptJSONObject3 != null) {
                lbA.n.putParcelable(TencentLocation.EXTRA_ADDRDESP_LANDMARK, new Ib(jSONObjectOptJSONObject3));
            }
            if (jSONObjectOptJSONObject4 != null) {
                lbA.n.putParcelable(TencentLocation.EXTRA_ADDRDESP_SECOND_LANDMARK, new Ib(jSONObjectOptJSONObject4));
            }
        }
        if (length > 2) {
            ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
            for (int i = 2; i < length; i++) {
                Ib ib = new Ib(jSONArray.optJSONObject(i));
                arrayList.add(ib);
                if ("ST".equals(ib.f2927b)) {
                    lbA.k = ib.f2926a;
                } else if ("ST_NO".equals(ib.f2927b)) {
                    lbA.l = ib.f2926a;
                }
            }
            lbA.n.putParcelableArrayList(TencentLocation.EXTRA_ADDRDESP_OTHERS_RESULTS, arrayList);
        }
        return lbA;
    }
}
