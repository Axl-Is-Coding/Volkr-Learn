package com.google.android.gms.internal.ads;

import android.view.View;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzabr extends zzabw {
    private final com.google.android.gms.ads.internal.zzg zzczj;
    private final String zzczk;
    private final String zzczl;

    public zzabr(com.google.android.gms.ads.internal.zzg zzgVar, String str, String str2) {
        this.zzczj = zzgVar;
        this.zzczk = str;
        this.zzczl = str2;
    }

    @Override // com.google.android.gms.internal.ads.zzabt
    public final String getContent() {
        return this.zzczl;
    }

    @Override // com.google.android.gms.internal.ads.zzabt
    public final void recordClick() {
        this.zzczj.zzkc();
    }

    @Override // com.google.android.gms.internal.ads.zzabt
    public final void recordImpression() {
        this.zzczj.zzkd();
    }

    @Override // com.google.android.gms.internal.ads.zzabt
    public final void zzn(IObjectWrapper iObjectWrapper) {
        if (iObjectWrapper == null) {
            return;
        }
        this.zzczj.zzh((View) ObjectWrapper.unwrap(iObjectWrapper));
    }

    @Override // com.google.android.gms.internal.ads.zzabt
    public final String zzrs() {
        return this.zzczk;
    }
}
