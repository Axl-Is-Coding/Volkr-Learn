package com.alibaba.sdk.android.feedback.xblink.f.b;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.text.ClipboardManager;
import android.text.TextUtils;
import com.alibaba.sdk.android.feedback.xblink.f.m;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class d extends com.alibaba.sdk.android.feedback.xblink.f.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private com.alibaba.sdk.android.feedback.xblink.f.b f3839d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f3840e = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private List f3841f = new ArrayList();
    private BroadcastReceiver g = new e(this);

    private String a(String str, String str2) {
        try {
            StringBuffer stringBuffer = new StringBuffer(str);
            if (str2 == null) {
                return stringBuffer.toString();
            }
            JSONObject jSONObject = new JSONObject(str2);
            Iterator<String> itKeys = jSONObject.keys();
            int i = 0;
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                String string = jSONObject.getString(next);
                if (i == 0) {
                    stringBuffer.append("?");
                    stringBuffer.append(next);
                } else {
                    stringBuffer.append("&");
                    stringBuffer.append(next);
                }
                stringBuffer.append("=");
                stringBuffer.append(string);
                i++;
            }
            return stringBuffer.toString();
        } catch (JSONException unused) {
            return null;
        }
    }

    private void a(com.alibaba.sdk.android.feedback.xblink.f.b bVar, String str) {
        m mVar = new m();
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.has("event") ? jSONObject.getString("event") : null;
            String string2 = jSONObject.has("data") ? jSONObject.getString("data") : null;
            if (!TextUtils.isEmpty(string)) {
                if (TextUtils.isEmpty(a(string, string2))) {
                    bVar.b(mVar);
                    return;
                }
                return;
            }
        } catch (JSONException unused) {
        }
        mVar.a("HY_PARAM_ERR");
        bVar.b(mVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, String str3) {
        JSONObject jSONObject;
        m mVar = new m();
        mVar.a();
        try {
            jSONObject = new JSONObject(str3);
        } catch (JSONException unused) {
            jSONObject = null;
        }
        if (jSONObject != null) {
            mVar.a("data", jSONObject);
        } else {
            mVar.a("data", str3);
        }
        mVar.a("sourceId", str);
        if (!TextUtils.isEmpty(str2)) {
            mVar.a("fromId", str2);
        }
        com.alibaba.sdk.android.feedback.xblink.f.b bVar = this.f3839d;
        if (bVar != null) {
            com.alibaba.sdk.android.feedback.xblink.f.c.a(bVar, "WXCommunication.onNotify", mVar.b());
        }
    }

    private void b(com.alibaba.sdk.android.feedback.xblink.f.b bVar, String str) {
    }

    private void c(com.alibaba.sdk.android.feedback.xblink.f.b bVar, String str) {
    }

    private void d(com.alibaba.sdk.android.feedback.xblink.f.b bVar, String str) {
    }

    private void e(com.alibaba.sdk.android.feedback.xblink.f.b bVar, String str) {
        ClipboardManager clipboardManager = (ClipboardManager) this.f3802a.getSystemService("clipboard");
        m mVar = new m();
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.has(ViewHierarchyConstants.TEXT_KEY) ? jSONObject.getString(ViewHierarchyConstants.TEXT_KEY) : null;
            if (!TextUtils.isEmpty(string)) {
                clipboardManager.setText(string);
            }
            mVar.a();
            bVar.a(mVar);
        } catch (JSONException unused) {
            mVar.a("HY_PARAM_ERR");
            bVar.b(mVar);
        }
    }

    @Override // com.alibaba.sdk.android.feedback.xblink.f.a
    public void a() {
        super.a();
    }

    @Override // com.alibaba.sdk.android.feedback.xblink.f.a
    public void a(int i, int i2, Intent intent) {
    }

    @Override // com.alibaba.sdk.android.feedback.xblink.f.a
    public boolean a(String str, String str2, com.alibaba.sdk.android.feedback.xblink.f.b bVar) {
        if ("sendBroadcast".equals(str)) {
            b(bVar, str2);
            return true;
        }
        if ("callAction".equals(str)) {
            a(bVar, str2);
            return true;
        }
        if ("setNotifySourceId".equals(str)) {
            c(bVar, str2);
            return true;
        }
        if ("notify".equals(str)) {
            d(bVar, str2);
            return true;
        }
        if (!"copyToPasteboard".equals(str)) {
            return false;
        }
        e(bVar, str2);
        return true;
    }
}
