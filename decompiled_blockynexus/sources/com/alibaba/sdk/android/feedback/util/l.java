package com.alibaba.sdk.android.feedback.util;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
final class l implements IUnreadCountCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f3727a;

    l(Context context) {
        this.f3727a = context;
    }

    @Override // com.alibaba.sdk.android.feedback.util.IUnreadCountCallback
    public void onError(int i, String str) {
        k.a(false, this.f3727a);
    }

    @Override // com.alibaba.sdk.android.feedback.util.IUnreadCountCallback
    public void onSuccess(int i) {
        k.a(i > 0, this.f3727a);
    }
}
