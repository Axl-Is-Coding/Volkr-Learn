package com.alibaba.sdk.android.feedback.xblink.f.b;

import android.os.Build;
import android.text.TextUtils;
import com.alibaba.sdk.android.feedback.xblink.f.m;
import com.alibaba.sdk.android.feedback.xblink.i.g;
import com.umeng.analytics.pro.au;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class c extends com.alibaba.sdk.android.feedback.xblink.f.a {
    private int a(String str) {
        String[] strArrSplit = str.split("\\.");
        String[] strArrSplit2 = "0.2.0".split("\\.");
        int i = 0;
        int i2 = 0;
        while (true) {
            if (i2 >= strArrSplit.length) {
                break;
            }
            Integer numValueOf = Integer.valueOf(Integer.parseInt(strArrSplit[i2]));
            Integer numValueOf2 = i2 < strArrSplit2.length ? Integer.valueOf(Integer.parseInt(strArrSplit2[i2])) : 0;
            if (numValueOf.intValue() > numValueOf2.intValue()) {
                i = 1;
                break;
            }
            if (numValueOf.intValue() < numValueOf2.intValue()) {
                i = -1;
                break;
            }
            i2++;
        }
        if (i != 0 || strArrSplit2.length <= strArrSplit.length) {
            return i;
        }
        return -1;
    }

    private void a(com.alibaba.sdk.android.feedback.xblink.f.b bVar, String str) {
        m mVar = new m();
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.has("version") ? jSONObject.getString("version") : null;
            if (TextUtils.isEmpty(string)) {
                mVar.a("HY_PARAM_ERR");
                bVar.b(mVar);
                return;
            }
            try {
                mVar.a("isHigher", a(string) + "");
                bVar.a(mVar);
            } catch (Exception unused) {
                mVar.a("HY_PARAM_ERR");
                bVar.b(mVar);
            }
        } catch (JSONException unused2) {
            mVar.a("HY_PARAM_ERR");
            bVar.b(mVar);
        }
    }

    private void b(com.alibaba.sdk.android.feedback.xblink.f.b bVar, String str) {
        m mVar = new m();
        mVar.a(au.w, "android");
        mVar.a("version", "0.2.0");
        mVar.a("clientversion", "1");
        mVar.a("osversion", Build.VERSION.RELEASE);
        if (g.a()) {
            g.a("Base", "getVersion: version=4.5.1");
        }
        bVar.a(mVar);
    }

    @Override // com.alibaba.sdk.android.feedback.xblink.f.a
    public boolean a(String str, String str2, com.alibaba.sdk.android.feedback.xblink.f.b bVar) {
        if ("getVersion".equals(str)) {
            b(bVar, str2);
            return true;
        }
        if (!"checkXBlinkSDK".equals(str)) {
            return false;
        }
        a(bVar, str2);
        return true;
    }
}
