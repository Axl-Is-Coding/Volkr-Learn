package com.ironsource.mediationsdk.c;

import com.ironsource.mediationsdk.logger.IronLog;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: ImpressionData.java */
/* JADX INFO: loaded from: classes2.dex */
public class a {
    private String A;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f14799a = "auctionId";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f14800b = "adUnit";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f14801c = "country";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f14802d = "ab";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f14803e = "segmentName";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f14804f = "placement";
    private final String g = "adNetwork";
    private final String h = "instanceName";
    private final String i = "instanceId";
    private final String j = "revenue";
    private final String k = "precision";
    private final String l = "lifetimeRevenue";
    private final String m = "encryptedCPM";
    private JSONObject n;
    private String o;
    private String p;
    private String q;
    private String r;
    private String s;
    private String t;
    private String u;
    private String v;
    private String w;
    private Double x;
    private String y;
    private Double z;

    public a(JSONObject jSONObject) {
        Double dValueOf = null;
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.t = null;
        this.u = null;
        this.v = null;
        this.w = null;
        this.x = null;
        this.y = null;
        this.z = null;
        this.A = null;
        if (jSONObject != null) {
            try {
                this.n = jSONObject;
                this.o = jSONObject.optString("auctionId", null);
                this.p = jSONObject.optString("adUnit", null);
                this.q = jSONObject.optString("country", null);
                this.r = jSONObject.optString("ab", null);
                this.s = jSONObject.optString("segmentName", null);
                this.t = jSONObject.optString("placement", null);
                this.u = jSONObject.optString("adNetwork", null);
                this.v = jSONObject.optString("instanceName", null);
                this.w = jSONObject.optString("instanceId", null);
                this.y = jSONObject.optString("precision", null);
                this.A = jSONObject.optString("encryptedCPM", null);
                double dOptDouble = jSONObject.optDouble("lifetimeRevenue");
                this.z = Double.isNaN(dOptDouble) ? null : Double.valueOf(dOptDouble);
                double dOptDouble2 = jSONObject.optDouble("revenue");
                if (!Double.isNaN(dOptDouble2)) {
                    dValueOf = Double.valueOf(dOptDouble2);
                }
                this.x = dValueOf;
            } catch (Exception e2) {
                IronLog.INTERNAL.error("error parsing impression " + e2.getMessage());
            }
        }
    }

    public void a(String str, String str2) {
        String str3 = this.t;
        if (str3 != null) {
            this.t = str3.replace(str, str2);
            JSONObject jSONObject = this.n;
            if (jSONObject != null) {
                try {
                    jSONObject.put("placement", this.t);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public String toString() {
        return "ImpressionData{auctionId='" + this.o + "', adUnit='" + this.p + "', country='" + this.q + "', ab='" + this.r + "', segmentName='" + this.s + "', placement='" + this.t + "', adNetwork='" + this.u + "', instanceName='" + this.v + "', instanceId='" + this.w + "', revenue=" + this.x + ", precision='" + this.y + "', lifetimeRevenue=" + this.z + ", encryptedCPM='" + this.A + "'}";
    }
}
