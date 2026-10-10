package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzkf {
    public final int zzaoz = 1;
    public final byte[] zzapa;

    public zzkf(int i, byte[] bArr) {
        this.zzapa = bArr;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzkf.class == obj.getClass()) {
            zzkf zzkfVar = (zzkf) obj;
            if (this.zzaoz == zzkfVar.zzaoz && Arrays.equals(this.zzapa, zzkfVar.zzapa)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (this.zzaoz * 31) + Arrays.hashCode(this.zzapa);
    }
}
