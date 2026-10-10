package com.alibaba.sdk.android.feedback.util.a;

import com.alibaba.sdk.android.feedback.util.IWxCallback;

/* JADX INFO: loaded from: classes.dex */
public abstract class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected IWxCallback f3704a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected String f3705b;

    protected a(IWxCallback iWxCallback, String str) {
        this.f3704a = iWxCallback;
        this.f3705b = str;
    }

    protected abstract byte[] a();

    @Override // java.lang.Runnable
    public void run() {
        IWxCallback iWxCallback = this.f3704a;
        if (iWxCallback != null) {
            iWxCallback.onProgress(0);
        }
        a();
    }
}
