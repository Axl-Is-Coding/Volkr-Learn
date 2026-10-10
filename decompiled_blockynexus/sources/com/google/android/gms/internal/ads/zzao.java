package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public class zzao extends Exception {
    private long zzao;
    private final zzy zzbv;

    public zzao() {
        this.zzbv = null;
    }

    final void zza(long j) {
        this.zzao = j;
    }

    public zzao(zzy zzyVar) {
        this.zzbv = zzyVar;
    }

    public zzao(String str) {
        super(str);
        this.zzbv = null;
    }

    public zzao(Throwable th) {
        super(th);
        this.zzbv = null;
    }
}
