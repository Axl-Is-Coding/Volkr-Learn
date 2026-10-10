package com.alibaba.sdk.android.feedback.a;

import com.alibaba.sdk.android.feedback.util.IUnreadCountCallback;
import com.facebook.internal.AnalyticsEvents;
import java.util.HashMap;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
public class c {
    public void a(IUnreadCountCallback iUnreadCountCallback) {
        f fVar = new f(this, iUnreadCountCallback);
        HashMap map = new HashMap();
        map.put("appkey", b.d());
        map.put("deviceId", b.f());
        new Thread(new g(this, map, fVar)).start();
    }

    public void a(Callable callable, Callable callable2) {
        HashMap map = new HashMap();
        map.put("appkey", b.d());
        map.put(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, "0");
        map.put("deviceId", b.f());
        new Thread(new e(this, map, new d(this, callable, callable2))).start();
    }
}
