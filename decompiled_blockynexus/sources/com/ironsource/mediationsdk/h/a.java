package com.ironsource.mediationsdk.h;

import com.ironsource.mediationsdk.logger.IronLog;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: IronsourceJsonUtilities.java */
/* JADX INFO: loaded from: classes2.dex */
public class a {
    public static JSONObject a(JSONObject... jSONObjectArr) {
        JSONObject jSONObject = new JSONObject();
        if (jSONObjectArr != null) {
            for (JSONObject jSONObject2 : jSONObjectArr) {
                if (jSONObject2 != null) {
                    Iterator<String> itKeys = jSONObject2.keys();
                    while (itKeys.hasNext()) {
                        String next = itKeys.next();
                        try {
                            jSONObject.put(next, jSONObject2.get(next));
                        } catch (JSONException e2) {
                            IronLog.INTERNAL.error(e2.getMessage());
                        }
                    }
                }
            }
        }
        return jSONObject;
    }
}
