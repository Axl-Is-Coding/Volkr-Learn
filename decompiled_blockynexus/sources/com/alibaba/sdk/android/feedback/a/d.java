package com.alibaba.sdk.android.feedback.a;

import com.alibaba.sdk.android.feedback.util.IWxCallback;
import com.alibaba.sdk.android.feedback.util.n;
import java.util.concurrent.Callable;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
class d implements IWxCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Callable f3685a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Callable f3686b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ c f3687c;

    d(c cVar, Callable callable, Callable callable2) {
        this.f3687c = cVar;
        this.f3685a = callable;
        this.f3686b = callable2;
    }

    @Override // com.alibaba.sdk.android.feedback.util.IWxCallback
    public void onError(int i, String str) {
        try {
            if (this.f3686b != null) {
                this.f3686b.call();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        n.a("getConfFailed", "network error");
        com.alibaba.sdk.android.feedback.xblink.i.g.a("FeedbackNetwork", "conf onError:" + str + ". This might be error of the internet settings");
    }

    @Override // com.alibaba.sdk.android.feedback.util.IWxCallback
    public void onProgress(int i) {
    }

    @Override // com.alibaba.sdk.android.feedback.util.IWxCallback
    public void onSuccess(Object... objArr) {
        if (objArr == null || objArr.length <= 0 || !(objArr[0] instanceof String)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject((String) objArr[0]);
            if (jSONObject.optInt("code") != 0) {
                if (this.f3686b != null) {
                    this.f3686b.call();
                    return;
                }
                return;
            }
            JSONObject jSONObject2 = jSONObject.getJSONObject("data");
            a.b(jSONObject2.toString());
            a.a(jSONObject2.toString());
            if (this.f3685a != null) {
                this.f3685a.call();
            }
            n.a("getConfSuccess", null);
            com.alibaba.sdk.android.feedback.xblink.i.g.a("FeedbackNetwork", "success retrieved the conf: " + jSONObject2.toString());
        } catch (Exception e2) {
            com.alibaba.sdk.android.feedback.xblink.i.g.b("FeedbackNetwork", "parse json data exception: " + e2.getMessage());
            n.a("getConfFailed", "parse data error");
            try {
                if (this.f3686b != null) {
                    this.f3686b.call();
                }
            } catch (Exception unused) {
            }
        }
    }
}
