package com.ironsource.sdk.controller;

import android.content.Context;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.NativeProtocol;
import com.ironsource.sdk.controller.WebController;
import com.sandboxol.blockmango.config.GameStringConstant;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.ironsource.sdk.controller.ca, reason: case insensitive filesystem */
/* JADX INFO: compiled from: PermissionsJSAdapter.java */
/* JADX INFO: loaded from: classes2.dex */
public class C2388ca {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f15264a = "ca";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f15265b;

    /* JADX INFO: renamed from: com.ironsource.sdk.controller.ca$a */
    /* JADX INFO: compiled from: PermissionsJSAdapter.java */
    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f15266a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        JSONObject f15267b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        String f15268c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        String f15269d;

        private a() {
        }
    }

    public C2388ca(Context context) {
        this.f15265b = context;
    }

    private a a(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        a aVar = new a();
        aVar.f15266a = jSONObject.optString(GameStringConstant.FUNCTION_NAME);
        aVar.f15267b = jSONObject.optJSONObject("functionParams");
        aVar.f15268c = jSONObject.optString("success");
        aVar.f15269d = jSONObject.optString("fail");
        return aVar;
    }

    public void b(JSONObject jSONObject, a aVar, WebController.c.a aVar2) {
        com.ironsource.sdk.data.f fVar = new com.ironsource.sdk.data.f();
        try {
            String string = jSONObject.getString("permission");
            fVar.a("permission", string);
            if (com.ironsource.environment.a.c(this.f15265b, string)) {
                fVar.a(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, String.valueOf(com.ironsource.environment.a.b(this.f15265b, string)));
                aVar2.a(true, aVar.f15268c, fVar);
            } else {
                fVar.a(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, "unhandledPermission");
                aVar2.a(false, aVar.f15269d, fVar);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            fVar.a("errMsg", e2.getMessage());
            aVar2.a(false, aVar.f15269d, fVar);
        }
    }

    void a(String str, WebController.c.a aVar) throws Exception {
        a aVarA = a(str);
        if ("getPermissions".equals(aVarA.f15266a)) {
            a(aVarA.f15267b, aVarA, aVar);
            return;
        }
        if ("isPermissionGranted".equals(aVarA.f15266a)) {
            b(aVarA.f15267b, aVarA, aVar);
            return;
        }
        com.ironsource.sdk.utils.f.c(f15264a, "PermissionsJSAdapter unhandled API request " + str);
    }

    public void a(JSONObject jSONObject, a aVar, WebController.c.a aVar2) {
        com.ironsource.sdk.data.f fVar = new com.ironsource.sdk.data.f();
        try {
            fVar.a(NativeProtocol.RESULT_ARGS_PERMISSIONS, com.ironsource.environment.a.a(this.f15265b, jSONObject.getJSONArray(NativeProtocol.RESULT_ARGS_PERMISSIONS)));
            aVar2.a(true, aVar.f15268c, fVar);
        } catch (Exception e2) {
            e2.printStackTrace();
            com.ironsource.sdk.utils.f.c(f15264a, "PermissionsJSAdapter getPermissions JSON Exception when getting permissions parameter " + e2.getMessage());
            fVar.a("errMsg", e2.getMessage());
            aVar2.a(false, aVar.f15269d, fVar);
        }
    }
}
