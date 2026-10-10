package com.alibaba.sdk.android.feedback.xblink.f.b;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.alibaba.sdk.android.feedback.windvane.CustomHybirdActivity;
import com.alibaba.sdk.android.feedback.windvane.WXBaseHybridActivity;
import com.alibaba.sdk.android.feedback.xblink.f.m;
import com.google.firebase.analytics.FirebaseAnalytics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class a extends com.alibaba.sdk.android.feedback.xblink.f.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static int f3835d = 4001;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static int f3836e = 4002;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private com.alibaba.sdk.android.feedback.xblink.f.b f3837f = null;

    private void a(com.alibaba.sdk.android.feedback.xblink.f.b bVar, String str) {
        this.f3837f = bVar;
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.has("url") ? jSONObject.getString("url") : null;
            boolean z = jSONObject.has("nav") ? jSONObject.getBoolean("nav") : false;
            boolean z2 = jSONObject.has(FirebaseAnalytics.Event.LOGIN) ? jSONObject.getBoolean(FirebaseAnalytics.Event.LOGIN) : true;
            boolean z3 = jSONObject.has(WXBaseHybridActivity.EXTERNAL) ? jSONObject.getBoolean(WXBaseHybridActivity.EXTERNAL) : false;
            int i = jSONObject.has("fullScreen") ? jSONObject.getInt("fullScreen") : 0;
            Intent intent = new Intent();
            intent.setClass(this.f3802a, CustomHybirdActivity.class);
            intent.putExtra(WXBaseHybridActivity.NEED_LOGIN, z2);
            if (i == 0) {
                intent.putExtra(WXBaseHybridActivity.HIDE_TITLE, false);
            } else {
                intent.putExtra(WXBaseHybridActivity.HIDE_TITLE, true);
            }
            intent.putExtra(WXBaseHybridActivity.EXTERNAL, z3);
            intent.putExtra(WXBaseHybridActivity.NEED_SHOW_NAV, z);
            intent.putExtra("URL", string);
            if (bVar != null && bVar.a() != null) {
                String appkey = bVar.a().getAppkey();
                if (!TextUtils.isEmpty(appkey)) {
                    intent.putExtra("APPKEY", appkey);
                }
            }
            Context context = this.f3802a;
            if (context instanceof Activity) {
                ((Activity) context).startActivityForResult(intent, f3835d);
            }
        } catch (JSONException | Exception unused) {
        }
    }

    @Override // com.alibaba.sdk.android.feedback.xblink.f.a
    public void a(int i, int i2, Intent intent) {
        m mVar = new m();
        if (i == f3835d && i2 == f3836e) {
            mVar.a("url", intent.getStringExtra("url"));
            mVar.a();
            com.alibaba.sdk.android.feedback.xblink.f.b bVar = this.f3837f;
            if (bVar != null) {
                bVar.a(mVar);
            }
        }
    }

    @Override // com.alibaba.sdk.android.feedback.xblink.f.a
    public boolean a(String str, String str2, com.alibaba.sdk.android.feedback.xblink.f.b bVar) {
        if (!"createNewPage".equals(str)) {
            return false;
        }
        a(bVar, str2);
        return false;
    }
}
