package com.ironsource.mediationsdk;

import android.content.Context;
import android.text.TextUtils;
import com.ironsource.mediationsdk.logger.IronLog;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: TokenDataService.java */
/* JADX INFO: loaded from: classes2.dex */
class Wa {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Wa f14741a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private JSONObject f14742b = new JSONObject();

    private Wa() {
    }

    public static synchronized Wa b() {
        if (f14741a == null) {
            f14741a = new Wa();
        }
        return f14741a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject c() {
        String strL;
        String str = "";
        JSONObject jSONObject = new JSONObject();
        Context contextA = com.ironsource.mediationsdk.utils.c.c().a();
        if (contextA != null) {
            boolean zBooleanValue = false;
            try {
                String[] strArrC = com.ironsource.environment.b.c(contextA);
                if (strArrC == null || strArrC.length != 2) {
                    strL = "";
                } else {
                    strL = !TextUtils.isEmpty(strArrC[0]) ? strArrC[0] : "";
                    try {
                        zBooleanValue = Boolean.valueOf(strArrC[1]).booleanValue();
                    } catch (Exception e2) {
                        e = e2;
                        IronLog.INTERNAL.error("got the following error " + e.getMessage());
                    }
                }
            } catch (Exception e3) {
                e = e3;
                strL = "";
            }
            if (TextUtils.isEmpty(strL)) {
                strL = com.ironsource.environment.b.l(contextA);
                if (!TextUtils.isEmpty(strL)) {
                    str = "UUID";
                }
            } else {
                str = "GAID";
            }
            try {
                jSONObject.put("advId", strL);
                jSONObject.put("advType", str);
                jSONObject.put("isLAT", zBooleanValue);
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
        return jSONObject;
    }

    synchronized void a(String str, Object obj) {
        try {
            this.f14742b.put(str, obj);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(JSONObject jSONObject) {
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            a(next, jSONObject.opt(next));
        }
    }

    void a() {
        try {
            new Thread(new Va(this)).start();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
