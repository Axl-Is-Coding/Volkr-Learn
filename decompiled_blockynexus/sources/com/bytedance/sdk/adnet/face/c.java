package com.bytedance.sdk.adnet.face;

import com.bytedance.sdk.adnet.core.Request;
import com.bytedance.sdk.adnet.core.m;
import com.bytedance.sdk.adnet.err.VAdError;

/* JADX INFO: compiled from: IResponseDelivery.java */
/* JADX INFO: loaded from: classes.dex */
public interface c {
    void a(Request<?> request, m<?> mVar);

    void a(Request<?> request, m<?> mVar, Runnable runnable);

    void a(Request<?> request, VAdError vAdError);
}
