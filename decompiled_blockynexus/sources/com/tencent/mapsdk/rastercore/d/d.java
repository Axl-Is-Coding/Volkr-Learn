package com.tencent.mapsdk.rastercore.d;

import android.os.Handler;
import android.os.Message;
import com.tencent.mapsdk.rastercore.d.a;

/* JADX INFO: loaded from: classes5.dex */
final class d extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private /* synthetic */ a.AnonymousClass1 f19519a;

    d(a.AnonymousClass1 anonymousClass1) {
        this.f19519a = anonymousClass1;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        if (message != null && message.what == 1) {
            this.f19519a.l.c(this.f19519a.h);
        }
    }
}
