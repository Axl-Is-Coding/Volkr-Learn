package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zznn extends zzhy {
    private static final Object zzbgp = new Object();
    private final boolean zzais;
    private final boolean zzait;
    private final long zzbgq;
    private final long zzbgr;
    private final long zzbgs;
    private final long zzbgt;

    public zznn(long j, boolean z) {
        this(j, j, 0L, 0L, z, false);
    }

    @Override // com.google.android.gms.internal.ads.zzhy
    public final zzid zza(int i, zzid zzidVar, boolean z, long j) {
        zzoz.zzc(i, 0, 1);
        boolean z2 = this.zzais;
        long j2 = this.zzbgr;
        zzidVar.zzaig = null;
        zzidVar.zzaiq = -9223372036854775807L;
        zzidVar.zzair = -9223372036854775807L;
        zzidVar.zzais = z2;
        zzidVar.zzait = false;
        zzidVar.zzaiw = 0L;
        zzidVar.zzaih = j2;
        zzidVar.zzaiu = 0;
        zzidVar.zzaiv = 0;
        zzidVar.zzaix = 0L;
        return zzidVar;
    }

    @Override // com.google.android.gms.internal.ads.zzhy
    public final int zzc(Object obj) {
        return zzbgp.equals(obj) ? 0 : -1;
    }

    @Override // com.google.android.gms.internal.ads.zzhy
    public final int zzff() {
        return 1;
    }

    @Override // com.google.android.gms.internal.ads.zzhy
    public final int zzfg() {
        return 1;
    }

    private zznn(long j, long j2, long j3, long j4, boolean z, boolean z2) {
        this.zzbgq = j;
        this.zzbgr = j2;
        this.zzbgs = 0L;
        this.zzbgt = 0L;
        this.zzais = z;
        this.zzait = false;
    }

    @Override // com.google.android.gms.internal.ads.zzhy
    public final zzia zza(int i, zzia zziaVar, boolean z) {
        zzoz.zzc(i, 0, 1);
        Object obj = z ? zzbgp : null;
        return zziaVar.zza(obj, obj, 0, this.zzbgq, 0L, false);
    }
}
