package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.VisibleForTesting;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzchh {
    public final int type;
    public final String zzcn;
    public final String zzgdu;
    public final zzadq zzgdv;

    @VisibleForTesting
    public zzchh(String str, String str2) {
        this.type = 1;
        this.zzcn = str;
        this.zzgdu = str2;
        this.zzgdv = null;
    }

    @VisibleForTesting
    public zzchh(String str, zzadq zzadqVar) {
        this.type = 2;
        this.zzcn = str;
        this.zzgdu = null;
        this.zzgdv = zzadqVar;
    }
}
