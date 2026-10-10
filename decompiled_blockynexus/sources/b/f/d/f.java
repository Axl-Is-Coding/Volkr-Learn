package b.f.d;

import org.json.JSONObject;

/* JADX INFO: compiled from: IronSourceNetworkAPIUtils.java */
/* JADX INFO: loaded from: classes2.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static String f2737a = "ManRewInst_";

    public static String a(JSONObject jSONObject) {
        if (!jSONObject.optBoolean("rewarded")) {
            return jSONObject.optString("name");
        }
        return f2737a + jSONObject.optString("name");
    }
}
