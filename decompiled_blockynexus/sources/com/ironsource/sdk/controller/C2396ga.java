package com.ironsource.sdk.controller;

import android.content.Context;
import com.ironsource.sdk.controller.WebController;
import com.sandboxol.blockmango.config.GameStringConstant;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.ironsource.sdk.controller.ga, reason: case insensitive filesystem */
/* JADX INFO: compiled from: TokenJSAdapter.java */
/* JADX INFO: loaded from: classes2.dex */
public class C2396ga {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f15277a = "ga";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.ironsource.sdk.service.g f15278b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Context f15279c;

    /* JADX INFO: renamed from: com.ironsource.sdk.controller.ga$a */
    /* JADX INFO: compiled from: TokenJSAdapter.java */
    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f15280a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        JSONObject f15281b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        String f15282c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        String f15283d;

        private a() {
        }
    }

    public C2396ga(Context context, com.ironsource.sdk.service.g gVar) {
        this.f15278b = gVar;
        this.f15279c = context;
    }

    private a a(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        a aVar = new a();
        aVar.f15280a = jSONObject.optString(GameStringConstant.FUNCTION_NAME);
        aVar.f15281b = jSONObject.optJSONObject("functionParams");
        aVar.f15282c = jSONObject.optString("success");
        aVar.f15283d = jSONObject.optString("fail");
        return aVar;
    }

    void a(String str, WebController.c.a aVar) throws Exception {
        a aVarA = a(str);
        if ("updateToken".equals(aVarA.f15280a)) {
            a(aVarA.f15281b, aVarA, aVar);
            return;
        }
        if ("getToken".equals(aVarA.f15280a)) {
            a(aVarA, aVar);
            return;
        }
        com.ironsource.sdk.utils.f.c(f15277a, "unhandled API request " + str);
    }

    public void a(JSONObject jSONObject, a aVar, WebController.c.a aVar2) {
        com.ironsource.sdk.data.f fVar = new com.ironsource.sdk.data.f();
        try {
            this.f15278b.a(jSONObject);
            aVar2.a(true, aVar.f15282c, fVar);
        } catch (Exception e2) {
            e2.printStackTrace();
            com.ironsource.sdk.utils.f.c(f15277a, "updateToken exception " + e2.getMessage());
            aVar2.a(false, aVar.f15283d, fVar);
        }
    }

    private void a(a aVar, WebController.c.a aVar2) {
        try {
            aVar2.a(true, aVar.f15282c, this.f15278b.b(this.f15279c));
        } catch (Exception e2) {
            aVar2.a(false, aVar.f15283d, e2.getMessage());
        }
    }
}
