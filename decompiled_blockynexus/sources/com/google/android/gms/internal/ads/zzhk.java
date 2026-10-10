package com.google.android.gms.internal.ads;

import android.util.Log;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzhk {
    public final int index;
    private final zzhx[] zzaep;
    private final zzog zzaeq;
    public final zzmx zzafm;
    public final Object zzafn;
    public final zznm[] zzafo;
    private final boolean[] zzafp;
    public final long zzafq;
    public int zzafr;
    public long zzafs;
    public boolean zzaft;
    public boolean zzafu;
    public boolean zzafv;
    public zzhk zzafw;
    public zzoi zzafx;
    private final zzhw[] zzafy;
    private final zzhs zzafz;
    private final zzmz zzaga;
    private zzoi zzagb;

    public zzhk(zzhx[] zzhxVarArr, zzhw[] zzhwVarArr, long j, zzog zzogVar, zzhs zzhsVar, zzmz zzmzVar, Object obj, int i, int i2, boolean z, long j2) {
        this.zzaep = zzhxVarArr;
        this.zzafy = zzhwVarArr;
        this.zzafq = j;
        this.zzaeq = zzogVar;
        this.zzafz = zzhsVar;
        this.zzaga = zzmzVar;
        zzoz.checkNotNull(obj);
        this.zzafn = obj;
        this.index = i;
        this.zzafr = i2;
        this.zzaft = z;
        this.zzafs = j2;
        this.zzafo = new zznm[zzhxVarArr.length];
        this.zzafp = new boolean[zzhxVarArr.length];
        this.zzafm = zzmzVar.zza(i2, zzhsVar.zzfd());
    }

    public final void release() {
        try {
            this.zzaga.zzb(this.zzafm);
        } catch (RuntimeException e2) {
            Log.e("ExoPlayerImplInternal", "Period release failed.", e2);
        }
    }

    public final long zza(long j, boolean z, boolean[] zArr) {
        zzod zzodVar = this.zzafx.zzbhx;
        int i = 0;
        while (true) {
            boolean z2 = true;
            if (i >= zzodVar.length) {
                break;
            }
            boolean[] zArr2 = this.zzafp;
            if (z || !this.zzafx.zza(this.zzagb, i)) {
                z2 = false;
            }
            zArr2[i] = z2;
            i++;
        }
        long jZza = this.zzafm.zza(zzodVar.zzim(), this.zzafp, this.zzafo, zArr, j);
        this.zzagb = this.zzafx;
        this.zzafv = false;
        int i2 = 0;
        while (true) {
            zznm[] zznmVarArr = this.zzafo;
            if (i2 >= zznmVarArr.length) {
                this.zzafz.zza(this.zzaep, this.zzafx.zzbhw, zzodVar);
                return jZza;
            }
            if (zznmVarArr[i2] != null) {
                zzoz.checkState(zzodVar.zzbg(i2) != null);
                this.zzafv = true;
            } else {
                zzoz.checkState(zzodVar.zzbg(i2) == null);
            }
            i2++;
        }
    }

    public final long zzb(long j, boolean z) {
        return zza(j, false, new boolean[this.zzaep.length]);
    }

    public final void zzc(int i, boolean z) {
        this.zzafr = i;
        this.zzaft = z;
    }

    public final long zzep() {
        return this.zzafq - this.zzafs;
    }

    public final boolean zzeq() {
        if (this.zzafu) {
            return !this.zzafv || this.zzafm.zzhr() == Long.MIN_VALUE;
        }
        return false;
    }

    public final boolean zzer() throws zzhd {
        boolean z;
        zzoi zzoiVarZza = this.zzaeq.zza(this.zzafy, this.zzafm.zzho());
        zzoi zzoiVar = this.zzagb;
        if (zzoiVar == null) {
            z = false;
            break;
        }
        for (int i = 0; i < zzoiVarZza.zzbhx.length; i++) {
            if (!zzoiVarZza.zza(zzoiVar, i)) {
                z = false;
                break;
            }
        }
        z = true;
        if (z) {
            return false;
        }
        this.zzafx = zzoiVarZza;
        return true;
    }
}
