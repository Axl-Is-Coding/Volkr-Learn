package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzoq implements zzok {
    private final boolean zzbiv;
    private final int zzbiw;
    private final byte[] zzbix;
    private final zzoh[] zzbiy;
    private int zzbiz;
    private int zzbja;
    private int zzbjb;
    private zzoh[] zzbjc;

    public zzoq(boolean z, int i) {
        this(true, 65536, 0);
    }

    public final synchronized void reset() {
        if (this.zzbiv) {
            zzbi(0);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzok
    public final synchronized void zza(zzoh zzohVar) {
        this.zzbiy[0] = zzohVar;
        zza(this.zzbiy);
    }

    public final synchronized void zzbi(int i) {
        boolean z = i < this.zzbiz;
        this.zzbiz = i;
        if (z) {
            zzn();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzok
    public final synchronized zzoh zzin() {
        zzoh zzohVar;
        this.zzbja++;
        if (this.zzbjb > 0) {
            zzoh[] zzohVarArr = this.zzbjc;
            int i = this.zzbjb - 1;
            this.zzbjb = i;
            zzohVar = zzohVarArr[i];
            this.zzbjc[this.zzbjb] = null;
        } else {
            zzohVar = new zzoh(new byte[this.zzbiw], 0);
        }
        return zzohVar;
    }

    @Override // com.google.android.gms.internal.ads.zzok
    public final int zzio() {
        return this.zzbiw;
    }

    public final synchronized int zzir() {
        return this.zzbja * this.zzbiw;
    }

    @Override // com.google.android.gms.internal.ads.zzok
    public final synchronized void zzn() {
        int iMax = Math.max(0, zzpq.zzf(this.zzbiz, this.zzbiw) - this.zzbja);
        if (iMax >= this.zzbjb) {
            return;
        }
        Arrays.fill(this.zzbjc, iMax, this.zzbjb, (Object) null);
        this.zzbjb = iMax;
    }

    private zzoq(boolean z, int i, int i2) {
        zzoz.checkArgument(true);
        zzoz.checkArgument(true);
        this.zzbiv = true;
        this.zzbiw = 65536;
        this.zzbjb = 0;
        this.zzbjc = new zzoh[100];
        this.zzbix = null;
        this.zzbiy = new zzoh[1];
    }

    @Override // com.google.android.gms.internal.ads.zzok
    public final synchronized void zza(zzoh[] zzohVarArr) {
        if (this.zzbjb + zzohVarArr.length >= this.zzbjc.length) {
            this.zzbjc = (zzoh[]) Arrays.copyOf(this.zzbjc, Math.max(this.zzbjc.length << 1, this.zzbjb + zzohVarArr.length));
        }
        for (zzoh zzohVar : zzohVarArr) {
            zzoz.checkArgument(zzohVar.data == null || zzohVar.data.length == this.zzbiw);
            zzoh[] zzohVarArr2 = this.zzbjc;
            int i = this.zzbjb;
            this.zzbjb = i + 1;
            zzohVarArr2[i] = zzohVar;
        }
        this.zzbja -= zzohVarArr.length;
        notifyAll();
    }
}
