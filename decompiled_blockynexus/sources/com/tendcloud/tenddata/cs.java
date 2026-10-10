package com.tendcloud.tenddata;

import com.facebook.places.model.PlaceFields;
import com.sandboxol.blocky.config.GameSharedConstant;
import org.json.JSONObject;

/* JADX INFO: compiled from: td */
/* JADX INFO: loaded from: classes5.dex */
public class cs extends cx {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static cs f19968a;

    private cs() {
    }

    public static synchronized cs a() {
        if (f19968a == null) {
            f19968a = new cs();
        }
        return f19968a;
    }

    public void setAccount(JSONObject jSONObject) {
        a(GameSharedConstant.ACCOUNT, (Object) jSONObject);
    }

    public void setAntiCheatingstatus(int i) {
        a("antiCheating", Integer.valueOf(i));
    }

    public void setCurrentPageName(String str) {
        a(PlaceFields.PAGE, str);
    }

    public void setDeepLink(String str) {
        try {
            a("deeplink", str);
            n.setDeepLink(str);
        } catch (Throwable th) {
            bp.postSDKError(th);
        }
    }

    public void setPushInfo(String str) {
        a("push", str);
    }

    public void setSessionId(String str) {
        a("sessionId", str);
    }

    public void setSessionStartTime(long j) {
        a("sessionStartTime", Long.valueOf(j));
    }

    public void setSubaccount(JSONObject jSONObject) {
        a("subaccount", (Object) jSONObject);
    }
}
