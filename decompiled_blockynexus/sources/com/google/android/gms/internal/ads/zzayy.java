package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzayy implements zzbbl {
    private final /* synthetic */ Context val$context;
    private final /* synthetic */ String zzebi;

    zzayy(zzayu zzayuVar, Context context, String str) {
        this.val$context = context;
        this.zzebi = str;
    }

    @Override // com.google.android.gms.internal.ads.zzbbl
    public final void zzes(String str) {
        com.google.android.gms.ads.internal.zzp.zzkr();
        zzayu.zzb(this.val$context, this.zzebi, str);
    }
}
