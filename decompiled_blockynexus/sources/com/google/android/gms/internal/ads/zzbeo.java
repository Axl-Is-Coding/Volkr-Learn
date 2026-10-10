package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.VisibleForTesting;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbeo implements zzhs {
    private int zzbiz;
    private final zzoq zzekj;
    private long zzekk;
    private long zzekl;
    private long zzekm;
    private long zzekn;
    private boolean zzeko;

    zzbeo() {
        this(15000, 30000, 2500L, 5000L);
    }

    @VisibleForTesting
    private final void zzk(boolean z) {
        this.zzbiz = 0;
        this.zzeko = false;
        if (z) {
            this.zzekj.reset();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhs
    public final void onStopped() {
        zzk(true);
    }

    @Override // com.google.android.gms.internal.ads.zzhs
    public final void zza(zzhx[] zzhxVarArr, zznp zznpVar, zzod zzodVar) {
        this.zzbiz = 0;
        for (int i = 0; i < zzhxVarArr.length; i++) {
            if (zzodVar.zzbg(i) != null) {
                this.zzbiz += zzpq.zzbs(zzhxVarArr[i].getTrackType());
            }
        }
        this.zzekj.zzbi(this.zzbiz);
    }

    @Override // com.google.android.gms.internal.ads.zzhs
    public final synchronized boolean zzc(long j, boolean z) {
        long j2;
        j2 = z ? this.zzekn : this.zzekm;
        return j2 <= 0 || j >= j2;
    }

    public final synchronized void zzdn(int i) {
        this.zzekm = ((long) i) * 1000;
    }

    public final synchronized void zzdo(int i) {
        this.zzekn = ((long) i) * 1000;
    }

    public final synchronized void zzds(int i) {
        this.zzekk = ((long) i) * 1000;
    }

    @Override // com.google.android.gms.internal.ads.zzhs
    public final synchronized boolean zzdt(long j) {
        boolean z = false;
        char c2 = j > this.zzekl ? (char) 0 : j < this.zzekk ? (char) 2 : (char) 1;
        boolean z2 = this.zzekj.zzir() >= this.zzbiz;
        if (c2 == 2 || (c2 == 1 && this.zzeko && !z2)) {
            z = true;
        }
        this.zzeko = z;
        return this.zzeko;
    }

    @Override // com.google.android.gms.internal.ads.zzhs
    public final void zzfb() {
        zzk(false);
    }

    @Override // com.google.android.gms.internal.ads.zzhs
    public final void zzfc() {
        zzk(true);
    }

    @Override // com.google.android.gms.internal.ads.zzhs
    public final zzok zzfd() {
        return this.zzekj;
    }

    private zzbeo(int i, int i2, long j, long j2) {
        this.zzekj = new zzoq(true, 65536);
        this.zzekk = 15000000L;
        this.zzekl = 30000000L;
        this.zzekm = 2500000L;
        this.zzekn = 5000000L;
    }

    public final synchronized void zzdt(int i) {
        this.zzekl = ((long) i) * 1000;
    }
}
