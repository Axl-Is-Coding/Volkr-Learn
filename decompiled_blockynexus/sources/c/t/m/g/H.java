package c.t.m.g;

import android.text.TextUtils;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
final class H implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private /* synthetic */ G f2917a;

    H(G g) {
        this.f2917a = g;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String strB = qc.b();
        G g = this.f2917a;
        byte[] bArrA = g.f2905a.a(strB);
        try {
            if (TextUtils.isEmpty(strB) || C0455pa.a(bArrA)) {
                return;
            }
            JSONObject jSONObject = new JSONObject(new String(bArrA));
            nc ncVar = new nc(strB);
            jSONObject.getString("ipInfo");
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("resultMap");
            if (jSONObjectOptJSONObject != null) {
                Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
                while (itKeys.hasNext()) {
                    JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray(itKeys.next());
                    if (jSONArrayOptJSONArray != null) {
                        G.a(ncVar, jSONArrayOptJSONArray);
                    }
                }
            }
            g.f2906b = ncVar;
            ic.c();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
