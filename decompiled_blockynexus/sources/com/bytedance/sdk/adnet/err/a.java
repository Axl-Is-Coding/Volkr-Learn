package com.bytedance.sdk.adnet.err;

import android.content.Intent;
import com.bytedance.sdk.adnet.core.i;

/* JADX INFO: compiled from: AuthFailureError.java */
/* JADX INFO: loaded from: classes.dex */
public class a extends VAdError {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Intent f5565a;

    public a() {
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.f5565a != null ? "User needs to (re)enter credentials." : super.getMessage();
    }

    public a(i iVar) {
        super(iVar);
    }
}
