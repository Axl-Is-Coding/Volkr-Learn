package com.alibaba.sdk.android.feedback.a;

import com.alibaba.sdk.android.feedback.util.IWxCallback;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Map f3688a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ IWxCallback f3689b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ c f3690c;

    e(c cVar, Map map, IWxCallback iWxCallback) {
        this.f3690c = cVar;
        this.f3688a = map;
        this.f3689b = iWxCallback;
    }

    @Override // java.lang.Runnable
    public void run() {
        new com.alibaba.sdk.android.feedback.util.a.b(this.f3688a, this.f3689b, b.k() + "/getConfiguration.do").a();
    }
}
