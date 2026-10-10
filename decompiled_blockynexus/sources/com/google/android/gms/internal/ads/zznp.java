package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zznp {
    public static final zznp zzbgu = new zznp(new zznq[0]);
    public final int length;
    private int zzahv;
    private final zznq[] zzbgv;

    public zznp(zznq... zznqVarArr) {
        this.zzbgv = zznqVarArr;
        this.length = zznqVarArr.length;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zznp.class == obj.getClass()) {
            zznp zznpVar = (zznp) obj;
            if (this.length == zznpVar.length && Arrays.equals(this.zzbgv, zznpVar.zzbgv)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        if (this.zzahv == 0) {
            this.zzahv = Arrays.hashCode(this.zzbgv);
        }
        return this.zzahv;
    }

    public final int zza(zznq zznqVar) {
        for (int i = 0; i < this.length; i++) {
            if (this.zzbgv[i] == zznqVar) {
                return i;
            }
        }
        return -1;
    }

    public final zznq zzbd(int i) {
        return this.zzbgv[i];
    }
}
