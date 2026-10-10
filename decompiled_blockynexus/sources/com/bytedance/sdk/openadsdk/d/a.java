package com.bytedance.sdk.openadsdk.d;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.d.h;
import com.bytedance.sdk.openadsdk.utils.ab;
import com.facebook.internal.AnalyticsEvents;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: JsAppAdDownloadManager.java */
/* JADX INFO: loaded from: classes.dex */
public class a implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final h f6696a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final b f6697b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map<String, b.a.a.a.a.a.b> f6698c = new HashMap();

    private a(b bVar, h hVar) {
        this.f6697b = bVar;
        this.f6696a = hVar;
    }

    public static a a(b bVar, h hVar) {
        return new a(bVar, hVar);
    }

    @Override // com.bytedance.sdk.openadsdk.d.c
    public void a() {
    }

    @Override // com.bytedance.sdk.openadsdk.d.c
    public void b() {
    }

    @Override // com.bytedance.sdk.openadsdk.d.c
    public void c() {
        this.f6698c.clear();
    }

    private h a(JSONObject jSONObject, String str) {
        if (jSONObject == null) {
            return null;
        }
        h hVar = new h();
        hVar.b(jSONObject);
        if (!TextUtils.isEmpty(str)) {
            hVar.j(str);
        }
        if (this.f6696a == null) {
            return hVar;
        }
        String strA = hVar.K() != null ? hVar.K().a() : null;
        return TextUtils.isEmpty(strA) ? this.f6696a : (this.f6696a.K() == null || !strA.equals(this.f6696a.K().a())) ? hVar : this.f6696a;
    }

    @Override // com.bytedance.sdk.openadsdk.d.c
    public void a(Context context, JSONObject jSONObject, String str, int i, boolean z) {
        JSONObject jSONObjectOptJSONObject;
        if (context == null || jSONObject == null || (jSONObjectOptJSONObject = jSONObject.optJSONObject("data")) == null) {
            return;
        }
        a(context, a(jSONObjectOptJSONObject, str), jSONObjectOptJSONObject, i, z);
    }

    private void a(Context context, h hVar, JSONObject jSONObject, int i, boolean z) {
        if (context == null || hVar == null || hVar.K() == null || jSONObject == null || this.f6697b == null || this.f6698c.get(hVar.K().a()) != null) {
            return;
        }
        String strA = ab.a(i);
        if (TextUtils.isEmpty(strA)) {
            return;
        }
        this.f6698c.put(hVar.K().a(), a(context, hVar, jSONObject, strA, z));
    }

    @Override // com.bytedance.sdk.openadsdk.d.c
    public void a(Context context, JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        if (context == null || jSONObject == null || (jSONObjectOptJSONObject = jSONObject.optJSONObject("data")) == null) {
            return;
        }
        a(context, a(jSONObjectOptJSONObject, (String) null));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void a(Context context, h hVar) {
        if (context == 0 || hVar == null || hVar.K() == null) {
            return;
        }
        b.a.a.a.a.a.b bVar = this.f6698c.get(hVar.K().a());
        if (bVar != null) {
            bVar.a();
        }
        if (context instanceof com.bytedance.sdk.openadsdk.core.video.d.b) {
            ((com.bytedance.sdk.openadsdk.core.video.d.b) context).Q();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.d.c
    public void a(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        if (jSONObject == null || (jSONObjectOptJSONObject = jSONObject.optJSONObject("data")) == null) {
            return;
        }
        a(a(jSONObjectOptJSONObject, (String) null), jSONObjectOptJSONObject);
    }

    private void a(h hVar, JSONObject jSONObject) {
        if (this.f6697b == null || hVar == null || hVar.K() == null) {
            return;
        }
        String strA = hVar.K().a();
        if (this.f6698c.containsKey(strA)) {
            this.f6698c.remove(strA);
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("message", "success");
                jSONObject2.put(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, "unsubscribed");
                jSONObject2.put("appad", jSONObject);
                this.f6697b.a("app_ad_event", jSONObject2);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    private b.a.a.a.a.a.b a(Context context, h hVar, JSONObject jSONObject, String str, boolean z) {
        b.a.a.a.a.a.b bVarA = b.a.a.a.a.a.c.a(context, hVar, str);
        bVarA.a(true);
        return bVarA;
    }
}
