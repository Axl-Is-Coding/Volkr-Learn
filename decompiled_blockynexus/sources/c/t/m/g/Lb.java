package c.t.m.g;

import android.os.Bundle;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: TL */
/* JADX INFO: loaded from: classes.dex */
public final class Lb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lb f2954a = new Lb();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f2955b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f2956c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f2957d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f2958e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f2959f;
    public String g;
    public String h;
    public String i;
    public String j;
    public String k;
    public String l;
    public String m;
    public final Bundle n = new Bundle();

    Lb() {
    }

    public static Lb a(Lb lb) {
        if (lb == null) {
            return null;
        }
        return new Lb(lb);
    }

    public final String toString() {
        return "SubnationData{name=" + this.f2956c + ",address=" + this.m + ",code=" + this.f2957d + ",phCode=" + this.f2958e + ",nation=" + this.f2955b + ",province=" + this.f2959f + ",city=" + this.g + ",district=" + this.h + ",town=" + this.i + ",village=" + this.j + ",street=" + this.k + ",street_no=" + this.l + ",bundle" + this.n + ",}";
    }

    private Lb(Lb lb) {
        if (lb.n.size() > 0) {
            this.n.putAll(lb.n);
            return;
        }
        this.f2955b = lb.f2955b;
        this.f2956c = lb.f2956c;
        this.f2957d = lb.f2957d;
        this.f2958e = lb.f2958e;
        this.f2959f = lb.f2959f;
        this.g = lb.g;
        this.h = lb.h;
        this.i = lb.i;
        this.j = lb.j;
        this.k = lb.k;
        this.l = lb.l;
        this.m = lb.m;
    }

    public Lb(JSONObject jSONObject) throws JSONException {
        if (jSONObject.has("admin_level_1")) {
            String strOptString = jSONObject.optString("nation");
            String strOptString2 = jSONObject.optString("admin_level_1");
            String strOptString3 = jSONObject.optString("admin_level_2");
            String strOptString4 = jSONObject.optString("admin_level_3");
            String strOptString5 = jSONObject.optString("locality");
            String strOptString6 = jSONObject.optString("sublocality");
            String strOptString7 = jSONObject.optString("route");
            this.n.putString("nation", strOptString);
            this.n.putString("admin_level_1", strOptString2);
            this.n.putString("admin_level_2", strOptString3);
            this.n.putString("admin_level_3", strOptString4);
            this.n.putString("locality", strOptString5);
            this.n.putString("sublocality", strOptString6);
            this.n.putString("route", strOptString7);
            return;
        }
        this.f2956c = jSONObject.optString("name", null);
        this.f2957d = jSONObject.optString("code", null);
        this.f2958e = jSONObject.optString("pncode", null);
        this.f2955b = jSONObject.optString("nation", null);
        this.f2959f = jSONObject.optString("province", null);
        this.g = jSONObject.optString("city", null);
        this.h = jSONObject.optString("district", null);
        this.i = jSONObject.optString("town", null);
        this.j = jSONObject.optString("village", null);
        this.k = jSONObject.optString("street", null);
        this.l = jSONObject.optString("street_no", null);
        String strOptString8 = jSONObject.optString("mergedname", null);
        String strOptString9 = jSONObject.optString("mergedaddr", null);
        if (!TextUtils.isEmpty(strOptString8)) {
            this.f2956c = strOptString8;
        }
        if (TextUtils.isEmpty(strOptString9)) {
            return;
        }
        this.m = strOptString9;
    }
}
