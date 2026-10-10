package com.ironsource.sdk.controller;

import android.content.Context;
import com.ironsource.sdk.controller.WebController;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: DeviceDataJSAdapter.java */
/* JADX INFO: loaded from: classes2.dex */
public class G {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f15145a = "G";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f15146b;

    /* JADX INFO: compiled from: DeviceDataJSAdapter.java */
    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f15147a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        JSONObject f15148b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        String f15149c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        String f15150d;

        private a() {
        }
    }

    public G(Context context) {
        this.f15146b = context;
    }

    void a(String str, WebController.c.a aVar) throws Exception {
        a aVarA = a(str);
        if ("getDeviceData".equals(aVarA.f15147a)) {
            aVar.a(true, aVarA.f15149c, a());
            return;
        }
        com.ironsource.sdk.utils.f.c(f15145a, "unhandled API request " + str);
    }

    private com.ironsource.sdk.data.f a() {
        com.ironsource.sdk.data.f fVar = new com.ironsource.sdk.data.f();
        fVar.a(com.ironsource.sdk.utils.i.b("sdCardAvailable"), com.ironsource.sdk.utils.i.b(String.valueOf(com.ironsource.environment.b.m())));
        fVar.a(com.ironsource.sdk.utils.i.b("totalDeviceRAM"), com.ironsource.sdk.utils.i.b(String.valueOf(com.ironsource.environment.b.n(this.f15146b))));
        fVar.a(com.ironsource.sdk.utils.i.b("isCharging"), com.ironsource.sdk.utils.i.b(String.valueOf(com.ironsource.environment.b.p(this.f15146b))));
        fVar.a(com.ironsource.sdk.utils.i.b("chargingType"), com.ironsource.sdk.utils.i.b(String.valueOf(com.ironsource.environment.b.a(this.f15146b))));
        fVar.a(com.ironsource.sdk.utils.i.b("airplaneMode"), com.ironsource.sdk.utils.i.b(String.valueOf(com.ironsource.environment.b.o(this.f15146b))));
        fVar.a(com.ironsource.sdk.utils.i.b("stayOnWhenPluggedIn"), com.ironsource.sdk.utils.i.b(String.valueOf(com.ironsource.environment.b.r(this.f15146b))));
        return fVar;
    }

    private a a(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        a aVar = new a();
        aVar.f15147a = jSONObject.optString("deviceDataFunction");
        aVar.f15148b = jSONObject.optJSONObject("deviceDataParams");
        aVar.f15149c = jSONObject.optString("success");
        aVar.f15150d = jSONObject.optString("fail");
        return aVar;
    }
}
