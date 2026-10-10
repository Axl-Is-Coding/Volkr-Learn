package com.alibaba.sdk.android.feedback.xblink.f.a;

import android.graphics.Color;
import com.facebook.internal.AnalyticsEvents;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class b extends com.alibaba.sdk.android.feedback.xblink.f.a {
    @Override // com.alibaba.sdk.android.feedback.xblink.f.a
    public boolean a(String str, String str2, com.alibaba.sdk.android.feedback.xblink.f.b bVar) {
        if (!str.contentEquals("setToolBar")) {
            return false;
        }
        com.alibaba.sdk.android.feedback.xblink.i.g.a("WVToolBarManager", "FeedbackAPI setToolBar " + str2);
        try {
            JSONObject jSONObject = new JSONObject(str2).getJSONObject("navbar").getJSONObject(AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE);
            com.alibaba.sdk.android.feedback.util.k.a(Color.parseColor(jSONObject.getString("color")));
            com.alibaba.sdk.android.feedback.util.k.b(Color.parseColor(jSONObject.getString("backgroundColor")));
        } catch (Exception unused) {
        }
        this.f3803b.onMessage(406, str2);
        return true;
    }
}
