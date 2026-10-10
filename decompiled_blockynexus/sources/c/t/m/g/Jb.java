package c.t.m.g;

import io.rong.imkit.plugin.LocationConst;
import org.json.JSONObject;

/* JADX INFO: compiled from: TL */
/* JADX INFO: loaded from: classes.dex */
public final class Jb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public double f2936a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public double f2937b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public double f2938c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f2939d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f2940e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f2941f;

    Jb() {
    }

    public Jb(JSONObject jSONObject) {
        this.f2936a = jSONObject.optDouble(LocationConst.LATITUDE, 0.0d);
        this.f2937b = jSONObject.optDouble(LocationConst.LONGITUDE, 0.0d);
        this.f2938c = jSONObject.optDouble("altitude", 0.0d);
        this.f2939d = (float) jSONObject.optDouble("accuracy", 0.0d);
        this.f2940e = jSONObject.optString("name", null);
        this.f2941f = jSONObject.optString("addr", null);
    }
}
