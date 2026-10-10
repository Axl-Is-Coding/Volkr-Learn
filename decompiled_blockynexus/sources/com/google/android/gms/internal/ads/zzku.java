package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzku extends zzkr {
    public final long zzawj;
    public final List<zzkt> zzawk;
    public final List<zzku> zzawl;

    public zzku(int i, long j) {
        super(i);
        this.zzawj = j;
        this.zzawk = new ArrayList();
        this.zzawl = new ArrayList();
    }

    @Override // com.google.android.gms.internal.ads.zzkr
    public final String toString() {
        String strZzas = zzkr.zzas(this.type);
        String string = Arrays.toString(this.zzawk.toArray());
        String string2 = Arrays.toString(this.zzawl.toArray());
        StringBuilder sb = new StringBuilder(String.valueOf(strZzas).length() + 22 + String.valueOf(string).length() + String.valueOf(string2).length());
        sb.append(strZzas);
        sb.append(" leaves: ");
        sb.append(string);
        sb.append(" containers: ");
        sb.append(string2);
        return sb.toString();
    }

    public final void zza(zzkt zzktVar) {
        this.zzawk.add(zzktVar);
    }

    public final zzkt zzau(int i) {
        int size = this.zzawk.size();
        for (int i2 = 0; i2 < size; i2++) {
            zzkt zzktVar = this.zzawk.get(i2);
            if (zzktVar.type == i) {
                return zzktVar;
            }
        }
        return null;
    }

    public final zzku zzav(int i) {
        int size = this.zzawl.size();
        for (int i2 = 0; i2 < size; i2++) {
            zzku zzkuVar = this.zzawl.get(i2);
            if (zzkuVar.type == i) {
                return zzkuVar;
            }
        }
        return null;
    }

    public final void zza(zzku zzkuVar) {
        this.zzawl.add(zzkuVar);
    }
}
