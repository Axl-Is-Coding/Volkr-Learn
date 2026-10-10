package c.t.m.g;

import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class O {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<String, Object> f2968a = new HashMap();

    public final byte[] a() {
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<String, Object> entry : this.f2968a.entrySet()) {
            try {
                jSONObject.put(entry.getKey(), entry.getValue());
            } catch (Exception unused) {
            }
        }
        return jSONObject.toString().getBytes();
    }
}
