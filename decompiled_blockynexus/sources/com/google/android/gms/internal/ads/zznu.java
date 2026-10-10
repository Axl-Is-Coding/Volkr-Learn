package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public class zznu implements zzob {
    private final int length;
    private int zzahv;
    private final zzho[] zzbfo;
    private final zznq zzbgw;
    private final int[] zzbgx;
    private final long[] zzbgy;

    public zznu(zznq zznqVar, int... iArr) {
        int i = 0;
        zzoz.checkState(iArr.length > 0);
        zzoz.checkNotNull(zznqVar);
        this.zzbgw = zznqVar;
        this.length = iArr.length;
        this.zzbfo = new zzho[this.length];
        for (int i2 = 0; i2 < iArr.length; i2++) {
            this.zzbfo[i2] = zznqVar.zzbe(iArr[i2]);
        }
        Arrays.sort(this.zzbfo, new zznw());
        this.zzbgx = new int[this.length];
        while (true) {
            int i3 = this.length;
            if (i >= i3) {
                this.zzbgy = new long[i3];
                return;
            } else {
                this.zzbgx[i] = zznqVar.zzh(this.zzbfo[i]);
                i++;
            }
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zznu zznuVar = (zznu) obj;
            if (this.zzbgw == zznuVar.zzbgw && Arrays.equals(this.zzbgx, zznuVar.zzbgx)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        if (this.zzahv == 0) {
            this.zzahv = (System.identityHashCode(this.zzbgw) * 31) + Arrays.hashCode(this.zzbgx);
        }
        return this.zzahv;
    }

    @Override // com.google.android.gms.internal.ads.zzob
    public final int length() {
        return this.zzbgx.length;
    }

    @Override // com.google.android.gms.internal.ads.zzob
    public final zzho zzbe(int i) {
        return this.zzbfo[i];
    }

    @Override // com.google.android.gms.internal.ads.zzob
    public final int zzbf(int i) {
        return this.zzbgx[0];
    }

    @Override // com.google.android.gms.internal.ads.zzob
    public final zznq zzil() {
        return this.zzbgw;
    }
}
