package com.alibaba.sdk.android.feedback.a;

import com.alibaba.sdk.android.feedback.util.IUnreadCountCallback;
import com.alibaba.sdk.android.feedback.util.IWxCallback;
import com.alibaba.sdk.android.feedback.util.n;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
class f implements IWxCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ IUnreadCountCallback f3691a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ c f3692b;

    f(c cVar, IUnreadCountCallback iUnreadCountCallback) {
        this.f3692b = cVar;
        this.f3691a = iUnreadCountCallback;
    }

    @Override // com.alibaba.sdk.android.feedback.util.IWxCallback
    public void onError(int i, String str) {
        IUnreadCountCallback iUnreadCountCallback = this.f3691a;
        if (iUnreadCountCallback != null) {
            iUnreadCountCallback.onError(i, str);
            n.a("getUnreadCountFailed", "network error");
            com.alibaba.sdk.android.feedback.xblink.i.g.b("FeedbackNetwork", "getFeedbackUnreadCount error:" + str + ". This might be error of the internet settings");
        }
    }

    @Override // com.alibaba.sdk.android.feedback.util.IWxCallback
    public void onProgress(int i) {
    }

    @Override // com.alibaba.sdk.android.feedback.util.IWxCallback
    public void onSuccess(Object... objArr) {
        if (objArr != null && objArr.length > 0 && (objArr[0] instanceof String)) {
            try {
                JSONObject jSONObject = new JSONObject((String) objArr[0]);
                if (jSONObject.optInt("code") == 0) {
                    int iOptInt = jSONObject.getJSONObject("data").optInt("msgCount");
                    if (this.f3691a != null) {
                        this.f3691a.onSuccess(iOptInt);
                    }
                    n.a("getUnreadCountSuccess", null);
                    return;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                n.a("getUnreadCountFailed", "parse data error");
            }
        }
        onError(0, "");
    }
}
