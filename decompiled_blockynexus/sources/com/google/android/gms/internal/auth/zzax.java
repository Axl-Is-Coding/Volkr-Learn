package com.google.android.gms.internal.auth;

import com.google.android.gms.auth.api.proxy.ProxyApi;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: loaded from: classes2.dex */
public final class zzax implements ProxyApi.SpatulaHeaderResult {
    private Status mStatus;
    private String zzci;

    public zzax(String str) {
        Preconditions.checkNotNull(str);
        this.zzci = str;
        this.mStatus = Status.RESULT_SUCCESS;
    }

    @Override // com.google.android.gms.auth.api.proxy.ProxyApi.SpatulaHeaderResult
    public final String getSpatulaHeader() {
        return this.zzci;
    }

    @Override // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.mStatus;
    }

    public zzax(Status status) {
        Preconditions.checkNotNull(status);
        this.mStatus = status;
    }
}
