package com.alibaba.sdk.android.feedback.impl;

import com.alibaba.sdk.android.feedback.util.o;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
final class c implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Callable f3698a;

    c(Callable callable) {
        this.f3698a = callable;
    }

    @Override // java.util.concurrent.Callable
    public Object call() {
        if (com.alibaba.sdk.android.feedback.a.a.a().equals(FeedbackAPI.mConfig)) {
            return null;
        }
        o.a(com.alibaba.sdk.android.feedback.a.b.n(), com.alibaba.sdk.android.feedback.a.b.l());
        try {
            if (this.f3698a == null) {
                return null;
            }
            this.f3698a.call();
            return null;
        } catch (Exception unused) {
            return null;
        }
    }
}
