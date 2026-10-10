package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zznq {
    public final int length;
    private int zzahv;
    private final zzho[] zzbfo;

    public zznq(zzho... zzhoVarArr) {
        zzoz.checkState(zzhoVarArr.length > 0);
        this.zzbfo = zzhoVarArr;
        this.length = zzhoVarArr.length;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zznq.class == obj.getClass()) {
            zznq zznqVar = (zznq) obj;
            if (this.length == zznqVar.length && Arrays.equals(this.zzbfo, zznqVar.zzbfo)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        if (this.zzahv == 0) {
            this.zzahv = Arrays.hashCode(this.zzbfo) + 527;
        }
        return this.zzahv;
    }

    public final zzho zzbe(int i) {
        return this.zzbfo[i];
    }

    public final int zzh(zzho zzhoVar) {
        int i = 0;
        while (true) {
            zzho[] zzhoVarArr = this.zzbfo;
            if (i >= zzhoVarArr.length) {
                return -1;
            }
            if (zzhoVar == zzhoVarArr[i]) {
                return i;
            }
            i++;
        }
    }
}
