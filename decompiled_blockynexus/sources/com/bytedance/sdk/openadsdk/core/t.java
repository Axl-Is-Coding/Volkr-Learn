package com.bytedance.sdk.openadsdk.core;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.TTAdManager;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.activity.TTDelegateActivity;
import com.bytedance.sdk.openadsdk.core.q;
import com.bytedance.sdk.openadsdk.utils.ab;
import com.bytedance.sdk.openadsdk.utils.z;
import com.umeng.analytics.pro.au;
import java.lang.reflect.Method;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: TTAdManagerImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class t implements TTAdManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    String f6366a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    boolean f6367b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    boolean f6368c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    String f6369d = "com.union_test.internationad";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    String f6370e = "5001121";

    private void e(String str) {
        if (TextUtils.isEmpty(str) || str.equals(this.f6366a)) {
            return;
        }
        this.f6366a = str;
        try {
            JSONObject jSONObjectA = o.f().a(new JSONObject(str));
            if (jSONObjectA == null) {
                return;
            }
            q.a aVarA = q.a.a(jSONObjectA, null);
            if (aVarA.f6353d == 20000 && aVarA.h != null && aVarA.h.c().size() > 0) {
                com.bytedance.sdk.openadsdk.core.d.h hVar = aVarA.h.c().get(0);
                this.f6367b = ab.d(hVar);
                this.f6368c = hVar.u() != null;
            }
        } catch (Throwable unused) {
        }
    }

    private String f(String str) {
        String strA = a.a(str);
        if (str != null) {
            return strA;
        }
        String strA2 = b.a();
        return strA2.concat(strA2).substring(8, 24);
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public t setAppId(String str) {
        h.b().a(str);
        com.bytedance.sdk.openadsdk.core.g.e.a(o.i()).a();
        com.bytedance.sdk.openadsdk.core.g.f.a(o.h()).c();
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public t setName(String str) {
        h.b().b(str);
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public t setKeywords(String str) {
        h.b().c(str);
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public TTAdNative createAdNative(Context context) {
        h.b().m();
        return new u(context);
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public t setData(String str) {
        h.b().d(str);
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public String getBiddingToken() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            String strE = o.h().e();
            String strF = o.h().f();
            if (!TextUtils.isEmpty(strE) && !TextUtils.isEmpty(strF)) {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("version", strE);
                jSONObject3.put("param", strF);
                jSONObject2.put("abtest", jSONObject3);
            }
            jSONObject2.put("ad_sdk_version", "3.1.5.3");
            jSONObject2.put(au.n, ab.f());
            jSONObject2.put("user_data", a());
            jSONObject2.put("ts", System.currentTimeMillis() / 1000);
            String strB = b();
            jSONObject.put("message", 2 + strB + a.a(jSONObject2.toString(), f(strB)));
            jSONObject.put("cypher", 2);
        } catch (Throwable unused) {
        }
        return jSONObject.toString();
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public int getGdpr() {
        return h.b().f();
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public String getSDKVersion() {
        return "3.1.5.3";
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public boolean isExpressAd(String str, String str2) {
        if (o.h().i(str)) {
            return true;
        }
        if (TextUtils.isEmpty(str2)) {
            return false;
        }
        e(str2);
        return this.f6368c;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public boolean isFullScreenVideoAd(String str, String str2) {
        if (o.h().j(str)) {
            return true;
        }
        if (TextUtils.isEmpty(str2)) {
            return false;
        }
        e(str2);
        return this.f6367b;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public TTAdManager isUseTextureView(boolean z) {
        h.b().d(z);
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public boolean onlyVerityPlayable(String str, int i, String str2, String str3, String str4) {
        if (!this.f6369d.equals(o.a().getPackageName()) || !this.f6370e.equals(h.b().c()) || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            Method methodA = z.a("com.bytedance.sdk.openadsdk.TTC3Proxy", "verityPlayable", String.class, Integer.TYPE, String.class, String.class, String.class);
            if (methodA != null) {
                methodA.invoke(null, str, Integer.valueOf(i), str2, str3, str4);
            }
        } catch (Throwable th) {
            com.bytedance.sdk.openadsdk.utils.o.b("TTAdManagerImpl", "reward component maybe not exist, pls check", th);
        }
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public TTAdManager openDebugMode() {
        com.bytedance.sdk.openadsdk.utils.o.b();
        com.bytedance.sdk.adnet.a.c();
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public void requestPermissionIfNecessary(Context context) {
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public TTAdManager setAllowLandingPageShowWhenScreenLock(boolean z) {
        h.b().c(z);
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public TTAdManager setAllowShowNotifiFromSDK(boolean z) {
        h.b().b(z);
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public TTAdManager setCoppa(int i) {
        h.b().a(i);
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public TTAdManager setGdpr(int i) {
        h.b().b(i);
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public TTAdManager setNeedClearTaskReset(String[] strArr) {
        h.b().a(strArr);
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public TTAdManager setTitleBarTheme(int i) {
        h.b().d(i);
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    public void showPrivacyProtection() {
        TTDelegateActivity.a();
    }

    private String b() {
        String strA = a.a();
        return strA == null ? b.a() : strA;
    }

    @Override // com.bytedance.sdk.openadsdk.TTAdManager
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public t setPaid(boolean z) {
        h.b().a(z);
        return this;
    }

    private JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("coppa", h.b().g());
            jSONObject.put("gdpr", h.b().f());
            jSONObject.put("is_gdpr_user", o.h().u());
            a(jSONObject, "keywords", h.b().i());
            a(jSONObject, "data", h.b().j());
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    private void a(JSONObject jSONObject, String str, String str2) throws JSONException {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        jSONObject.put(str, str2);
    }
}
